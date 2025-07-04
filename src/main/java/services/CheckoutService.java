package services;

import behavior.Shippable;
import model.Cart;
import model.CartProduct;
import model.Customer;
import model.Product;

import java.util.List;

public  class CheckoutService {
    public static void checkout(Customer customer) throws Exception{
        Cart cart = customer.getCustomerCart();
        if (cart.isEmpty())
            throw new Exception("Cart is empty");

        double subtotal = cart.getTotalPrice();
        double shippingFees = cart.getShippingFees();
        double total = subtotal + shippingFees;

        if (customer.getBalance() < total)
            throw new Exception("Insufficient balance");

        for (CartProduct item : cart.getProducts()) {
            if (item.isExpired())
                throw new Exception("Product " + item.getProduct().getName() + " is expired");
        }

        customer.decrementBlanace(total);

        List<Product> items = cart.getShippableItems();
        if (!items.isEmpty())
            ShippingService.ship(items);

        ReceiptPrinterService.print(cart, subtotal, shippingFees, total, customer.getBalance());
    }
}
