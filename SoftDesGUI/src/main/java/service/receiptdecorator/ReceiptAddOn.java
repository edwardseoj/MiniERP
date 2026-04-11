package service.receiptdecorator;

/*
* What to put for decorator (Add-ons):
* - discount lines
* - VAT
* - Loyalty points
* */
public interface ReceiptAddOn {
    double totalCost(double cost);

    String discountDesc();
}
