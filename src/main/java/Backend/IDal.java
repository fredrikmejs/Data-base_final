package Backend;
import Technical_Services.*;

import java.sql.SQLException;

public interface IDal {
    //CRUD for each

    //User
    boolean addUser(IUserDTO user) throws SQLException;
    boolean readUser(int id) throws SQLException;
    boolean updateUser(IUserDTO user) throws SQLException;
    boolean deleteUser(int id) throws SQLException;

    //Recipe
    boolean addRecipe(IRecipeDTO recipe) throws SQLException;
    boolean readRecipe(int id) throws SQLException;
    boolean updateRecipe(IRecipeDTO recipe) throws SQLException;
    boolean deleteRecipe(int id) throws SQLException;

    //Production Batch
    boolean addProductionBatch(IProductionBatchDTO pBatch) throws SQLException;
    boolean readProductionBatch(int id) throws SQLException;
    boolean updateProductionBatch(IProductionBatchDTO pBatch) throws SQLException;
    boolean deleteProductionBatch(int id) throws SQLException;

    //Commodity Batch
    boolean addCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException;
    boolean readCommodityBatch(int id) throws SQLException;
    boolean updateCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException;
    boolean deleteCommodityBatch(int id) throws SQLException;
}
