public class Context {
    private VehicleStrategy strategy;

   public Context(VehicleStrategy strategy){
      this.strategy = strategy;
   }

   public String executeStrategy(String vehicle){
      return strategy.algorithmInterface(vehicle);
   }
}
