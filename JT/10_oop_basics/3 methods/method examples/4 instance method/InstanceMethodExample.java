public class InstanceMethodExample {
    public static void main(String[] args) {
        // Creating an object of the class
        InstanceMethodExample obj = new InstanceMethodExample();

        // Invoking instance method
        System.out.println("The sum is: " + obj.add(12, 13));
    }

    int s;

    // User-defined method because we have not used static keyword
    public int add(int a, int b) {
        sum = a + b;
        // Returning the sum
        return sum;
    }
}