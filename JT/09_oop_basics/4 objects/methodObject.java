/*
 Creating the two objects of Student class and initializing the value to these objects by invoking the insertRecord method.
 Here, we are displaying the state (data) of the objects by invoking the displayInformation() method.
 */
class Student {
    int rollno;
    String name;

    void insertRecord(int r, String n) {
        rollno = r;
        name = n;
    }

    void displayInformation() {
        System.out.println(rollno + " " + name);
    }
}

class TestStudent4 {
    public static void main(String args[]) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.insertRecord(111, "Karan");
        student2.insertRecord(222, "Aryan");

        student1.displayInformation();
        student2.displayInformation();
    }
}