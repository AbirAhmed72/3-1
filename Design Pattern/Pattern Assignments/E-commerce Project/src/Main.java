import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose items and quantity, SignOut when done");

        ArrayList<String> userProducts = new ArrayList<String>();
        ArrayList<Integer> userQuantity = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        while (true){
            
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("SignOut"))
                break;
            userProducts.add(input);
            userQuantity.add(sc.nextInt());
            sc.nextLine();
        }
        ProductInfo productInfo = new ProductInfo(userProducts, userQuantity);
        PaymentInfoContext paymentInfo = new PaymentInfoContext("cryptopayment", productInfo.getTotalPrice(), 905000.0);
        UserInfo userInfo = new UserInfo("Name: Abir Ahmed", " Email: abir@gmail.com", "1234", "Address: Dhaka");

        ConcreteOrderMediator orderMediator = new ConcreteOrderMediator();

        orderMediator.setProductInfo(productInfo);
        orderMediator.setPaymentInfo(paymentInfo);
        orderMediator.setUserInfo(userInfo);

        orderMediator.placeOrder();
    }
}
