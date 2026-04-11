package model.receiptbuilder;

import service.receiptdesigner.*;

import java.util.ArrayList;

// only build receipt once checkout pay button is pressed
// add more parts for builder and print for add ons like VAT
public class Receipt {
    private String storeName;
    private String empName;
    private ArrayList<String> products;
    private ArrayList<Double> productPrices;
    private double totalPrice;
    private String discountType;   // NEW
    private boolean useLoyalty;    // NEW

    private Receipt(Builder builder) {
        this.storeName    = builder.storeName;
        this.empName      = builder.empName;
        this.products     = builder.products;
        this.productPrices = builder.productPrices;
        this.totalPrice   = builder.totalPrice;
        this.discountType = builder.discountType;   // NEW
        this.useLoyalty   = builder.useLoyalty;     // NEW
    }

    public static class Builder{
        private String storeName;
        private String empName;
        private ArrayList<String> products;
        private ArrayList<Double> productPrices;
        private double totalPrice;
        private String discountType = "NONE";   // NEW
        private boolean useLoyalty = false;

        // required fields
        public Builder(String storeName, String empName){
            this.storeName = storeName;
            this.empName = empName;
        }

        // optional fields
        public Builder setDiscountType(String discountType) {
            this.discountType = discountType;
            return this;
        }
        public Builder setUseLoyalty(boolean useLoyalty) {
            this.useLoyalty = useLoyalty;
            return this;
        }
        public Builder setProducts(ArrayList<String> products){
            this.products = products;
            return this;
        }
        public Builder setProductPrices(ArrayList<Double> productPrices){
            this.productPrices = productPrices;
            return this;
        }
        public Builder setTotalPrice(double totalPrice){
            this.totalPrice = totalPrice;
            return this;
        }

        // add more methods here for add ons in decorator DesPat

        public Receipt build(){
            return new Receipt(this);
        }
    }

    // for jtextarea
    public String formatReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(storeName).append(" ===\n");
        sb.append("Employee: ").append(empName).append("\n");
        sb.append("=================\n");

        for (int i = 0; i < products.size(); i++) {
            sb.append(String.format("%-15s P%.2f\n", products.get(i), productPrices.get(i)));
        }

        // --- Decorator Pattern: stack add-ons based on what was selected ---
        ReceiptAddOn receiptAddOn = new BaseReceiptAddOn();

        // Discount line decorator — driven by which strategy was used
        if (!discountType.equals("NONE")) {
            receiptAddOn = new DiscountLineDecorator(receiptAddOn, discountType);
        }

        // Loyalty points decorator — driven by the loyalty checkbox (applied last, before VAT display)
        if (useLoyalty) {
            receiptAddOn = new LoyaltyPointsDecorator(receiptAddOn);
        }

        sb.append("=================\n");
        sb.append(receiptAddOn.discountDesc());

        // Calculate final total
        double finalTotal = receiptAddOn.totalCost(totalPrice);

        // Display VAT separately (informational only, not added to total)
        double vatAmount = finalTotal * 0.12;
        sb.append(String.format("VAT (12%%):       P%.2f\n", vatAmount));

        sb.append(String.format("TOTAL:          P%.2f\n", finalTotal));
        sb.append("=================\n");
        sb.append("   Thank you!   \n");

        return sb.toString();
    }



}
