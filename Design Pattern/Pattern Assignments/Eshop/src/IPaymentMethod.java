public interface IPaymentMethod {

    boolean match(String paymentMethod);
    String pay(Double amount);
}
