package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Product {
    private String name;
    private int stock;
    private double price;
    private String description;

    public Product(String name, int stock, double price, String description){
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public int getStock() {
        return stock;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }



}
