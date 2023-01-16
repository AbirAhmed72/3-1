public class MobileFactory {

    public Mobile getMobileType(String mobileType) {
        
        if (mobileType.equals("iPhone")) {
            return new appleMobile();
        } 
        
        else if (mobileType.equals("Samsung")) {
            return new samsungMobile();
        }

        else if (mobileType.equals("Xiaomi")) {
            return new xiaomiMobile();
        }
        else{
            return null;
        }
    }
}
