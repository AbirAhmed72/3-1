public class Fridge {
    private static Fridge deepFridge;
    
    private Fridge() {

    }

    public static Fridge getFridge() {
        if (deepFridge == null) {
            deepFridge = new Fridge();
        }
        return deepFridge;
    }
}
