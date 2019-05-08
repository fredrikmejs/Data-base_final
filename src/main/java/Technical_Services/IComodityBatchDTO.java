package Technical_Services;

public interface IComodityBatchDTO {

    int getIdComBatch();
    void setIdComBatch(int idComBatch);

    int getIdCom();
    void setIdCom(int idCom);

    float getAmount();
    void setAmount(float amount);

    Boolean getRest();
    void setRest(boolean rest);
}
