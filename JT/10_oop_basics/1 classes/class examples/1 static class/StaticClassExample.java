public class StaticClassExample {
    /*
     In the outer class, declared a variable 'str' as static because
     we are accessing that variable from a static context.

     If declare that variable as non-static, the compiler shows an error because
     'a nested static class cannot access non-static members of the outer class'.
    */
    private static String str = "Java";

    // Nested class which is a 'Static class'
    public static class StaticDemo {
        // Non-static method of Static class
        public void show() {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        /*
         For creating the object of the nested class we don't need to create an instance of the outer class.

         If the nested class is not a 'static class', we need to create an instance of the outer class.
         */
        StaticClassExample.StaticDemo obj = new StaticClassExample.StaticDemo();
        obj.show();
    }
}