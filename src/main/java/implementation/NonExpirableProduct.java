package implementation;

import behavior.Expirable;

import java.time.LocalDate;

public class NonExpirableProduct implements Expirable {
    @Override
    public LocalDate getExpiryDate() {
        return null;
    }
}
