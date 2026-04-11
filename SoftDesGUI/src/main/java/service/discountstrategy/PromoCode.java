package service.discountstrategy;

public class PromoCode implements DiscountStrategy{
    @Override
    public double applyDiscount(double cost) {
        return (cost-(cost * 0.1));
    }
}
