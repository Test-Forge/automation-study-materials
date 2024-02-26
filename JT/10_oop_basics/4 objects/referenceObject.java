/*
 Initializing an object means storing data into the object.
 */
class referenceObject {
    int id;
    String name;
}

class TestStudent {
    public static void main(String args[]) {
        // Creating objects
        Student student1 = new Student();
        Student student2 = new Student();

        // Initializing objects
        student1.id = 101;
        student1.name = "Sonoo";
        student2.id = 102;
        student2.name = "Amit";

        // Printing data
        System.out.println(student1.id + " " + student1.name);
        System.out.println(student2.id + " " + student2.name);
    }
}