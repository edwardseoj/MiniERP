package service.discounttype;

public class BulkPurchase implements DiscountStrategy{
    @Override
    public double applyDiscount(double cost) {
        return (cost - (cost * 0.15));
    }
}
