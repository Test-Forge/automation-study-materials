public class InstanceVariable {
    // Declared Instance Variable
    public String geek;
    public int i;
    public Integer I;

    public InstanceVariable() {
        // Default Constructor initializing Instance Variable
        this.geek = "Shubham Jain";
    }

    // Main Method
    public static void main(String[] args) {
        // Object Creation
        InstanceVariable name = new InstanceVariable();

        // Displaying O/P
        System.out.println("Geek name is: " + name.geek);
        System.out.println("Default value for int is " + name.i);

        // toString() called internally
        System.out.println("Default value for Integer is " + name.I);
    }
}