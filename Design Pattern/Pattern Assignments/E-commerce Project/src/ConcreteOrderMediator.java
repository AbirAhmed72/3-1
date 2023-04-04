public class ConcreteOrderMediator implements IOrderMediator{
    private ProductInfo productInfo;
    private PaymentInfoContext paymentInfo;
    private UserInfo userInfo;

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public void setPaymentInfo(PaymentInfoContext paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void placeOrder() {
        productInfo.showReceipt();
        paymentInfo.getPaymentMethod();
        paymentInfo.setCurrentUserBalance();
        userInfo.showUserInfo();
    }
}
