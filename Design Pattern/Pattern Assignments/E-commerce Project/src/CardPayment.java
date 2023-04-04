public class CardPayment implements IPaymentMethod{
    @Override
    public boolean match(String method) {
        return method.equalsIgnoreCase("cardpayment");
    }

    @Override
    public String pay(Double amount) {
        return "Paid using Credit Card";
    }

}
