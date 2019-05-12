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

    //#########   user    ##########

    @Test
    void createConnection() throws SQLException {
        Backend dal = new Backend();
        dal.createConnection();
    }

    @Test
    void addUser() throws SQLException {
        Backend dal = new Backend();
        UserDTO u = new UserDTO("Dumbledoor", "Lemon Drop", "Produktionsleder", true);
        dal.addUser(u);
    }

    @Test
    void readUser() throws SQLException {
        Backend dal = new Backend();
        IUserDTO u = dal.readUser(0);
        System.out.println(u.getUserId() + "\t" + u.getUsername() + "\t" + u.getPassword() + u.getRole() + "\t" + u.isAdmin());
        System.out.println("\n-----------------------------------------");
    }

    @Test
    void updateUser() throws SQLException {
        Backend dal = new Backend();
        UserDTO u = new UserDTO(0,"Dumbledoor", "Sherbet Lemon", "Produktionsleder", true);
        dal.updateUser(u);
    }

    @Test
    void getUserList() throws SQLException {
        Backend dal = new Backend();
        List<IUserDTO> list = dal.getUserList();

        for (IUserDTO u : list) {
            System.out.println(u.getUserId() + "\t" + u.getUsername() + "\t" + u.getPassword() + u.getRole() + "\t" + u.isAdmin());
        }
        System.out.println("\n-----------------------------------------");
    }

    @Test
    void deleteUser() throws SQLException {
        Backend dal = new Backend();
        dal.deleteUser(1);
    }



    //#########   recipe    ##########


    @Test
    void addRecipe() throws SQLException {
        Backend dal = new Backend();
        RecipeDTO r = new RecipeDTO(10, "Minor potion of flight", new Date(2019, 5, 10), true);
        List<IIngredientDTO> l = new ArrayList<IIngredientDTO>();
        l.add(new IngredientDTO("this is not the name", 3, 5));
        l.add(new IngredientDTO("", 5, 10));
        r.setIngredients(l);
        dal.addRecipe(r);
    }

    @Test
    void readCurrentRecipe() throws SQLException {
        Backend dal = new Backend();
        try {
            addRecipe();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        IRecipeDTO r = dal.readCurrentRecipe(10);
        System.out.println(r.getRecipeId() + "\t" + r.getRecipeName() + "\t" + r.getRecipeDate() + "\n" + r.getIsRecipeInUse());
        for (IIngredientDTO i : r.getIngredients()) {
            System.out.println("\t" + i.getCommodityId() + "\t" + i.getName() + "\t" + i.getAmount());
        }
        System.out.println("\n-----------------------------------------");

    }

    @Test
    void updateRecipe() throws SQLException {
        Backend dal = new Backend();
        try {
            addRecipe();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        RecipeDTO r = new RecipeDTO(10, "Minor potion of flight", new Date(2019, 5, 12), true);
        List<IIngredientDTO> l = new ArrayList<IIngredientDTO>();
        l.add(new IngredientDTO("this is not the name", 3, 5));
        l.add(new IngredientDTO("", 5, 10));
        r.setIngredients(l);
        dal.updateRecipe(r);
    }

    @Test
    void deleteRecipe() throws SQLException {
        Backend dal = new Backend();
        try {
            addRecipe();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        dal.deleteRecipe(10, new Date(2019, 5, 10));
        dal.deleteRecipe(10, new Date(2019, 5, 12));
    }


    //#########   production batch    ##########

    @Test
    void addProductionBatch() throws SQLException {
        Backend dal = new Backend();
        IProductionBatchDTO batch = new ProductionBatchDTO(10, 1, "not the name", 200, new Date(2019, 5, 12));
        dal.addProductionBatch(batch);
    }

    @Test
    void readProductionBatch() throws SQLException {
        Backend dal = new Backend();
        try {
            addProductionBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        IProductionBatchDTO batch = dal.readProductionBatch(10);

        System.out.println(batch.getIdProdBatch() + "\t" + batch.getIdRec() + "\t" + batch.getRecipeName() + "\t" + batch.getBatchSize() + "\t" +batch.getDate());
        System.out.println("\n-----------------------------------------");
    }

    @Test
    void updateProductionBatch() throws SQLException {
        Backend dal = new Backend();
        try {
            addProductionBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        IProductionBatchDTO batch = new ProductionBatchDTO(10, 1, "not the name", 250, new Date(2019, 5, 12));
        dal.updateProductionBatch(batch);
    }

    @Test
    void deleteProductionBatch() throws SQLException {
        Backend dal = new Backend();
        try {
            addProductionBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        dal.deleteProductionBatch(10);
    }



    //#########   commodity batch    ##########


    @Test
    void addCommodityBatch() throws SQLException {
        Backend dal = new Backend();
        ICommodityBatchDTO batch = new CommodityBatchDTO(10, 1, "", 100, new Date(2019, 5, 12), false);
        dal.addCommodityBatch(batch);
    }

    @Test
    void readCommodityBatch() throws SQLException {
        Backend dal = new Backend();
        try {
            addCommodityBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ICommodityBatchDTO batch = dal.readCommodityBatch(10);
        System.out.println(batch.getIdComBatch() + "\t" + batch.getIdCom() + "\t" + batch.getComName() + "\t" + batch.getAmount() + "\t" + batch.getCommodityBatchDate() + "\t" + batch.getRest());
        System.out.println("\n-----------------------------------------");
    }

    @Test
    void updateCommodityBatch() throws SQLException {
        Backend dal = new Backend();
        try {
            addCommodityBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ICommodityBatchDTO batch = new CommodityBatchDTO(10, 1, "", 200, new Date(2019, 5, 12), false);
        dal.updateCommodityBatch(batch);
    }

    @Test
    void deleteCommodityBatch() throws SQLException {
        Backend dal = new Backend();
        try {
            addCommodityBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        dal.deleteCommodityBatch(10);
    }
}