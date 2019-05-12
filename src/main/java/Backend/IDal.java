package Backend;
import Technical_Services.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface IDal {
    //CRUD for each

    //User
    boolean addUser(IUserDTO user) throws SQLException;
    IUserDTO readUser(int id) throws SQLException;
    boolean updateUser(IUserDTO user) throws SQLException;
    boolean deleteUser(int id) throws SQLException;
    List<IUserDTO> getUserList() throws SQLException;

    //Recipe
    boolean addRecipe(IRecipeDTO recipe) throws SQLException;
    IRecipeDTO readCurrentRecipe(int id) throws SQLException;
    boolean updateRecipe(IRecipeDTO recipe) throws SQLException;
    boolean deleteRecipe(int id, Date timestamp) throws SQLException;

    //Production Batch
    boolean addProductionBatch(IProductionBatchDTO pBatch) throws SQLException;
    IProductionBatchDTO readProductionBatch(int id) throws SQLException;
    boolean updateProductionBatch(IProductionBatchDTO pBatch) throws SQLException;
    boolean deleteProductionBatch(int id) throws SQLException;

    //Commodity Batch
    boolean addCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException;
    ICommodityBatchDTO readCommodityBatch(int id) throws SQLException;
    boolean updateCommodityBatch(ICommodityBatchDTO cBatch) throws SQLException;
    boolean deleteCommodityBatch(int id) throws SQLException;
}
