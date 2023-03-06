public class Main {
    public static void main(String[] args) {
        Context context = new Context(new CarStrategy());		
        System.out.println("From main: " + context.executeStrategy("Car"));
  
        context = new Context(new BikeStrategy());		
        System.out.println("From main: " + context.executeStrategy("Bike"));
  
        // context = new Context(new OperationMultiply());		
        // System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
     }
}
