public class AssignmentOperators {
    public static void main(String[] args) {
        int f = 7;

        // Assignment operators
        int assignSum = f += 3;
        int assignSub = f -= 2;
        int assignMultiply = f *= 4;
        int assignDivision = f /= 3;
        int assignMod = f %= 2;

        System.out.println("f += 3: " + assignSum);
        System.out.println("f -= 2: " + assignSub);
        System.out.println("f *= 4: " + assignMultiply);
        System.out.println("f /= 3: " + assignDivision);
        System.out.println("f %= 2: " + assignMod);
    }
}