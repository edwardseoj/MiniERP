package service.receiptdesigner;

public class VATDecorator extends ReceiptAddOnDecorator {
    public VATDecorator(ReceiptAddOn receiptAddOn){
        super(receiptAddOn);
    }

    @Override
    public double totalCost(double baseCost) {
        // VAT is now handled separately in Receipt.java - just pass through
        return receiptAddOn.totalCost(baseCost);
    }
    @Override
    public String discountDesc() {
        // VAT description is now handled separately in Receipt.java
        return receiptAddOn.discountDesc();
    }
}
