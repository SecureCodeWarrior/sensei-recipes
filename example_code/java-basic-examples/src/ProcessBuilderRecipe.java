import java.io.IOException;
import java.util.ArrayList;

public class ProcessBuilderRecipe {

    public static void main(String[] args) {
        ArrayList<String> x = new ArrayList<>();
        ProcessBuilder b = new ProcessBuilder(x);
        x.add(0, "hi");
        try {
            b.start();
            b = new ProcessBuilder("this wil be overridden", "...", args[0]);
            b.command("my command");
            b.command("my command", args[0]);
            b.command("Command"+args[0]); // Overwrites the previous
            b.command().add(0, "this is the actual command");
            b.command().add(0, "this is the actual command"+args[0]);
            b.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
