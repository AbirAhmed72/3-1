public interface IPaymentMethod {

    boolean match(String method);
    String pay(Double amount);
}
