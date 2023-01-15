public class Main {
    public static void main(String[] args) {
        MobileFactory mFactory = new MobileFactory();

        iMobile iphone = mFactory.getMobileType("iPhone");
        iphone.call();
        iphone.message();

        iMobile samsung = mFactory.getMobileType("Samsung");
        samsung.call();
        samsung.message();

        iMobile xiaomi = mFactory.getMobileType("Xiaomi");
        xiaomi.call();
        xiaomi.message();
    }
}
