package service.receiptdesigner;

abstract class ReceiptAddOnDecorator implements ReceiptAddOn {
    protected ReceiptAddOn receiptAddOn;

    public ReceiptAddOnDecorator(ReceiptAddOn receiptAddOn){
        this.receiptAddOn = receiptAddOn;
    }
}
