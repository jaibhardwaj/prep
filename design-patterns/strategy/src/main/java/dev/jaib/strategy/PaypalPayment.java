package dev.jaib.strategy;

public class PaypalPayment implements PaymentStrategy {
    private String emailId;
    private String password;

    public PaypalPayment(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }

    public String getEmailId() {
        return emailId;
    }
}
