import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductInfo {
    private Map<String, Double> map = new HashMap<>();
    private ArrayList<String> userProducts;
    private ArrayList<Integer> userQuantity;

    private ArrayList<String> products = new ArrayList<>();
    private ArrayList<Double> price = new ArrayList<>();
    private ArrayList<Integer> inventory = new ArrayList<>();

    ProductInfo(ArrayList<String> userProducts, ArrayList<Integer> userQuantity){
        this.userProducts = userProducts;
        this.userQuantity = userQuantity;
        setProductInfo();
        setInventory();
        setMap();
    }

    private void setMap(){
        for (int i = 0; i < products.size(); i++){
            map.put(products.get(i), price.get(i));
        }
    }

    private void setInventory() {
        for (int i = 0; i < userProducts.size(); i++) {
            String chosenProduct = userProducts.get(i);
            int productIndex = products.indexOf(chosenProduct);
            if (productIndex != -1) {
                inventory.set(productIndex, inventory.get(productIndex) - userQuantity.get(i));
            }
        }
    }


    public Double getTotalPrice(){
        Double totalPrice = 0.0;
        for(int i = 0; i < userProducts.size(); i++){
            String chosenProduct = userProducts.get(i);
            Double productPrice = map.get(chosenProduct);
            if(productPrice != null){
                int productQuantity = userQuantity.get(i);
                totalPrice += productPrice * productQuantity;
            } else {
                System.out.println("Price for product " + chosenProduct + " is missing or not found");
            }
        }
        return totalPrice;
    }


    public void showReceipt(){
        System.out.println("Customer ordered: " + userProducts.toString());
        for(int i = 0; i < userProducts.size(); i++){
            String chosenProduct = userProducts.get(i);
            Double productPrice = map.get(chosenProduct);
            int productQuantity = userQuantity.get(i);
            System.out.println(chosenProduct + ": " + productPrice + " x " + productQuantity + " = " + productPrice*productQuantity);
        }
        System.out.println("Total price: " + getTotalPrice());
        System.out.println("Current inventory:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i) + ": " + inventory.get(i));
        }
    }


    public void setProductInfo(){
        products.add("Cookies");
        price.add(12.0);
        inventory.add(135);

        products.add("Bread");
        price.add(35.0);
        inventory.add(200);

        products.add("Chips");
        price.add(15.0);
        inventory.add(115);

        products.add("Chocolate");
        price.add(100.0);
        inventory.add(30);

        products.add("Formula");
        price.add(250.0);
        inventory.add(20);

        products.add("Banana");
        price.add(5.0);
        inventory.add(100);

        products.add("Breadcrumb");
        price.add(70.0);
        inventory.add(45);

        products.add("Flour");
        price.add(80.0);
        inventory.add(30);

        products.add("Pepper");
        price.add(90.0);
        inventory.add(100);

        products.add("Salt");
        price.add(55.0);
        inventory.add(300);
    }
}
