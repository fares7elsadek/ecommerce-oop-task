## 🛒 E-Commerce System – OOP Project

### 📌 Overview

This is a simple object-oriented e-commerce system implemented in **Java**, designed to showcase clean architecture principles, composition over inheritance, and solid OOP practices.

It supports:

* Defining products (some expirable, some shippable)
* Managing customer carts
* Handling checkout logic with error validation
* Printing professional receipts
* Shipping logic for shippable products

---

### 🧱 Features

* ✅ Define products with `name`, `price`, and `quantity`
* ✅ Optional product behavior via interfaces:

  * `Expirable`: for products with expiration dates
  * `Shippable`: for products that require shipping (e.g. weight and fees)
* ✅ Cart management:

  * Add product with specific quantity
  * Validate against available stock
* ✅ Checkout logic:

  * Validate balance
  * Reject expired or out-of-stock items
  * Calculate subtotal, shipping, and final amount
* ✅ Print receipts with clear formatting
* ✅ Shipping service to print total shipment details (names + weight)

---

### 📁 Project Structure

```bash
src/
├── behavior/
│   ├── Expirable.java
│   └── Shippable.java
├── implementation/
│   ├── ExpirableProduct.java
│   ├── NonExpirableProduct.java
│   ├── ShippableProduct.java
│   └── NonShippableProduct.java
├── model/
│   ├── Product.java
│   ├── Cart.java
│   ├── CartProduct.java
│   └── Customer.java
├── service/
│   ├── CheckoutService.java
│   ├── ShippingService.java
│   └── ReceiptPrinterService.java
```

---

### 🧪 Example Scenario

```java
Product cheese = new Product(100, "Cheese", 10, new ExpirableProduct(LocalDate.now().plusDays(3)), new ShippableProduct(0.4, 15));
Product biscuits = new Product(150, "Biscuits", 5, new ExpirableProduct(LocalDate.now().plusDays(2)), new ShippableProduct(0.7, 15));
Product tv = new Product(5000, "TV", 3, new NonExpirableProduct(), new ShippableProduct(5.0, 200));
Product scratchCard = new Product(50, "Scratch Card", 20, new NonExpirableProduct(), new NonShippableProduct());

Customer customer = new Customer("Fares", 1000);
try {
customer.getCart().addProduct(cheese, 2);
customer.getCart().addProduct(biscuits, 1);
customer.getCart().addProduct(scratchCard, 1);

CheckoutService.checkout(customer);
}catch (Exception ex){
     System.out.println(ex.getMessage());
}
```

**Console Output:**

```
** Shipment notice **
Cheese 0.4kg
Biscuits 0.7kg
Total package weight 1.1kg

** Checkout receipt **
2x Cheese 200.0
1x Biscuits 150.0
1x Scratch Card 50.0
----------------------
Subtotal 400.0
Shipping 30.0
Total 430.0
Remaining Balance: 570.0
```

---

### 🛠️ How to Run

1. Clone or download the project.
2. Open it in any Java IDE (e.g., IntelliJ, VS Code, Eclipse).
3. Ensure you have JDK 17+ installed.
4. Run `Main.java` to test various scenarios.
