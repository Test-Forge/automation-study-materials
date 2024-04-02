final class FinalClassExample {
    void display() {
        System.out.println("We are in the final class just created");
    }
}

class MainClass {
    public static void main(String[] args) {
        FinalClassExample obj = new FinalClassExample();
        obj.display();
    }
}