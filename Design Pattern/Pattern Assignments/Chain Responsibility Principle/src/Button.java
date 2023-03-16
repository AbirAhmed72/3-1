public class Button extends Widget {
    public Button(Widget parent, int topic) {
        super(parent, topic);
    }

    @Override
    public void handleHelp() {
        if (hasHelp()) {
            // offer help on the button
        } else {
            super.handleHelp();
        }
    }
}