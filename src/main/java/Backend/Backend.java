package Backend;

import Technical_Services.IComodityBatchDTO;
import Technical_Services.IProductionBatchDTO;
import Technical_Services.IRecipeDTO;
import Technical_Services.IUserDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Backend implements IDal {

    private static Connection con;

    public void createConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/chbu?"
                + "user=s185140&password=YKl6EOAgNqhvE0fjJ0uJX");
    }


    @Override
    public boolean addUser(IUserDTO user) {
        return false;
    }

    @Override
    public boolean readUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(IUserDTO user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

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
