package implementation;

import behavior.Shippable;

public class NonShippableProduct implements Shippable {
    @Override
    public double getWeightInKg() {
        return 0;
    }

    @Override
    public double getShippingFees() {
        return 0;
    }
}
