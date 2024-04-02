public class If {
    public static void main(String args[]) {
        int i = 10;

        if (i < 15) {
            // part of if block(immediate one statement after if condition)
            System.out.println("Inside If block");

            //always executes as it is inside of if block
            System.out.println("10 is less than 15");
        }
            /* This statement will be executed as if considers one statement
            by default again below statement is outside of if block */
        System.out.println("I am Not in if");
    }
}
