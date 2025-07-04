package model;

public class Customer {
    private String name;
    private double balance;
    private Cart customerCart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void decrementBlanace(double amount){
        this.balance -= amount;
    }

    public Cart getCustomerCart() {
        return customerCart;
    }

    public double getBalance() {
        return balance;
    }
}
