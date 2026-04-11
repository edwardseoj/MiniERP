package service.receiptdesigner;

public class LoyaltyPointsDecorator extends ReceiptAddOnDecorator {
    public LoyaltyPointsDecorator(ReceiptAddOn receiptAddOn){
        super(receiptAddOn);
    }

    @Override
    public double totalCost(double baseCost) {
        double discount = receiptAddOn.totalCost(baseCost) * 0.05;
        return receiptAddOn.totalCost(baseCost) - discount;
    }

    @Override
    public String discountDesc() {
        return receiptAddOn.discountDesc() + " + 5% loyalty points discount\n";
    }
}
