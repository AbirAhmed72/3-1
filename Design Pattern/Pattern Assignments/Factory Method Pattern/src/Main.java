public class Main {
    public static void main(String[] args) {
        MobileFactory mFactory = new MobileFactory();

        Mobile iphone = mFactory.getMobileType("iPhone");
        iphone.call();
        iphone.message();

        Mobile samsung = mFactory.getMobileType("Samsung");
        samsung.call();
        samsung.message();

        Mobile xiaomi = mFactory.getMobileType("Xiaomi");
        xiaomi.call();
        xiaomi.message();
    }
}
