package Technical_Services;

import java.sql.Date;

public interface IProductionBatchDTO {

    int getIdProdBatch();
    void setIdProdBatch(int idProdBatch);

    int getIdRec();
    void setIdRec(int idRecipe);

    int getBatchSize();
    void setBatchSize(int batchSize);

    Date getDate();
    void setDate(Date date);

    String getRecipeName();
    void setRecipeName(String recipeName);
}
