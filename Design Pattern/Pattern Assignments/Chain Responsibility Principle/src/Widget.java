public class Widget implements HelpHandler {
    protected Widget parent;
    protected int topic = -1;
    
    public Widget(Widget parent, int topic) {
        this.parent = parent;
        this.topic = topic;
    }
    
    @Override
    public boolean hasHelp() {
        return topic != -1;
    }

    @Override
    public void setHandler(HelpHandler handler, int topic) {
        // do nothing, since Widgets are leaf nodes
    }

    @Override
    public void handleHelp() {
        if (parent != null) {
            parent.handleHelp();
        }
    }
}