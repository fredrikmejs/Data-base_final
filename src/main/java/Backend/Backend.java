package Backend;

import Technical_Services.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Backend implements IDal {

    private static Connection con;

    public void createConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185140?"
                + "user=s185140&password=YKl6EOAgNqhvE0fjJ0uJX");
    }
    public void closeConnection() throws SQLException {
        con.close();
    }


    //########    User    ########
    @Override
    public boolean addUser(IUserDTO user) throws SQLException {
        createConnection();
        con.setAutoCommit(true);
        String query = "INSERT INTO user(id_user, username, " +
                "password, job_title, admin) " +
                "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, user.getUserId());
        psQuery.setString(2, user.getUsername());
        psQuery.setString(3, user.getPassword());
        psQuery.setString(4, user.getRole());
        psQuery.setBoolean(5, user.isAdmin());
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }
    @Override
    public IUserDTO readUser(int id) throws SQLException {
        createConnection();
        con.setAutoCommit(true);
        String query = "SELECT * FROM user Where id_user = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);

        ResultSet r = psQuery.executeQuery();
        r.next();
        IUserDTO user = new UserDTO(r.getString("username"), r.getString("password"),
                r.getString("job_title"), r.getBoolean("admin"));
        closeConnection();
        return user;
    }

    @Override
    public boolean updateUser(IUserDTO user) throws SQLException {
        createConnection();
        con.setAutoCommit(true);
        String query = "UPDATE user " +
                "SET username = ?, password = ?, job_title = ?, admin = ? " +
                "WHERE id_user = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setString(1, user.getUsername());
        psQuery.setString(2, user.getPassword());
        psQuery.setString(3, user.getRole());
        psQuery.setBoolean(4, user.isAdmin());
        psQuery.setInt(5, user.getUserId());
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        createConnection();
        String query = "DELETE FROM user " +
                "WHERE id_user = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }

    @Override
    public List<IUserDTO> getUserList() throws SQLException {
        createConnection();
        String query = "SELECT * FROM user ORDER BY id_user";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        List<IUserDTO> list = new ArrayList<IUserDTO>();
        while (rs.next()) {
            list.add(new UserDTO(
                    rs.getInt("id_user"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("job_title"),
                    rs.getBoolean("admin")
            ));
        }
        closeConnection();
        return list;
    }


    //#########    Recipe     #########

    @Override
    public boolean addRecipe(IRecipeDTO recipe) throws SQLException {
        createConnection();
        try {
            con.setAutoCommit(false); //starts a transaction
            boolean success;

            //set the recipe
            String query1 = "INSERT INTO recipe(id_recipe, name, " +
                    "time_stamp, is_in_use ) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement prepStatement1 = con.prepareStatement(query1);
            prepStatement1.setInt(1, recipe.getRecipeId());
            prepStatement1.setString(2, recipe.getRecipeName());
            prepStatement1.setObject(3, recipe.getRecipeDate());
            prepStatement1.setBoolean(4, recipe.getIsRecipeInUse());
            prepStatement1.execute();
            prepStatement1.close();


            //set all the ingredients
            String query2 = "INSERT INTO ingredient(id_recipe, id_com, amount, time_stamp) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement prepStatement2 = con.prepareStatement(query2);
            for (IIngredientDTO i : recipe.getIngredients()) {
                prepStatement2.setInt(1, recipe.getRecipeId());
                prepStatement2.setInt(2, i.getCommodityId());
                prepStatement2.setDouble(3, i.getAmount());
                prepStatement2.setDate(4, recipe.getRecipeDate());
                prepStatement2.execute();
                prepStatement2.clearParameters();
            }
            prepStatement2.close();
            con.commit(); //end transaction by comiting
            con.close();
            return true;
        } catch (SQLException e) {
            con.rollback(); //end transaction by rolling back changes
            con.close();
            return false;
        }
    }

    @Override
    public IRecipeDTO readCurrentRecipe(int id) throws SQLException {
        createConnection();
        String query = "SELECT * FROM get_all_recipes WHERE id_recipe = ? AND is_in_use = TRUE";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        ResultSet rs = psQuery.executeQuery();
        rs.next();

        IRecipeDTO recipe = new RecipeDTO(
                rs.getInt("id_recipe"),
                rs.getString("name"),
                rs.getDate("time_stamp"),
                rs.getBoolean("is_in_use")
        );
        List<IIngredientDTO> ingredients = new ArrayList<IIngredientDTO>();
        ingredients.add(new IngredientDTO(
                rs.getString("commodity"),
                rs.getInt("id_com"),
                rs.getDouble("amount")
        ));
        while (rs.next()) {
            ingredients.add(new IngredientDTO(
                    rs.getString("commodity"),
                    rs.getInt("id_com"),
                    rs.getDouble("amount")
            ));
        }
        recipe.setIngredients(ingredients);
        closeConnection();
        return recipe;
    }

    @Override
    public boolean updateRecipe(IRecipeDTO recipe) throws SQLException {
        createConnection();
        try {
            con.setAutoCommit(false);

            //set the previous version to not in use
            String query = "UPDATE recipe SET is_in_use = FALSE WHERE id_recipe = ? AND is_in_use = TRUE";
            PreparedStatement prepStat = con.prepareStatement(query);
            prepStat.setInt(1, recipe.getRecipeId());
            if (!prepStat.execute()) throw new SQLException();

            //Add the new recipe
            if (!addRecipe(recipe)) throw new SQLException();

            con.commit();
            con.close();
            return true;
        } catch (SQLException e) {
            con.rollback();
            con.close();
            return false;
        }
    }

    @Override
    public boolean deleteRecipe(int id, Date timestamp) throws SQLException {
        createConnection();
        try {
            con.setAutoCommit(false);

            //Delete all ingredients from the recipe
            String query = "DELETE FROM ingredient WHERE id_recipe = ? AND time_stamp = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, timestamp);
            if (!preparedStatement.execute()) throw new SQLException();

            //Delete the recipe it self
            String query1 = "DELETE FROM recipe WHERE id_recipe = ? AND time_stamp = ?";
            PreparedStatement preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setInt(1, id);
            preparedStatement1.setDate(2, timestamp);
            if (!preparedStatement1.execute()) throw new SQLException();

            con.commit();
            con.close();
            return true;

        } catch (SQLException e) {
            con.rollback();
            con.close();
            return false;
        }
    }




    //###########    Production Batch    #############

    @Override
    public boolean addProductionBatch(IProductionBatchDTO pBatch) throws SQLException {
        createConnection();
        String query = "INSERT INTO production_batch(id_production_batch, " +
                "id_recipe, batch_size, time_stamp) " +
                "VALUES(?, ?, ?, ?)";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, pBatch.getIdProdBatch());
        psQuery.setInt(2, pBatch.getIdRec());
        psQuery.setInt(3, pBatch.getBatchSize());
        psQuery.setDate(4, pBatch.getDate());
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }

    @Override
    public IProductionBatchDTO readProductionBatch(int id) throws SQLException {
        createConnection();
        String query = "SELECT * FROM get_production_batch " +
                "WHERE id_production_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        ResultSet rs = psQuery.executeQuery();
        rs.next();
        IProductionBatchDTO prodBatch = new productionBatchDTO(
                rs.getInt("id_production_batch"),
                rs.getInt("id_recipe"),
                rs.getString("recipe"),
                rs.getInt("batch_size"),
                rs.getDate("time_stamp")
                );

        con.close();
        return prodBatch;
    }

    @Override
    public boolean updateProductionBatch(IProductionBatchDTO pBatch) throws SQLException {
        createConnection();
        String query = "UPDATE production_batch " +
                "SET batch_size = ?, time_stamp = ? " +
                "WHERE id_production_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, pBatch.getBatchSize());
        psQuery.setDate(2, pBatch.getDate());
        psQuery.setInt(3, pBatch.getIdProdBatch());
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }

    @Override
    public boolean deleteProductionBatch(int id) throws SQLException {
        createConnection();
        String query = "DELETE FROM production_batch " +
                "WHERE id_production_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }





    //##########   Commodity Batch   ###########

    @Override
    public boolean addCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException {
        createConnection();
        String query = "INSERT INTO commodity_batch" +
                "(id_com_batch, id_com, amount, is_remainder, time_stamp) " +
                "VALUES(?, ?, ?, ?,?)";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, cBatch.getIdComBatch());
        psQuery.setInt(2, cBatch.getIdCom());
        psQuery.setDouble(3, cBatch.getAmount());
        psQuery.setBoolean(4, cBatch.getRest());
        psQuery.setDate(5,cBatch.getCommodityBatchDate());
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }

    @Override
    public ICommodityBatchDTO readCommodityBatch(int id) throws SQLException {
        createConnection();
        String query ="SELECT * FROM get_commodity_batches " +
                "WHERE id_com_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        ResultSet rs = psQuery.executeQuery();
        rs.next();
        ICommodityBatchDTO batch = new CommodityBatchDTO(
                rs.getInt("id_com_batch"),
                rs.getInt("id_com"),
                rs.getString("name"),
                rs.getDouble("amount"),
                rs.getDate("time_stamp"),
                rs.getBoolean("is_remainder")
                );

        closeConnection();
        return batch;

    }

    @Override
    public boolean updateCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException {
        createConnection();
        String query = "UPDATE commodity_batch " +
                "SET amount = ?, is_remainder = ?, " +
                "time_stamp= ? " +
                "WHERE id_com_batch = ?";

        PreparedStatement psQuery = con.prepareStatement(query);

        psQuery.setDouble(1,cBatch.getAmount());
        psQuery.setBoolean(2, cBatch.getRest());
        psQuery.setDate(3, cBatch.getCommodityBatchDate());
        psQuery.setInt(4, cBatch.getIdComBatch());
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }

    @Override
    public boolean deleteCommodityBatch(int id) throws SQLException {
        createConnection();
        String query = "DELETE FROM commodity_batch " +
                "WHERE id_com_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        closeConnection();
        return success;
    }
}
