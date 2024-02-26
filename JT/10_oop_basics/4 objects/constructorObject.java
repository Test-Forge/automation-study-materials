class Employee {
    int id;
    String name;
    float salary;

    Employee (int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " " + name + " " + salary);
    }
}

public class TestEmployee {
    public static void main(String[] args) {
        Employee employee1 = new Employee(101, "ajeet", 45000);
        Employee employee2 = new Employee(102, "irfan", 25000);
        Employee employee3 = new Employee(103, "nakul", 55000);

        employee1.display();
        employee2.display();
        employee3.display();
    }
}