package implementation;

import behavior.Expirable;

import java.time.LocalDate;

public class ExpirableProduct implements Expirable {
    private LocalDate expiryDate;
    public ExpirableProduct(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
