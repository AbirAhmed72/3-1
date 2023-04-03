public class UserInfo {
    private String name;
    private String email;
    private String password;
    private String address;

    UserInfo(String name,String email, String password, String address){
        this.name = name;
        this.email= email;
        this.password = password;
        this.address = address;
        showUserInfo();
    }

    public void showUserInfo(){
        System.out.println(name+" "+email+" "+address);
    }
}
