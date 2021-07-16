import java.util.Locale;

public class StringCasing {
    public static void main(String[] args) {
        String str1 = "Test".toLowerCase();
        String str2 = "Test".toUpperCase();
        String str3 = "Test".toLowerCase(Locale.ROOT);
        String str4 = "Test".toUpperCase(Locale.ROOT);

        boolean p1 = "test".equals(str1);
        boolean p2 = "test".equals(str2);
        boolean p3 = "test".equals(str3);
        boolean p4 = "test".equals(str4);

        boolean p5 = "test".equals("TEST".toLowerCase());
        boolean p6 = "test".equals("TEST".toUpperCase());
        boolean p7 = "test".equals("TEST".toLowerCase(Locale.ROOT));
        boolean p8 = "test".equals("TEST".toUpperCase(Locale.ROOT));

        boolean p9  = "TEST".toLowerCase().equals("test");
        boolean p10 = "TEST".toUpperCase().equals("test");
        boolean p11 = "TEST".toLowerCase(Locale.ROOT).equals("test");
        boolean p12 = "TEST".toUpperCase(Locale.ROOT).equals("test");

        boolean p13 = "TEST".toLowerCase().equals("test");
        boolean p14 = "TEST".toUpperCase().equals("test");
        boolean p15 = "TEST".toLowerCase(Locale.ROOT).equals("test");
        boolean p16 = "TEST".toUpperCase(Locale.ROOT).equals("test");

        boolean p17  = "TEST".toLowerCase().equals("test");
        boolean p18 = "TEST".toUpperCase().equals("test");
        boolean p19 = "TEST".toLowerCase(Locale.ROOT).equals("test");
        boolean p20 = "TEST".toUpperCase(Locale.ROOT).equals("test");

    }

}
