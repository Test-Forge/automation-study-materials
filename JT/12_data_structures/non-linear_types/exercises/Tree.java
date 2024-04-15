/*
1. Easy level
    Complete a program to Remove a specified item from the TreeSet collection

2. Medium level
    Write a program to delete all elements from a given Tree Map
    Create a Tree using TreeMap, initialize five elements (it's a pair key-value) and delete all items (using method clean())
*/

public class Tree {

    public static void main(String[] args) {
        // task 1
        TreeSet<String> col = new TreeSet<String>();
        // add 5 items to the Tree

        System.out.println("TreeSet Element : " + col);
        // remove two items from the Tree

        System.out.println("Updated TreeSet : " + col);
    }
}
