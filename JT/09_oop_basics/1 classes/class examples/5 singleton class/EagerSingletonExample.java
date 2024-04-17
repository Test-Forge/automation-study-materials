/*
 In this example, will use eager initialization to create the single instance of the Singleton class.
 It means that the instance is created when the class is loaded, rather than when it is first accessed.
 */
public class EagerSingletonExample {
    // Declare a private static variable called instance to hold the single instance of the class
    private static final EagerSingleton instance = new EagerSingleton();

    // Make the constructor of the class 'private' so that no other instances can be created
    private EagerSingleton() {
    }

    /*
     Provide a 'public static' method called getInstance to return the single instance of the class
     The getInstance method simply returns the instance variable
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}