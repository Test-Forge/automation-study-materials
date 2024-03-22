package non_primitive_data_type;

public class StringsExample {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println("first string is: " + s1);

        String s2 = "Hello World!";

        // The Java String class length() method finds the length of a string.
        System.out.println("length of second string is: " + s2.length());

        String s3 = "hello";
        String s4 = "hemlo";
        String s5 = "flag";

        /*
        The compareTo() method compares two strings lexicographically.
        The comparison is based on the Unicode value of each character in the strings.

        The method returns 0 if the string is equal to the other string.
        A value less than 0 is returned if the string is less than the other string (fewer characters) and a value greater
        than 0 if the string is greater than the other string (more characters).
         */
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s4));
        System.out.println(s1.compareTo(s5));
    }
}
