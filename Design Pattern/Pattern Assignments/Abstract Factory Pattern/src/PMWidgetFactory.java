public class PMWidgetFactory extends WidgetFactory{
    @Override
    public ScrollBar CreateScrollBar() {
        System.out.println("ScrollBar of PM");
        return new PMScrollBar();
    }

    @Override
    public Window CreateWindow() {
        System.out.println("Window of PM");
        return new PMWindow();
    }
}
