package Backend;

import Technical_Services.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import org.junit.jupiter.api.Assertions;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.DEFAULT)
class BackendTest {


    @Test
    void connection() throws SQLException {
        Backend dal = new Backend();
        dal.createConnection();
        dal.closeConnection();
    }


    //#########   user    ##########

    @Test
    void user() throws SQLException {
        //add
        Backend dal = new Backend();
        UserDTO uOut = new UserDTO("Dumbledoor", "Lemon Drop", "Produktionsleder", true);
        dal.addUser(uOut);

        //read
        IUserDTO uIn = dal.readUser(0);
        System.out.println(uIn.getUserId() + "\t" + uIn.getUsername() + "\t" + uIn.getPassword() + "\t" + uIn.getRole() + "\t" + uIn.isAdmin());
        System.out.println("\n-----------------------------------------");

        //update
        UserDTO uUpdate = new UserDTO(0,"Dumbledoor", "Sherbet Lemon", "Produktionsleder", true);
        dal.updateUser(uUpdate);

        //list
        List<IUserDTO> list = dal.getUserList();

        for (IUserDTO u : list) {
            System.out.println(u.getUserId() + "\t" + u.getUsername() + "\t" + u.getPassword() + u.getRole() + "\t" + u.isAdmin());
        }
        System.out.println("\n-----------------------------------------");

        //delete
        dal.deleteUser(1);
    }



    //#########   recipe    ##########


    @Test
    void recipe() throws SQLException {
        //add
        Backend dal = new Backend();
        RecipeDTO rOut = new RecipeDTO(10, "Minor potion of flight", new Date(2019, 5, 10), true);
        List<IIngredientDTO> l = new ArrayList<IIngredientDTO>();
        l.add(new IngredientDTO("this is not the name", 3, 5));
        l.add(new IngredientDTO("", 5, 10));
        rOut.setIngredients(l);
        dal.addRecipe(rOut);

        //read
        IRecipeDTO rIn = dal.readCurrentRecipe(10);
        System.out.println(rIn.getRecipeId() + "\t" + rIn.getRecipeName() + "\t" + rIn.getRecipeDate() + "\n" + rIn.getIsRecipeInUse());
        for (IIngredientDTO i : rIn.getIngredients()) {
            System.out.println("\t" + i.getCommodityId() + "\t" + i.getName() + "\t" + i.getAmount());
        }
        System.out.println("\n-----------------------------------------");


        //update
        RecipeDTO rUpdate = new RecipeDTO(10, "Minor potion of flight", new Date(2019, 5, 12), true);
        List<IIngredientDTO> l2 = new ArrayList<IIngredientDTO>();
        l2.add(new IngredientDTO("this is not the name", 3, 5));
        l2.add(new IngredientDTO("", 5, 10));
        rUpdate.setIngredients(l2);
        dal.updateRecipe(rUpdate);

        //delete
        dal.deleteRecipe(10, new Date(2019, 5, 10));
        dal.deleteRecipe(10, new Date(2019, 5, 12));
    }


    //#########   production batch    ##########

    @Test
    void productionBatch() throws SQLException {
        //add
        Backend dal = new Backend();
        IProductionBatchDTO batchOut = new ProductionBatchDTO(10, 1, "not the name", 200, new Date(2019, 5, 12));
        dal.addProductionBatch(batchOut);

        //read
        IProductionBatchDTO batchIn = dal.readProductionBatch(10);

        System.out.println(batchIn.getIdProdBatch() + "\t" + batchIn.getIdRec() + "\t" + batchIn.getRecipeName() + "\t" + batchIn.getBatchSize() + "\t" +batchIn.getDate());
        System.out.println("\n-----------------------------------------");

        //update
        IProductionBatchDTO batchUpdate = new ProductionBatchDTO(10, 1, "not the name", 250, new Date(2019, 5, 12));
        dal.updateProductionBatch(batchUpdate);

        //delete
        dal.deleteProductionBatch(10);
    }



    //#########   commodity batch    ##########


    @Test
    void commodityBatch() throws SQLException {
        //add
        Backend dal = new Backend();
        ICommodityBatchDTO batchOut = new CommodityBatchDTO(10, 1, "", 100, new Date(2019, 5, 12), false);
        dal.addCommodityBatch(batchOut);

        //read
        ICommodityBatchDTO batchIn = dal.readCommodityBatch(10);
        System.out.println(batchIn.getIdComBatch() + "\t" + batchIn.getIdCom() + "\t" + batchIn.getComName() + "\t" + batchIn.getAmount() + "\t" + batchIn.getCommodityBatchDate() + "\t" + batchIn.getRest());
        System.out.println("\n-----------------------------------------");

        //update
        ICommodityBatchDTO batchUpdate = new CommodityBatchDTO(10, 1, "", 200, new Date(2019, 5, 12), false);
        dal.updateCommodityBatch(batchUpdate);

        //delete
        dal.deleteCommodityBatch(10);
    }
}