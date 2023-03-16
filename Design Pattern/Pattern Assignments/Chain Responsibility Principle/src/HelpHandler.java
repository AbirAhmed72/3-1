public interface HelpHandler {
    boolean hasHelp();
    void setHandler(HelpHandler handler, int topic);
    void handleHelp();
}