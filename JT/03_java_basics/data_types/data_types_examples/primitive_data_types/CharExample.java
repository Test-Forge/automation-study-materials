package primitive_data_types;

import java.util.Arrays;

public class CharExample {
    public static void main(String[] args) {
        char char1 = 'a';
        char char2 = 'A';

        System.out.println("char1: " + char1);
        System.out.println("char2: " + char2);

        String str = "javaPoint";
        char[] ch = str.toCharArray();

        System.out.println("String: " + str);
        System.out.println("char: " + Arrays.toString(ch));
    }
}
