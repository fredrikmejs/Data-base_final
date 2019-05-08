package Backend;
import Technical_Services.*;
public interface IDal {
    //CRUD for each

    //User
    boolean addUser(IUserDTO user);
    boolean readUser(int id);
    boolean updateUser(IUserDTO user);
    boolean deleteUser(int id);

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
