import java.util.ArrayList;
import java.util.List;

public class PaymentInfo {
    private String paymentMethod;
    private String userChoice;
    private Double currentUserBalance;
    private Double paymentAmount;

    PaymentInfo(String userChoice, Double amount, Double currentUserBalance){
        this.userChoice = userChoice;
        this.paymentAmount = amount;
        this.currentUserBalance = currentUserBalance;
        setPaymentMethod();
    }

    List<IPaymentMethod> paymentMethods = new ArrayList<>(List.of(
            new CardPayment(),
            new CryptoPayment(),
            new PayPalPayment()
    ));

    private void setPaymentMethod(){
//        if(userChoice.compareToIgnoreCase("creditCard")==0)
//            paymentMethod = "CreditCard";
//        else if(userChoice.compareToIgnoreCase("payPal")==0)
//            paymentMethod = "PayPal";
//        else
//            paymentMethod = "Crypto";
        for(IPaymentMethod method: paymentMethods){
            if(method.match(this.userChoice)){
                paymentMethod = method.pay(this.paymentAmount);
            }

        }
    }

    public void getPaymentMethod(){
        System.out.println("User chose: " + paymentMethod);
    }

    public void setCurrentUserBalance() {
        if(currentUserBalance - paymentAmount >= 0) {
            currentUserBalance = currentUserBalance - paymentAmount;
            System.out.println("Current Balance: " + currentUserBalance + " Deducted " + paymentAmount);
        }
        else System.out.println("Insufficient Balance!");
    }
}
