public class TernaryOperator {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        int c = 30;
        int result;

        // result holds max of three numbers
        result = ((a > b) ? (a > c) ? a : c : (b > c) ? b : c);
        System.out.println("Max of three numbers = " + result);
    }
}
