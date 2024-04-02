public class RelationalOperators {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int c = 5;

        // Comparison operators
        boolean greatThan = a > b;
        boolean lessThan = a < b;
        boolean greatOrEqual = a >= b;
        boolean lessOrEqual = a <= b;
        boolean equal = a == c;
        boolean notEqual = a != c;

        System.out.println(a + " > " + b + ": " + greatThan);
        System.out.println(a + " < " + b + ": " + lessThan);
        System.out.println(a + " >= " + b + ": " + greatOrEqual);
        System.out.println(a + " <= " + b + ": " + lessOrEqual);
        System.out.println(a + " == " + c + ": " + equal);
        System.out.println(a + " != " + c + ": " + notEqual);
    }
}