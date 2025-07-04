package services;

import model.Product;

import java.util.List;

public class ShippingService {
    public static void ship(List<Product> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Product item : items) {
            double w = item.getShippingInfo().getWeightInKg();
            System.out.println(item.getName() + " " + w + "kg");
            totalWeight += w;
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }

}
