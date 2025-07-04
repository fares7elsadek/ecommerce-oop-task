package services;

import model.Cart;
import model.CartProduct;

import java.text.DecimalFormat;

public class ReceiptPrinterService {
    public static void print(Cart cart, double subtotal, double shippingFees, double total, double remainingBalance) {
        System.out.println("\n** Checkout receipt **");

        for (CartProduct item : cart.getProducts()) {
            String name = item.getProduct().getName();
            int qty = item.getQuantity();
            double price = item.getPrice();
            System.out.println(qty + "x " + name + " " + price);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFees);
        System.out.println("Total " + total);
        System.out.println("Remaining Balance: " + remainingBalance);
    }
}

