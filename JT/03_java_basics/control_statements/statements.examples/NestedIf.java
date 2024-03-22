public class NestedIf {
    public static void main(String args[]) {
        int i = 10;

        if (i == 10 || i < 15) {
            // First nested - if statement
            if (i < 15) {
                System.out.println("i is smaller than 15");
            }

            /* Second nested - if statement
            Will only be executed if statement above it is true */
            if (i < 12) {
                System.out.println("i is smaller than 12 too");
            }
        } else {
            System.out.println("i is greater than 15");
        }
    }
}
