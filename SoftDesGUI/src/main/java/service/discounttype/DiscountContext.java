package service.discounttype;

public class DiscountContext {
    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeDiscount(double cost){
        strategy.applyDiscount(cost);
    }
}
