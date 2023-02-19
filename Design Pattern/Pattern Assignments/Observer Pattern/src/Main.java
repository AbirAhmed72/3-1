import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject file = new ConcreteSubject("test.txt");
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        file.register(observer1);
        file.register(observer2);

        Thread t = new Thread(new Runnable() {
            public void run() {
                file.observeFile();
            }
        });
        t.start();

        try {
            Thread.sleep(1000);
            Files.write(Paths.get("test.txt"), "This is first modification".getBytes());
            Thread.sleep(3000);
            Files.write(Paths.get("test.txt"), "This is second modification".getBytes());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
