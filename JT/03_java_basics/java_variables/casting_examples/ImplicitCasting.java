public class ImplicitCasting {
    public static void main(String[] args) {
        // from int to long
        int num = 100;
        long bigNum = num;
        System.out.println(bigNum);

        // from long to double
        long bigLongNum = 100_000_000L;
        double bigFraction = bigLongNum;
        System.out.println(bigFraction);

        // from short to int
        short shortNum = 100;
        int intNum = shortNum;
        System.out.println(intNum);

        // from char to int
        char ch = '?';
        int code = ch;
        System.out.println(code);
    }
}
