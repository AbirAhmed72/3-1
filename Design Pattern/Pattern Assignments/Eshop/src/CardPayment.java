public class CardPayment implements IPaymentMethod{
    @Override
    public boolean match(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("cardpayment");
    }

    @Override
    public String pay(Double amount) {
        return " Credit Card for payment";
    }

}
