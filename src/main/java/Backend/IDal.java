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
    boolean addRecipe(IRecipeDTO recipe);
    boolean readRecipe(int id);
    boolean updateRecipe(IRecipeDTO recipe);
    boolean deleteRecipe(int id);

    //Production Batch
    boolean addProductionBatch(IProductionBatchDTO pBatch);
    boolean readProductionBatch(int id);
    boolean updateProductionBatch(IProductionBatchDTO pBatch);
    boolean deleteProductionBatch(int id);

    //Comodity Batch
    boolean addComodityBatch(IComodityBatchDTO cBatch);
    boolean readComodityBatch(int id);
    boolean updateComodityBatch(IComodityBatchDTO cBatch);
    boolean deleteComodityBatch(int id);
}
