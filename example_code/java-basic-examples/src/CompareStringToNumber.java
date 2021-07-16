public class CompareStringToNumber {

    public static void main(String[] args) {
        "1".equals(1);
        "1".equals(1L);
        "1".equals((short)1);
        "1".equals(Short.valueOf((short)1));
        "1".equals(Integer.valueOf(1));
        "1".equals(Long.valueOf(1));
    }
}
