package Technical_Services;

import java.util.Date;

public class recipeDTO implements IRecipeDTO {


    private int	recipeId;
    private Date date;
    private String recipeName;
    private boolean isInUse;

    public recipeDTO(int recipeId, Date date, String recipeName, boolean isInUse) {
        this.recipeId = recipeId;
        this.date = date;
        this.isInUse = isInUse;
        this.recipeName = recipeName;

    }




    @Override
    public int getRecipeId() {
        return recipeId;
    }

    @Override
    public void setRecipeId(int recipeid) {
    this.recipeId = recipeid;
    }

    @Override
    public Date getRecipeDate() {
        return date;
    }

    @Override
    public void setRecipeDate(Date recipeaDate) {
    this.date = recipeaDate;
    }

    @Override
    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public void getRecipeName(String RecipeName) {
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