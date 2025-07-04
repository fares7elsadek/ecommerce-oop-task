package model;

import behavior.Expirable;
import behavior.Shippable;

public class Product {
    private String name;
    private double price;
    private int quantity;

    private Expirable expiryInfo;
    private Shippable shippingInfo;

    public Product(double price, String name, int quantity, Expirable expiryInfo, Shippable shippingInfo) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.expiryInfo = expiryInfo;
        this.shippingInfo = shippingInfo;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Expirable getExpiryInfo() {
        return expiryInfo;
    }

    public Shippable getShippingInfo() {
        return shippingInfo;
    }
}
