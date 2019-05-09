package Backend;

import Technical_Services.IComodityBatchDTO;
import Technical_Services.IProductionBatchDTO;
import Technical_Services.IRecipeDTO;
import Technical_Services.IUserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Backend implements IDal {

    private static Connection con;

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

        String query = "INSERT INTO user(id_user, userName, userPass, jobTitle, isAdmin) " +
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
                "SET userName = ?, userPass = ?, jobTitle = ?, isAdmin = ? " +
                "WHERE id_user = ?";
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
    public boolean addRecipe(IRecipeDTO recipe) {
        return false;
    }

    @Override
    public boolean readRecipe(int id) {
        return false;
    }

    @Override
    public boolean updateRecipe(IRecipeDTO recipe) {
        return false;
    }

    @Override
    public boolean deleteRecipe(int id) {
        return false;
    }


    //Production Batch
    @Override
    public boolean addProductionBatch(IProductionBatchDTO pBatch) {
        return false;
    }

    @Override
    public boolean readProductionBatch(int id) {
        return false;
    }

    @Override
    public boolean updateProductionBatch(IProductionBatchDTO pBatch) {
        return false;
    }

    @Override
    public boolean deleteProductionBatch(int id) {
        return false;
    }


    //Comodity Batch
    @Override
    public boolean addComodityBatch(IComodityBatchDTO cBatch) {
        return false;
    }

    @Override
    public boolean readComodityBatch(int id) {
        return false;
    }

    @Override
    public boolean updateComodityBatch(IComodityBatchDTO cBatch) {
        return false;
    }

    @Override
    public boolean deleteComodityBatch(int id) {
        return false;
    }
}
