public class BitwiseOperators {
    public static void main(String[] args) {
        // Bitwise operators
        int d = 0b1010;
        int e = 0b1100;

        System.out.println("d & e: " + (d & e));
        System.out.println("d | e: " + (d | e));
        System.out.println("d ^ e: " + (d ^ e));
        System.out.println("~d: " + (~d));
    }
}
