package Tecnical_Services;

public class comodityBatchDTO implements IComodityBatchDTO {

    private int	comBatchId;
    private int comId;
    private float amount;
    private boolean isRest;



    @Override
    public int getIdComBatch() {
        return comBatchId;
    }

    @Override
    public void setIdComBatch(int idComBach) {
    this.comBatchId = idComBach;
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
