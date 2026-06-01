package dev.jaib.strategy;

public class Item {
    private String upcCode;
    private int price;

    public Item(String upc, int price) {
        this.upcCode = upc;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public int getPrice() {
        return price;
    }
}
