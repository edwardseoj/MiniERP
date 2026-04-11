package service.discountstrategy;

public class BulkPurchase implements DiscountStrategy{
    @Override
    public double applyDiscount(double cost) {
        return (cost - (cost * 0.15));
    }
}
