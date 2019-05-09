package Technical_Services;

import java.sql.Date;

public interface ICommodityBatchDTO {

    int getIdComBatch();
    void setIdComBatch(int idComBatch);

    int getIdCom();
    void setIdCom(int idCom);

    float getAmount();
    void setAmount(float amount);

    Boolean getRest();
    void setRest(boolean rest);

    Date getCommodityBatchDate();
    void setCommodityBatchDate(Date commodityBatchDate);
}
