import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConcreteSubject extends Subject {
    public ConcreteSubject(String fileName) {
        super(fileName);
        try {
            String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
            setFileContents(fileContents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void observeFile() {
        Path filePath = Paths.get(getFileName());
        try {
            while (true) {
                String newFileContents = new String(Files.readAllBytes(filePath));
                if (!getFileContents().equals(newFileContents)) {
                    setFileContents(newFileContents);
                }
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
