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
    boolean addProductionBatch(IProductionBachDTO pBatch);
    boolean readProductionBatch(int id);
    boolean updateProductionBatch(IProductionBachDTO pBatch);
    boolean deleteProductionBatch(int id);

    //Comodity Batch
    boolean addComodityBatch(IComodityBachDTO cBatch);
    boolean readComodityBatch(int id);
    boolean updateComodityBatch(IComodityBachDTO cBatch);
    boolean deleteComodityBatch(int id);
}
