package service.receiptdesigner;

public class DiscountLineDecorator extends ReceiptAddOnDecorator {
    public DiscountLineDecorator(ReceiptAddOn receiptAddOn){
        super(receiptAddOn);
    }

    // insert starategy

    // assume senior discount first

    @Override
    public double totalCost(double baseCost) {
        double discount = receiptAddOn.totalCost(baseCost) * 0.2;
        return receiptAddOn.totalCost(baseCost) - discount;
    }

    @Override
    public String discountDesc() {
        return receiptAddOn.discountDesc() + " + 20% senior discount\n";
    }
}
