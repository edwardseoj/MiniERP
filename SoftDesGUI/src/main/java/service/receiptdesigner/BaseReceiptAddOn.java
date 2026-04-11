package service.receiptdesigner;

public class BaseReceiptAddOn implements ReceiptAddOn {


    @Override
    public double totalCost(double cost) {
        return cost;
    }

    @Override
    public String discountDesc() {
        return "Base receipt\n";
    }
}
