package model;

import behavior.Expirable;
import behavior.Shippable;
import implementation.ShippableProduct;

import java.time.LocalDate;

public class CartProduct {
    private Product product;
    private int quantity;
    private double price;
    private double shippingPrice = 0;
    public CartProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice() * quantity;
        if(product.getShippingInfo() instanceof ShippableProduct)
            this.shippingPrice = product.getShippingInfo().getShippingFees();
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }


    public int getQuantity() {
        return quantity;
    }

    public boolean isExpired() {
        Expirable expiry = product.getExpiryInfo();
        if (expiry == null || expiry.getExpiryDate() == null) return false;
        return expiry.getExpiryDate().isBefore(LocalDate.now());
    }
}
