import jpm_module.CLE;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String command = "echo Hello World";
        try {
            String output = CLE.exec(command);
            System.out.println("Command output:\n" + output);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}