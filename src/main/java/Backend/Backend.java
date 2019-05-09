package Backend;

import Technical_Services.*;

import java.sql.*;

public class Backend implements IDal {

    private static Connection con;

    public Backend() throws SQLException {
    }

    public void createConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/chbu?"
                + "user=s185140&password=YKl6EOAgNqhvE0fjJ0uJX");
    }
    public void closeConnection() throws SQLException {
        con.close();
    }


    //User
    @Override
    public boolean addUser(IUserDTO user) throws SQLException {
        con.setAutoCommit(true);
        String query = "INSERT INTO user(id_user, userName, " +
                "userPass, jobTitle, isAdmin) " +
                "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, user.getUserId());
        psQuery.setString(2, user.getUsername());
        psQuery.setString(3, user.getPassword());
        psQuery.setString(4, user.getRole());
        psQuery.setBoolean(5, user.isAdmin());
        boolean success = psQuery.execute();
        return success;
    }
    @Override
    public UserDTO readUser(int id) throws SQLException {
        con.setAutoCommit(true);
        String query = "SELECT * Where user_id = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);

        ResultSet r = psQuery.executeQuery();
        r.next();
        return new UserDTO(r.getString("username"), r.getString("password"),
                r.getString("job_title"), r.getBoolean("is_in_use"));
    }

    @Override
    public boolean updateUser(IUserDTO user) throws SQLException {
        con.setAutoCommit(true);
        String query = "UPDATE user" +
                "SET userName = ?, userPass = ?, jobTitle = ?," +
                " isAdmin = ? " + "WHERE id_user = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setString(1, user.getUsername());
        psQuery.setString(2, user.getPassword());
        psQuery.setString(3, user.getRole());
        psQuery.setBoolean(4, user.isAdmin());
        psQuery.setInt(5, user.getUserId());

        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        con.setAutoCommit(true);
        String query = "DELETE FROM user " +
                "WHERE id_user = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        return success;
    }


    //Recipe

    @Override
    public boolean addRecipe(IRecipeDTO recipe) throws SQLException {
        try {
            con.setAutoCommit(false); //starts a transaction
            boolean success;

            //set the recipe
            String query1 = "INSERT INTO recipe(id_recipe, recipeName, " +
                    "date, is_in_use ) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement prepStatement1 = con.prepareStatement(query1);
            prepStatement1.setInt(1, recipe.getRecipeId());
            prepStatement1.setString(2, recipe.getRecipeName());
            prepStatement1.setObject(3, recipe.getRecipeDate());
            prepStatement1.setBoolean(4, recipe.getIsRecipeInUse());
            success = prepStatement1.execute();
            prepStatement1.close();
            if (!success) throw new SQLException();

            //set all the ingredients
            String query2 = "INSERT INTO ingredient(id_recipe, id_com, amount, timestamp) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement prepStatement2 = con.prepareStatement(query2);
            for (IIngredientDTO i : recipe.getIngredients()) {
                prepStatement2.setInt(1, recipe.getRecipeId());
                prepStatement2.setInt(2, i.getComodityId());
                prepStatement2.setDouble(3, i.getAmount());
                prepStatement2.setDate(4, recipe.getRecipeDate());
                success = prepStatement2.execute();
                prepStatement2.clearParameters();
                if (!success) throw new SQLException();
            }
            prepStatement2.close();
            con.commit();
            return true;
        } catch (SQLException e) {
            con.rollback();
            return false;
        }
    }

    @Override
    public RecipeDTO readRecipe(int id) throws SQLException {
        //TODO figure out how to write this query
        String query = "SELECT id_recipe, recipeName, date, is_in_use, id_com, name, amount FROM recipe JOIN   Where recipe_id = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1,id);
    }

    @Override
    public boolean updateRecipe(IRecipeDTO recipe) throws SQLException {
        //TODO Maybe change to Query
        String query = "UPDATE recipe" +
                "SET recipeName = ?, recipedate = ?," +
                "isInUse= ? " +
                "WHERE id_recipe = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setString(1, recipe.getRecipeName());
        //TODO setobject?
        psQuery.setObject(2, recipe.getRecipeDate());
        psQuery.setBoolean(3, recipe.getIsRecipeInUse());
        psQuery.setInt(4, recipe.getRecipeId());
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean deleteRecipe(int id) throws SQLException {
        //TODO Maybe change to Query
        String query = "DELETE FROM recipe " +
                "WHERE id_recipe = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        return success;
    }


    //Production Batch
    @Override
    public boolean addProductionBatch(IProductionBatchDTO pBatch) throws SQLException {
        String query = "INSERT INTO production_batch(id_production_batch, " +
                "id_recipe, batch_size, time_stamp) " +
                "VALUES(?, ?, ?, ?)";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, pBatch.getIdProdBatch());
        psQuery.setInt(2, pBatch.getIdRec());
        psQuery.setInt(3, pBatch.getBatchSize());
        psQuery.setDate(4, pBatch.getDate());
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean readProductionBatch(int id) throws SQLException {
        String query ="SELECT * FROM production_batch" +
                "WHERE id_production_batch = ?";

        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean updateProductionBatch(IProductionBatchDTO pBatch) throws SQLException {
        String query = "UPDATE production_batch" +
                "SET batch_size = ?, time_stamp = ?," +
                "WHERE id_production_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, pBatch.getBatchSize());
        psQuery.setDate(2, pBatch.getDate());
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean deleteProductionBatch(int id) throws SQLException {
        //TODO Maybe change to Query
        String query = "DELETE FROM productionBatch" +
                "WHERE id_production_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        return success;
    }


    //Commodity Batch
    @Override
    public boolean addCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException {
        String query = "INSERT INTO commodity_batch(id_com_batch, id_com," +
                "amount, isRest, time_stamp) " +
                "VALUES(?, ?, ?, ?,?)";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, cBatch.getIdComBatch());
        psQuery.setInt(2, cBatch.getIdCom());
        psQuery.setFloat(3, cBatch.getAmount());
        psQuery.setBoolean(4, cBatch.getRest());
        psQuery.setDate(5,cBatch.getCommodityBatchDate());
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean readCommodityBatch(int id) throws SQLException {
        String query ="SELECT * FROM commodity_batch" +
                "WHERE id_com_batch = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean updateCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException {
        //TODO Maybe change to Query
        String query = "UPDATE commodity_batch" +
                "SET amount = ?, isRest= ?," +
                "time_stamp= ? " +
                "WHERE id_com_batch = ?";

        PreparedStatement psQuery = con.prepareStatement(query);

        psQuery.setFloat(1,cBatch.getAmount());
        psQuery.setBoolean(2, cBatch.getRest());
        psQuery.setDate(3, cBatch.getCommodityBatchDate());
        psQuery.setInt(4, cBatch.getIdComBatch());
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean deleteCommodityBatch(int id) throws SQLException {
        //TODO Maybe change to Query
        String query = "DELETE FROM commodityBatch" +
                "WHERE id_recipe = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, id);
        boolean success = psQuery.execute();
        return success;
    }
}
