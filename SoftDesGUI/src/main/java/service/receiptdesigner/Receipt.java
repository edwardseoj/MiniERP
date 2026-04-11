package service.receiptdesigner;

/*
* What to put for decorator (Add-ons):
* - discount lines
* - VAT
* - Loyalty points
* */
public interface Receipt {
    double indivCost();
    double totalCost();
    String productName();
}
