package model.receiptbuilder;

import service.receiptdecorator.*;

import java.util.ArrayList;

public class Receipt {
    private String storeName;
    private String empName;
    private ArrayList<String> products;
    private ArrayList<Double> productPrices;
    private double totalPrice;
    private String discountType;
    private boolean useLoyalty;

    private Receipt(Builder builder) {
        this.storeName    = builder.storeName;
        this.empName      = builder.empName;
        this.products     = builder.products;
        this.productPrices = builder.productPrices;
        this.totalPrice   = builder.totalPrice;
        this.discountType = builder.discountType;
        this.useLoyalty   = builder.useLoyalty;
    }

    public static class Builder{
        private String storeName;
        private String empName;
        private ArrayList<String> products;
        private ArrayList<Double> productPrices;
        private double totalPrice;
        private String discountType = "NONE";   // NEW
        private boolean useLoyalty = false;

        public Builder(String storeName, String empName){
            this.storeName = storeName;
            this.empName = empName;
        }
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


        public Receipt build(){
            return new Receipt(this);
        }
    }

    public String formatReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(storeName).append(" ===\n");
        sb.append("Employee: ").append(empName).append("\n");
        sb.append("=================\n");

        for (int i = 0; i < products.size(); i++) {
            sb.append(String.format("%-15s P%.2f\n", products.get(i), productPrices.get(i)));
        }

        ReceiptAddOn receiptAddOn = new BaseReceiptAddOn();

        if (!discountType.equals("NONE")) {
            receiptAddOn = new DiscountLineDecorator(receiptAddOn, discountType);
        }

        if (useLoyalty) {
            receiptAddOn = new LoyaltyPointsDecorator(receiptAddOn);
        }

        sb.append("=================\n");
        sb.append(receiptAddOn.discountDesc());

        double finalTotal = receiptAddOn.totalCost(totalPrice);

        double vatAmount = finalTotal * 0.12;
        sb.append(String.format("VAT (12%%):       P%.2f\n", vatAmount));

        sb.append(String.format("TOTAL:          P%.2f\n", finalTotal));
        sb.append("=================\n");
        sb.append("   Thank you!   \n");

        return sb.toString();
    }



}
