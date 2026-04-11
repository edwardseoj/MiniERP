package service.discounttype;

public class SeniorPWD implements DiscountStrategy{
    @Override
    public double applyDiscount(double cost) {
        return (cost-(cost * 0.2));
    }
}
