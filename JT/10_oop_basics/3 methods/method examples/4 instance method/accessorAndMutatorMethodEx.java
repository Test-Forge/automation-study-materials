public class accessorAndMutatorMethodEx {
    private int roll;
    private String name;

    // Accessor method
    public int getRoll() {
        return roll;
    }

    // Mutator method
    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Roll no.: " + roll);
        System.out.println("Student name: " + name);
    }
}