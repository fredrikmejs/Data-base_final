package Technical_Services;

import java.sql.Date;
import java.util.List;

public interface IRecipeDTO {

     int getRecipeId();
     void setRecipeId(int RecipeId);

     Date getRecipeDate();
     void setRecipeDate(Date RecipeDate);


     String getRecipeName();
     void getRecipeName(String RecipeName);

     boolean getIsRecipeInUse();
     void setIsRecipeInUse(boolean recipeInUse);

     List<IIngredientDTO> getIngredients();
     void setIngredients(List<IIngredientDTO> ingredients);
}
