package model.receiptbuilder;

import java.util.ArrayList;
import java.util.List;


// only build receipt once checkout pay button is pressed
// add more parts for builder and print for add ons like VAT
public class Receipt {
    private String storeName;
    private String empName;
    private ArrayList<String> products;
    private ArrayList<Double> productPrices;
    private double totalPrice;

    private Receipt(Builder builder){
        this.storeName = builder.storeName;
        this.empName = builder.empName;
        this.products = builder.products;
        this.productPrices = builder.productPrices;
        this.totalPrice = builder.totalPrice;
    }

    public static class Builder{
        private String storeName;
        private String empName;
        private ArrayList<String> products;
        private ArrayList<Double> productPrices;
        private double totalPrice;

        // required fields
        public Builder(String storeName, String empName){
            this.storeName = storeName;
            this.empName = empName;
        }

        // optional fields
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

    public void printReceipt(){
        System.out.println(storeName);
        System.out.println("Employee: " + empName);
        System.out.println("=================\n");

        for(int i = 0; i < products.size(); i++){
            System.out.printf("%-10s $-20f",
                    products.get(i),
                    productPrices.get(i));
            System.out.println();
        }

        // add more methods here

        System.out.printf("\nTotal: $%.2f", totalPrice);
    }

}
