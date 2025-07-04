package implementation;

import behavior.Shippable;

public class ShippableProduct implements Shippable {
    private double weightInKg;
    private double shippingFees;
    public ShippableProduct(double weightInKg,double shippingFees) {
        this.weightInKg = weightInKg;
        this.shippingFees = shippingFees;
    }
    @Override
    public double getWeightInKg() {
        return weightInKg;
    }

    @Override
    public double getShippingFees() {
        return shippingFees;
    }
}
