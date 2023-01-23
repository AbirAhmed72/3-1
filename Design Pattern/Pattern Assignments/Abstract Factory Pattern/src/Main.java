public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        WidgetFactory PMWF = new PMWidgetFactory();
        PMWF.CreateScrollBar().ShowScrollBar();

        WidgetFactory MotifWF = new MotifWidgetFactory();
        MotifWF.CreateWindow().ShowWindow();
    }
}
