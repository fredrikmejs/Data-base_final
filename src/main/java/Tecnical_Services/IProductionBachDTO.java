package Tecnical_Services;

import java.util.Date;

public interface IProductionBachDTO {

    int getIdProdBach();
    void setIdProdBach(int idProdBach);

    int getIdRec();
    void setIdRec(int idRecipe);

    int getBachSize();
    void setBachSize(int bachSize);

    Date getDate();
    void setDate(Date date);


}
