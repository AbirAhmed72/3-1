public class OrderMediator implements OrderMediatorInterface{
    private ProductInfo productInfo;
    private PaymentInfo paymentInfo;
    private UserInfo userInfo;

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void placeOrder() {
        // Perform any necessary checks or processing here
        // For example, verify user information, payment method, inventory, etc.

        // Once everything is verified, show the receipt and payment method
        productInfo.showReceipt();
        paymentInfo.getPaymentMethod();
        paymentInfo.setCurrentUserBalance();
        userInfo.showUserInfo();
    }
}
