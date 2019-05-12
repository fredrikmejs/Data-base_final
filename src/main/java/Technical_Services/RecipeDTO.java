package Technical_Services;

import java.sql.Date;
import java.util.List;

public class RecipeDTO implements IRecipeDTO {

    private int	recipeId;
    private Date date;
    private String recipeName;
    private boolean isInUse;
    private List<IIngredientDTO> ingredients;

    public RecipeDTO(int recipeId, String recipeName, Date date, boolean isInUse){
        this.recipeId = recipeId;
        this.date = date;
        this.recipeName = recipeName;
        this.isInUse = isInUse;
    }

    public RecipeDTO () {};

    @Override
    public int getRecipeId() {
        return recipeId;
    }

    @Override
    public void setRecipeId(int recipeId) {
    this.recipeId = recipeId;
    }

    @Override
    public Date getRecipeDate() {
        return date;
    }

    @Override
    public void setRecipeDate(Date recipeDate) {
    this.date = recipeDate;
    }

    @Override
    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
    }

    @Override
    public boolean getIsRecipeInUse() {
        return isInUse;
    }

    @Override
    public void setIsRecipeInUse(boolean inUse) {
    this.isInUse = inUse;
    }

    @Override
    public List<IIngredientDTO> getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(List<IIngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
