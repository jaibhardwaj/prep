package dev.jaib.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ShoppingCart.addItem");
    }

    public void removeItem(Item item) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ShoppingCart.removeItem");
    }

    public int calculateTotal() {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ShoppingCart.calculateTotal");
    }

    public void pay(PaymentStrategy paymentMethod) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: ShoppingCart.pay");
    }
}
