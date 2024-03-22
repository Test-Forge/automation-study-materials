public class ExplicitCasting {
    public static void main(String[] args) {
        double d = 2.00003;

        // it loses the fractional part
        long l = (long) d;
        System.out.println(l);

        // requires explicit casting because long is wider than int
        int i = (int) l;
        System.out.println(i);

        // requires explicit casting because the result is long (indicated by L)
        int val = (int) (3 + 2L);
        System.out.println(val);

        // casting from a long literal to char
        char ch = (char) 55L;
        System.out.println(ch);
    }
}
