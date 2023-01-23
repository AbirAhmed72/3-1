public class MotifWidgetFactory extends WidgetFactory{
    @Override
    public ScrollBar CreateScrollBar() {

        System.out.println(" Make a ScrollBar of Motif");
        return new MotifScrollBar();
    }

    @Override
    public Window CreateWindow() {
        System.out.println("Make a Window of Motif");
        return new MotifWindow();
    }
}
