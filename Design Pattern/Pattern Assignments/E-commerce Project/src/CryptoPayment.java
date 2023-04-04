public class CryptoPayment implements IPaymentMethod{
    @Override
    public boolean match(String method) {
        return method.equalsIgnoreCase("cryptopayment");

    }

    @Override
    public String pay(Double amount) {
        return " Paid using CryptoCurrency with an amount of: " + amount;
    }
}
