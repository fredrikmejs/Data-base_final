package Technical_Services;

import java.sql.Date

public class recipeDTO implements IRecipeDTO {

    private int	recipeId;
    private Date date;
    private String recipeName;
    private boolean isInUse;

    public recipeDTO(int recipeId, String recipeName, Date date, boolean isInUse){

        this.recipeId = recipeId;
        this.date = date;
        this.recipeName = recipeName;
        this.isInUse = isInUse;
    }

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
    public void getRecipeName(String recipeName) {
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
}
