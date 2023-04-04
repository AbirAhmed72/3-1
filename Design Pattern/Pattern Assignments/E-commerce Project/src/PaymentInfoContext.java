import java.util.ArrayList;
import java.util.List;

public class PaymentInfoContext {
    private String paymentMethod;
    private String userChoice;
    private Double currentUserBalance;
    private Double paymentAmount;

    PaymentInfoContext(String userChoice, Double amount, Double currentUserBalance){
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
        for(IPaymentMethod method: paymentMethods){
            if(method.match(this.userChoice)){
                paymentMethod = method.pay(this.paymentAmount);
            }

        }
    }

    public void getPaymentMethod(){
        System.out.println("Payment Method: " + paymentMethod);
    }

    public void setCurrentUserBalance() {
        if(currentUserBalance - paymentAmount >= 0) {
            currentUserBalance = currentUserBalance - paymentAmount;
            System.out.println("Current Balance: " + currentUserBalance + " Deducted " + paymentAmount);
        }
        else System.out.println("Insufficient Balance!");
    }
}
