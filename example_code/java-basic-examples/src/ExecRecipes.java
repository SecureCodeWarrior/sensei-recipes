import java.io.IOException;

public class ExecRecipes {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("/bin/sh -c some_tool" + args[0]);
            r.exec("/bin/ls");
            r.exec(new String[]{"/bin/sh -c some_tool", args[0]});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
