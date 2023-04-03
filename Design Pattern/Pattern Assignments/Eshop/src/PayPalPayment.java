public class PayPalPayment implements IPaymentMethod{
    @Override
    public boolean match(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("paypalpayment");

    }

    @Override
    public String pay(Double amount) {
        return " PayPal for payment";
    }
}
