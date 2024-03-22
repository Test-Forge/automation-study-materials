public class StaticVariable {
    // Declared static variable
    public static String geek = "Shubham Jain";

    public static void main(String[] args) {

        /* geek variable can be accessed without object
           creation Displaying O/P GFG.geek --> using the static variable */
        System.out.println("Geek Name is : " + StaticVariable.geek);

        /* static int c=0;
        above line,when uncommented, will throw an error as static variables cannot be declared locally. */
    }
}
