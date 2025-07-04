package model;

import behavior.Shippable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private double totalPrice = 0;
    private ArrayList<CartProduct> products = new ArrayList<>();

    public void addProduct(Product product,int quantity) throws Exception{
        if(product.getQuantity() < quantity)
            throw new Exception("Insufficient product quantity");

        var cartProduct = new CartProduct(product,quantity);
        products.add(cartProduct);
        totalPrice += cartProduct.getPrice();
    }

    public ArrayList<CartProduct> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isEmpty(){
        return totalPrice == 0;
    }

    public double getShippingFees() {
        return products.stream()
                .mapToDouble(p -> p.getShippingPrice())
                .sum();
    }

    public List<Product> getShippableItems() {
        return products.stream()
                .map(CartProduct::getProduct)
                .filter(p -> p.getShippingInfo() != null && p.getShippingInfo().getShippingFees() > 0)
                .collect(Collectors.toList());
    }
}
