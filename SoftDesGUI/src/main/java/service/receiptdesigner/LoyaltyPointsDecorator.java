package service.receiptdesigner;

public class LoyaltyPointsDecorator extends ReceiptAddOnDecorator {
    public LoyaltyPointsDecorator(ReceiptAddOn receiptAddOn) {
        super(receiptAddOn);
    }

    @Override
    public double totalCost(double baseCost) {
        double subtotal = receiptAddOn.totalCost(baseCost); // call ONCE, reuse
        return subtotal - (subtotal * 0.05);
    }

    @Override
    public String discountDesc() {
        String prefix = receiptAddOn.discountDesc().isEmpty() ? "" : " + ";
        return receiptAddOn.discountDesc() + prefix + "5% loyalty discount\n";
    }
}