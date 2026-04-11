package service.discountstrategy;

public class DiscountContext {
    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double applyDiscount(double cost) {
        return strategy.applyDiscount(cost);
    }
}