import java.util.Objects;

public class Equality {

    public static void main(String[] args) {
        Object o = new Object();
        boolean[] p = new boolean[11];

        p[1] = Objects.equals(Integer.valueOf(2),2); // true
        p[2] = Objects.equals(2, Integer.valueOf(2)); // true
        p[3] = Objects.deepEquals(Integer.valueOf(2),2); // true
        p[4] = Objects.deepEquals(2, Integer.valueOf(2)); // true
        p[5] = Objects.equals(null, null); // true
        p[6] = Objects.equals(null, o); // false
        p[7] = Objects.equals(o, null); // false
        p[8] = Objects.equals(o, o); // true
        p[9] = Objects.equals(o, 1); // false
        p[10] = Objects.equals(1, o); // false

        for (int i = 1; i < p.length; i++) {
            System.out.println("p["+i+"] = " + p[i]);
        }
    }

}
