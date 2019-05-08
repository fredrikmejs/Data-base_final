package Technical_Services;

public class comodityBatchDTO implements IComodityBatchDTO {

    private int	comBatchId;
    private int comId;
    private float amount;
    private boolean isRest;


    public comodityBatchDTO(int comBatchId, int comId, float amount, boolean isRest){

        this.comBatchId = comBatchId;
        this.comId = comId;
        this.amount = amount;
        this.isRest = isRest;


    }

    @Override
    public int getIdComBatch() {
        return comBatchId;
    }

    @Override
    public void setIdComBatch(int idComBatch) {
    this.comBatchId = idComBatch;
    }

    @Override
    public int getIdCom() {
        return comId;
    }

    @Override
    public void setIdCom(int idCom) {
    this.comId = idCom;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public void setAmount(float amount) {
    this.amount = amount;
    }

    @Override
    public Boolean getRest() {
        return isRest;
    }

    @Override
    public void setRest(boolean rest) {
    this.isRest = rest;
    }
}
