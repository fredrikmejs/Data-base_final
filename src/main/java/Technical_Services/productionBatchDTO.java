package Technical_Services;

import java.sql.Date;

public class ProductionBatchDTO implements IProductionBatchDTO {

    private int	prodBatchId;
    private int recipeId;
    private String recipeName;
    private int batchSize;
    private Date prodBatchDate;

    public ProductionBatchDTO(int prodBatchId, int recipeId, String recipeName, int batchSize, Date prodBatchDate){

        this.prodBatchId = prodBatchId;
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.batchSize = batchSize;
        this.prodBatchDate = prodBatchDate;

    }

    @Override
    public int getIdProdBatch() {
        return prodBatchId;
    }

    @Override
    public void setIdProdBatch(int idProdBatch) {
    this.prodBatchId = idProdBatch;
    }

    @Override
    public int getIdRec() {
        return recipeId;
    }

    @Override
    public void setIdRec(int idRecipe) {
    this.recipeId = idRecipe;
    }

    @Override
    public int getBatchSize() {
        return batchSize;
    }

    @Override
    public void setBatchSize(int batchSize) {
    this.batchSize = batchSize;
    }

    @Override
    public Date getDate() {
        return prodBatchDate;
    }

    @Override
    public void setDate(Date date) {
    this.prodBatchDate = date;
    }

    @Override
    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
