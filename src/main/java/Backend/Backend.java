package Backend;

import Technical_Services.ICommodityBatchDTO;
import Technical_Services.IProductionBatchDTO;
import Technical_Services.IRecipeDTO;
import Technical_Services.IUserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public boolean readUser(int id) throws SQLException {
        String query = "SELECT* Where user_id = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1,id);
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean updateUser(IUserDTO user) throws SQLException {
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
    //TODO maybe change the query
        String query = "INSERT INTO recipe(id_user, recipeName" +
                "date, isINUse ) " +
                "VALUES(?, ?, ?, ?)";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1, recipe.getRecipeId());
        psQuery.setString(2, recipe.getRecipeName());
        psQuery.setObject(3, recipe.getRecipeDate());
        psQuery.setBoolean(4, recipe.getIsRecipeInUse());
        boolean success = psQuery.execute();
        return success;
    }

    @Override
    public boolean readRecipe(int id) throws SQLException {
        //TODO Maybe change to Query
        String query = "SELECT* Where recipe_id = ?";
        PreparedStatement psQuery = con.prepareStatement(query);
        psQuery.setInt(1,id);
        boolean success = psQuery.execute();
        return success;
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
