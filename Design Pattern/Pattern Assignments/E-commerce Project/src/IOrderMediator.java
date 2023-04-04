public interface IOrderMediator {
    void setProductInfo(ProductInfo productInfo);
    void setPaymentInfo(PaymentInfoContext paymentInfo);
    void setUserInfo(UserInfo userInfo);
    void placeOrder();
}
