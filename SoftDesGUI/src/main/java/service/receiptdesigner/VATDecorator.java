package service.receiptdesigner;

public class VATDecorator extends ReceiptAddOnDecorator {
    public VATDecorator(ReceiptAddOn receiptAddOn){
        super(receiptAddOn);
    }

    @Override
    public double totalCost(double baseCost) {
        double discount = receiptAddOn.totalCost(baseCost) * 0.12;
        return receiptAddOn.totalCost(baseCost) + 0;
    }

    @Override
    public String discountDesc() {
        return receiptAddOn.discountDesc() + " + VAT Rate\n";
    }
}
