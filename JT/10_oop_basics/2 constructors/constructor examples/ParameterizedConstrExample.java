public class ParameterizedConstrExample {

    String language;

    // Creatind a parameterized constructor accepting single value
    ParameterizedConstrExample(String language) {
        this.language = language;
    }

    public static void main(String[] args) {
        // Call constructor by passing a single value
        ParameterizedConstrExample obj1 = new ParameterizedConstrExample("Java");
        ParameterizedConstrExample obj2 = new ParameterizedConstrExample("Python");
        ParameterizedConstrExample obj3 = new ParameterizedConstrExample("C++");
    }
}