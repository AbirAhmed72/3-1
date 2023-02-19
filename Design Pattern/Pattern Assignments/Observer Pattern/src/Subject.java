import java.util.ArrayList;

public abstract class Subject {

    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String fileName;
    private String fileContents;

    public Subject(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        Notify();
    }

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
        Notify();
    }

    public void register(Observer observer){
        observers.add(observer);
    }

    public void unregister(Observer observer){
        observers.remove(observer);
    }

    public void Notify(){
        for(Observer observer: observers) 
	        observer.update(this);
    }
}
