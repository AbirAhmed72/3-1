public class Main{
	public static void main(String[] args) {
        
        Fridge deepFridge = Fridge.getFridge();
        System.out.println("Object Instantiated: " + instanceCounter);
        System.out.println("Object Called: " + callCounter);
    }
}

public class Fridge{

    private static Fridge deepFridge;
    public static callCounter = 0;
    public static instanceCounter = 0;

    private Fridge(){
        
    }

    public static Fridge getFridge() {
        if(getFridge == null) {
            instanceCounter++;
            getFridge = new Fridge();
        }
        callCounter++;
        return getFridge;
    }
}