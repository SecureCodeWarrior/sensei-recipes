public class ComparisonOperators {

    public static void verboseCompareIntegers(String[] args) {
        Integer i = 5;
        Integer j = 5;
        if (i == j) {
            System.out.println("Equal.");
        }
        if (i != j) {
            System.out.println("Not equal");
        }
    }

    public static void verboseCompareShorts(String[] args) {
        Short i = 5;
        Short j = 5;
        if (i == j) {
            System.out.println("Equal.");
        }
        if (i != j) {
            System.out.println("Not equal");
        }
    }

    public static void verboseCompareLongs(String[] args) {
        Long i = 5L;
        Long j = 5L;
        if (i == j) {
            System.out.println("Equal.");
        }
        if (i != j) {
            System.out.println("Not equal");
        }
    }

    private boolean compareIntegers(Integer i, Integer j) {
        return i==j && i!=j;
    }

    private boolean compareShorts(Short i, Short j) {
        return i==j && i!=j;
    }

    private boolean compareLongs(Long i, Long j) {
        return i==j && i!=j;
    }

}
