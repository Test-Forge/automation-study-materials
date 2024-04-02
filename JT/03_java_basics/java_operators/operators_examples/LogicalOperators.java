public class LogicalOperators {
    public static void main (String[] args) {
        boolean x = true;
        boolean y = false;

        // Logical operators
        boolean and = x && y;
        boolean or = x || y;
        boolean not = !x;

        System.out.println("x && y: " + and);
        System.out.println("x || y: " + or);
        System.out.println("!x: " + not);
    }
}