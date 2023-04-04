public class PayPalPayment implements IPaymentMethod{
    @Override
    public boolean match(String method) {
        return method.equalsIgnoreCase("paypalpayment");

    }

    @Override
    public String pay(Double amount) {
        return "Paid using PayPal";
    }
}
