public class userDefinedMethodSecondExample {
    public static void main(String[] args) {
        int a = 19;
        int b = 5;

        // Method calling
        int c = add(a, b);   //a and b are actual parameters
        System.out.println("The sum of a and b is= " + c);
    }

    // User defined method
    public static int add(int n1, int n2)   //n1 and n2 are formal parameters
    {
        int sum;
        sum = n1 + n2;
        return sum; // Returning the sum
    }
}