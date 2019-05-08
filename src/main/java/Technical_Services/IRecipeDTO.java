package Technical_Services;

import java.util.Date;

public interface IRecipeDTO {

     int getRecipeId();
     void setRecipeId(int RecipeId);

     Date getRecipeDate();
     void setRecipeDate(Date RecipeDate);


     String getRecipeName();
     void getRecipeName(String RecipeName);

     boolean getIsRecipeInUse();
     void setIsRecipeInUse(boolean RecipeinUse);

}
