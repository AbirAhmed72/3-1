public class samsungMobile implements iMobile{
    @Override
    public void call() {
        System.out.println("Calling from Samsung.....");
    }

    @Override
    public void message(){
        System.out.println("Messaging from Samsung.....");
    }
}
