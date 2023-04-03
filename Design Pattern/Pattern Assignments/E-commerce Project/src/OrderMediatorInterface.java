public interface OrderMediatorInterface {
    void setProductInfo(ProductInfo productInfo);
    void setPaymentInfo(PaymentInfo paymentInfo);
    void setUserInfo(UserInfo userInfo);
    void placeOrder();
}
