package dev.jaib.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyPatternTest {
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        cart.addItem(new Item("1234", 100));
        cart.addItem(new Item("5678", 250));
    }

    @Test
    public void testCalculateTotal() {
        assertEquals(350, cart.calculateTotal());
    }

    @Test
    public void testCreditCardPayment() {
        PaymentStrategy cc = new CreditCardPayment("Jai Bhardwaj", "1234567890123456", "123", "12/28");
        // We verify that paying runs without exception
        assertDoesNotThrow(() -> cart.pay(cc));
    }

    @Test
    public void testPaypalPayment() {
        PaymentStrategy paypal = new PaypalPayment("jai.bhardwaj99@gmail.com", "password");
        // We verify that paying runs without exception
        assertDoesNotThrow(() -> cart.pay(paypal));
    }
}
