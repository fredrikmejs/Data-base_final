package Technical_Services;

public class IngredientDTO implements IIngredientDTO {
    private String name;
    private int comId;
    private double amount;

    public IngredientDTO(String name, int comId, double amount) {
        this.name = name;
        this.comId = comId;
        this.amount = amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCommodityId() {
        return comId;
    }

    @Override
    public void setCommodityId(int id) {
        comId = id;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
