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
        // TODO: Implement this method
        throw new UnsupportedOperationException("Unimplemented: PaypalPayment.pay");
    }

    public String getEmailId() {
        return emailId;
    }
}
