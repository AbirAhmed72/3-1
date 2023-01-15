public class Main {
    public static void main(String[] args) throws Exception {
        Fridge deepFridge = Fridge.getFridge();
        Fridge freezer = Fridge.getFridge();
        
        if (deepFridge == freezer) {
            System.out.println("Deepfridge and Freezer are the same instance");
        }
                
    }

    
}
