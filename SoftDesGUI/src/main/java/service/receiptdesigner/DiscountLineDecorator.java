package service.receiptdesigner;

public class DiscountLineDecorator extends ReceiptAddOnDecorator {
    private final String discountType;

    public DiscountLineDecorator(ReceiptAddOn receiptAddOn, String discountType) {
        super(receiptAddOn);
        this.discountType = discountType;
    }

    @Override
    public double totalCost(double baseCost) {
        // The Strategy already applied the discount to the price passed into the receipt.
        // This decorator just passes through — it's here for the receipt label.
        return receiptAddOn.totalCost(baseCost);
    }

    @Override
    public String discountDesc() {
        String label = switch (discountType) {
            case "SENIOR" -> "20% Senior/PWD discount";
            case "BULK"   -> "15% Bulk purchase discount";
            case "PROMO"  -> "10% Promo code (SALE20)";
            default       -> "Discount applied";
        };
        String prefix = receiptAddOn.discountDesc().isEmpty() ? "" : " + ";
        return receiptAddOn.discountDesc() + prefix + label + "\n";
    }
}