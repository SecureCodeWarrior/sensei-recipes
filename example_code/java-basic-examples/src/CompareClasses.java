import java.util.ArrayList;
import java.util.List;

public class CompareClasses {

    public static void main(String[] args) {
        compareClasses();
    }

    private static Object getObject() {
        return Integer.valueOf("42");
    }

    private static void compareClasses() {
        Object obj1 = getObject();
        Object obj2 = new Object();

        List<Boolean> b = new ArrayList<>();
        b.add(obj1.getClass().getName().equals("java.lang.Integer"));
        b.add(obj1.getClass().getName().equals("java.lang.Double"));

        b.add("java.lang.Integer".equals(obj1.getClass().getName()));
        b.add("java.lang.Double".equals(obj1.getClass().getName()));

        b.add(obj1.getClass().getName().equals(Integer.valueOf(42).getClass().getName()));
        b.add(obj1.getClass().getName().equals(obj2.getClass().getName()));

        b.add(obj1.getClass().equals(Integer.valueOf(42).getClass()));
        b.add(obj1.getClass().equals(obj2.getClass()));

        b.add(obj1.getClass() == Integer.class);
        b.add(obj1.getClass() == obj2.getClass());

        for (boolean c : b) {
            System.out.println(c);
        }
    }
}
