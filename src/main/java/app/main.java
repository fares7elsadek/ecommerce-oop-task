package app;

import implementation.ExpirableProduct;
import implementation.NonExpirableProduct;
import implementation.NonShippableProduct;
import implementation.ShippableProduct;
import model.Customer;
import model.Product;
import services.CheckoutService;

import java.time.LocalDate;

public class main {
    public static void main(String[] args)  {
        Product cheese = new Product(100, "Cheese", 10, new ExpirableProduct(LocalDate.now().plusDays(3)), new ShippableProduct(0.4, 15));
        Product biscuits = new Product(150, "Biscuits", 5, new ExpirableProduct(LocalDate.now().plusDays(2)), new ShippableProduct(0.7, 15));
        Product tv = new Product(5000, "TV", 3, new NonExpirableProduct(), new ShippableProduct(5.0, 200));
        Product scratchCard = new Product(50, "Scratch Card", 20, new NonExpirableProduct(), new NonShippableProduct());

        Customer customer = new Customer("Fares", 1000);

        try {
            customer.getCustomerCart().addProduct(cheese, 3);
            customer.getCustomerCart().addProduct(biscuits, 1);
            customer.getCustomerCart().addProduct(scratchCard, 1);
            CheckoutService.checkout(customer);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
