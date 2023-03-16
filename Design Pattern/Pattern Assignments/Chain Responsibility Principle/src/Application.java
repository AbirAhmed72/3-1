public class Application implements HelpHandler {
    protected int topic = -1;
    
    public Application(int topic) {
        this.topic = topic;
    }

    @Override
    public boolean hasHelp() {
        return topic != -1;
    }

    @Override
    public void setHandler(HelpHandler handler, int topic) {
        // do nothing, since Applications are root nodes
    }

    @Override
    public void handleHelp() {
        // show a list of help topics
    }
}