public class ConcreteObserver extends Observer{

    private String name;

    public ConcreteObserver(String name){
        this.name = name;
    }

    public void update(Subject subject){
        System.out.println("File " + subject.getFileName() + " is being modified.");
        System.out.println("Modified file contents:");
        System.out.println(subject.getFileContents());
    }
}
