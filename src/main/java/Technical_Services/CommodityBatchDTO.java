package Technical_Services;

import java.sql.Date;

public class CommodityBatchDTO implements ICommodityBatchDTO {

    private int	comBatchId;
    private int comId;
    private float amount;
    private boolean isRest;
    private Date date;


    public CommodityBatchDTO(int comBatchId, int comId, float amount, Date date, boolean isRest){

        this.comBatchId = comBatchId;
        this.comId = comId;
        this.amount = amount;
        this.isRest = isRest;
        this.date = date;

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

    @Override
    public Date getCommodityBatchDate(){ return date;}

    @Override
    public void setCommodityBatchDate(Date commodityBatchDate){
        this.date = commodityBatchDate;
}



}
