package Tecnical_Services;

import java.util.Date;

public interface IProductionBachDTO {

    int getIdProdBatch();
    void setIdProdBatch(int idProdBach);

    int getIdRec();
    void setIdRec(int idRecipe);

    int getBatchSize();
    void setBatchSize(int batchSize);

    Date getDate();
    void setDate(Date date);


}
