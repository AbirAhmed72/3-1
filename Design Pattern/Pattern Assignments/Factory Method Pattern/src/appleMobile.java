class appleMobile implements iMobile {
    
    @Override
    public void call() {
        System.out.println("Calling from iphone.....");
    }

    @Override
    public void message(){
        System.out.println("Messaging from iphone.....");
    }
}