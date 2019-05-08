package Tecnical_Services;

import java.util.Date;

public class productionBatchDTO implements IProductionBachDTO {

    private int	prodBachId;
    private int recipeId;
    private int batchSize;
    private Date prodBatchDate;



    @Override
    public int getIdProdBatch() {
        return prodBachId;
    }

    @Override
    public void setIdProdBatch(int idProdBach) {
    this.prodBachId = idProdBach;
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
