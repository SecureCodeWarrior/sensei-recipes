import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IORecipes {

    public static void main(String[] args) {
        File file = new File(args[0]);
        file.delete();

        //Files.delete(new File(args[0]).toPath());

        Path f = new File(args[0]).toPath();
        try {
            Files.delete(f);
        } catch (IOException x) {
            System.out.println("Deletion failed");
            // Handle error
        }

        System.out.write(1337);

        int i = 300;
        System.out.write(i);

        Integer wrap = 300;
        System.out.write(wrap);

    }
}
