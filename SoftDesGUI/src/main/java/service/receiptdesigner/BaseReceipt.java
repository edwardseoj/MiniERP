package service.receiptdesigner;

public class BaseReceipt implements Receipt{

    @Override
    public double indivCost() {
        return 0;
    }

    @Override
    public double totalCost() {
        return 0;
    }

    @Override
    public String productName() {
        return "";
    }
}
