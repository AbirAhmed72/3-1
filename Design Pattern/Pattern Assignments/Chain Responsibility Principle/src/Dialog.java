public class Dialog extends Widget {
    protected HelpHandler handler;
    
    public Dialog(HelpHandler handler, int topic) {
        super(null, topic);
        this.handler = handler;
    }

    @Override
    public void setHandler(HelpHandler handler, int topic) {
        this.handler = handler;
        this.topic = topic;
    }

    @Override
    public void handleHelp() {
        if (hasHelp()) {
            // offer help on the dialog
        } else {
            handler.handleHelp();
        }
    }
}