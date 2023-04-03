public class CryptoPayment implements IPaymentMethod{
    @Override
    public boolean match(String paymentMethod) {
        return paymentMethod.equalsIgnoreCase("cryptopayment");

    }

    @Override
    public String pay(Double amount) {
        return " CryptoCurrency for payment";
    }
}
