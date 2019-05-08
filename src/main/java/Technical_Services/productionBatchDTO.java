package Technical_Services;

import java.util.Date;

public class productionBatchDTO implements IProductionBatchDTO {

    private int	prodBatchId;
    private int recipeId;
    private int batchSize;
    private Date prodBatchDate;

    public productionBatchDTO(int prodBatchId, int recipeId, int batchSize, Date prodBatchDate){

        this.prodBatchId = prodBatchId;
        this.recipeId = recipeId;
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
}
