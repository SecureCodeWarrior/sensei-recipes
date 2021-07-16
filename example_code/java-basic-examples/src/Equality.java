import java.util.Objects;

public class Equality {

    public static void main(String[] args) {
        boolean p1 = Objects.equals(Integer.valueOf(2),2); // true
        boolean p2 = Objects.equals(2, Integer.valueOf(2)); // true

        boolean p3 = Objects.deepEquals(Integer.valueOf(2),2); // true
        boolean p4 = Objects.deepEquals(2, Integer.valueOf(2)); // true
    }

}
