public class DefaultConstrExample {

    int a;
    String b;

    public static void main(String[] args) {
        // Calling a default constructor
        DefaultConstrExample obj = new DefaultConstrExample();
        System.out.println("Default values: ");
        System.out.println("a = " + obj.a);
        System.out.println("b = " + obj.b);
    }
}