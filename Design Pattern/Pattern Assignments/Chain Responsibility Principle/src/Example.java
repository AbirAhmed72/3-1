public class Example {
    public static void main(String[] args) {
        Application application = new Application(3);
        Dialog dialog = new Dialog(application, -1);
        Button button = new Button(dialog, 2);

        button.handleHelp();
    }
}