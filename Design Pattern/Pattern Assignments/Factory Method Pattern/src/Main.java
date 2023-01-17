public class Main {
    public static void main(String[] args) {
        MobileFactory mFactory = new MobileFactory();

        Mobile iphone = mFactory.getMobileType("iPhone");
        iphone.switchOn();
        iphone.call();
        iphone.message();

        Mobile samsung = mFactory.getMobileType("Samsung");
        samsung.switchOn();
        samsung.call();
        samsung.message();

        Mobile xiaomi = mFactory.getMobileType("Xiaomi");
        xiaomi.call();
        xiaomi.message();
    }
}
