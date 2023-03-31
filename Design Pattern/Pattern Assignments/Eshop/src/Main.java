import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Provide the names of the items you want to buy and their quantity, enter exit when you are done");

        ArrayList<String> userProducts = new ArrayList<String>();
        ArrayList<Integer> userQuantity = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit"))
                break;
            userProducts.add(input);
            userQuantity.add(sc.nextInt());
            sc.nextLine();
        }
        // Create instances of each class
        ProductInfo productInfo = new ProductInfo(userProducts, userQuantity);
        PaymentInfo paymentInfo = new PaymentInfo("CreditCard", productInfo.getTotalPrice(), 10000.0);
        UserInfo userInfo = new UserInfo("ABC", "a@gmail.com", "1234", "dhaka");

        // Create an instance of the mediator
        OrderMediator orderMediator = new OrderMediator();

        // Register each class with the mediator
        orderMediator.setProductInfo(productInfo);
        orderMediator.setPaymentInfo(paymentInfo);
        orderMediator.setUserInfo(userInfo);

        // Place the order through the mediator
        orderMediator.placeOrder();
    }
}
