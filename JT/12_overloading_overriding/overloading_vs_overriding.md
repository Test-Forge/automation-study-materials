# Java Method Overloading and Overriding

---

---

## Table of content:

- [Method overloading description](#method-overload-description)

- [Method overloading example](#example)

- [Method overloading, best practices](#best-practices-for-applying--method-overloading)

- [Method overloading pros](#pros-of-method-overloading)
  
- [Method overloading cons](#cons-of-method-overloading)

- [Conclusion on method overloading](#conclusion)

- [Method overloading practice exercises](#method-overload-practice-exercises)

- [Method overriding description](#method-overriding-description)

- [Method overriding example](#example-1)

- [Method overriding best practices](#best-practices-for-using-method-overriding)

- [Method overriding pros](#pros-of-method-overriding)

- [Method overriding cons](#cons-of-method-overriding)

- [Conclusion on method overriding](#conclusion-1)

- [Method overriding practice exercises](#method-overriding-practice-exercises)

___

___

## Method overloading description:

**Method overloading** in Java is a feature that allows different methods to have the same name, but different parameters/signatures.
The signature/parameters of a method can differ by the number of input parameters, type of input parameters, or both.
This feature increases the readability of the program code.
Method Overloading can be achieved in different ways:

* **Changing the number of parameters:**
  Method overloading can be achieved by changing the number of parameters while passing to different methods.


* **Changing Data Types of the Arguments:**
  Methods can be considered overloaded if they have the same name but have different parameter types.

Method overloading in Java is also known as:

* _Compile-time_
* _Polymorphism_
* _Static Polymorphism_
* _Early binding._

However, it’s important to note that method overloading <font color="red">**_is not possible_**</font> by changing the return type of the method only.
This is due to ambiguity, as the compiler would not be able to determine which method to call if the methods differ only by return type.
Method Overloading: is a compile-time polymorphism where you have multiple methods with the same name but different parameters.
It can occur within the same class.
Method overloading is limited to the scope of a single class because it’s based on having different method signatures in the same class.

[Back to top](#table-of-content)

## Example:

Consider a `Button` class with a `create` method that is overloaded to handle different scenarios:

```java
class Button {
    // Method to create a button with text
    public void create(String text) {
        System.out.println("Button with text: " + text + " created");
    }

    // Method to create a button with text and a specific size
    public void create(String text, int width, int height) {
        System.out.println("Button with text: " + text + " and size: " + width + "x" + height + " created");
    }

    // Method to create a button with text, size, and color
    public void create(String text, int width, int height, String color) {
        System.out.println("Button with text: " + text + ", size: " + width + "x" + height + ", and color: " + color + " created");
    }
}
```
<a href="#top">Back to top</a>

## Best practices for applying  method overloading:

* **Consistent Naming:**
  Use the same method name for similar actions.
  This improves code readability and maintainability.


* **Parameter Variations:**
  Use different parameters for the same method to handle different scenarios.
  For example, you might have a clickButton() method.
  One version of the method could take a string representing the button’s ID, while another could take an object representing the button itself.


* **Default Parameters:**
* You can use method overloading to provide default parameters.
  For example, if you have a method that performs an action with an optional timeout, you could provide two versions of the method: one that takes the timeout as a parameter, and another that uses a default timeout.


* **Flexibility:**
  Method overloading provides flexibility in the input a method can accept, making your test code more robust and flexible to changes in the application under test.


* **Code Re-usability:**
  It helps in reusing the same method name with different parameters, thus making the code more readable and reducing redundancy.

[Back to top](#table-of-content)

## Pros of method overloading:

* **Readability:**
  Method overloading improves the readability of the program. It allows different methods to have the same name but different signatures, which can make the code easier to understand


* **Re-usability:**
  It enhances the re-usability of the code. You can use the same method name for different purposes with different input parameters.


* **Reduced Complexity:**
  Method overloading can help to reduce the complexity of the program. It allows you to use a single method name to perform different tasks, reducing the need for multiple different method name.


* **Flexibility:**
  Overloaded methods give programmers the flexibility to call a similar method for different types of data.


* **Efficiency:**
  Method overloading can make the program more efficient by allowing the appropriate method to be called based on the specific type and number of arguments.

[Back to top](#table-of-content)

## Cons of method overloading:

* **Confusing Behavior:**
  If overloaded methods perform vastly different operations, it can lead to confusing and unpredictable behavior. Overloaded methods should ideally perform the same operation with different inputs.


* **Complexity:**
  Overloading can increase the complexity of the code, especially when there are many overloaded methods with similar parameter types. It can make the code harder to read and maintain.


* **Autoboxing and Nulls:**
  Autoboxing and unboxing can lead to unexpected results with overloaded methods. For example, if you have overloaded methods that take an Integer and an int, passing a null value can cause a NullPointerException.


* **Inheritance:**
  In a class hierarchy, if a subclass defines a method that has the same name but a different parameter list than a public or protected method in the superclass, the subclass method does not override the superclass method. This can lead to unexpected behavior.


* **Type Promotion:**
  Java uses type promotion for matching arguments, and this can lead to unexpected results. For example, if you have overloaded methods where one takes a long and another takes an int, and you call the method with a byte value, the version with the int parameter will be called, not the long.


* **Testing Difficulty:**
  Overloaded methods can make writing unit tests more difficult, as you need to ensure that all versions of the method are correctly tested.

[Back to top](#table-of-content)

## Conclusion:

Method overloading is a powerful tool.
However, it should be used judiciously to avoid ambiguity and maintain clear code.

[Back to top](#table-of-content)


## Method overloading practice exercises:

### Exercise 1:
Create a class with a method that prints “ONE” when no arguments are passed, and “TWO” when one integer argument is passed.

<details>
<summary>Solution</summary>

```Java

public class MainClass {
    static void overloadedMethod() {
        System.out.println("ONE");
    }

    static void overloadedMethod(int a) {
        System.out.println("TWO");
    }

    public static void main(String[] args) {
        overloadedMethod();
        overloadedMethod(1);
    }
}
```
</details>

### Exercise 2:
In the below class, is ‘method’ overloaded or duplicated?

<details>
<summary>Solution</summary>

```Java
public class MainClass {
    void method(int... a) {
        System.out.println(1);
    }

    void method(int[] a) {
        System.out.println(2);
    }
}
```

</details>

### Exercise 3:
In the below Class X, is ‘method’ properly overloaded?

<details>
<summary>Solution</summary>

```java
class X {
    int method(int i, int d) {
        return i + d;
    }

    static int method(int i, double d) {
        return (int) (i + d);
    }

    double method(double i, int d) {
        return i + d;
    }

    static double method(double i, double d) {
        return i + d;
    }
}
```
</details>

### Exercise 4:
Create a class with overloaded methods that accept different number of arguments and data types.

<details>
<summary>Solution</summary>

```java
class MethodOverloading {
    private static void display(int a) {
        System.out.println("Arguments: " + a);
    }

    private static void display(int a, int b) {
        System.out.println("Arguments: " + a + " and " + b);
    }

    public static void main(String[] args) {
        display(1);
        display(1, 4);
    }
}
```
</details>

### Exercise 5:
Overload a method by changing the data type of parameters.

<details>
<summary>Solution</summary>

```java
class MethodOverloading {
    // this method accepts int
    private static void display(int a) {
        System.out.println("Got Integer data.");
    }

    // this method accepts String object
    private static void display(String a) {
        System.out.println("Got String object.");
    }

    public static void main(String[] args) {
        display(1);
        display("Hello");
    }
}
```

</details>

[Back to top](#table-of-content)

## Method overriding description:

**Method overriding** a Java feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes.
This is one of the ways Java achieves runtime polymorphism.
When a method in a subclass has the same name, same parameters or signature, and the same return type (or subtype) as a method in its super-class, the method in the subclass is said to override the method in the super-class.
The version of a method that is executed will be determined by the object that is used to invoke it.

[Back to top](#table-of-content)

## Example:

In this example, the `run` method in the `Bike` class overrides the `run` method in the `Vehicle` class.
When the `run` method is called using an object of the `Bike` class, “Bike is running safely” is printed instead of "Vehicle is running"

```java
// Creating a parent class.
class Vehicle {
// Defining a method
void run() {
System.out.println("Vehicle is running");
}
}

// Creating a child class
class Bike extends Vehicle {
// Defining the same method as in the parent class
@Override    
void run() {
System.out.println("Bike is running safely");
}

    public static void main(String [] args) {
        Bike obj = new Bike(); // Creating object
        obj.run(); // Calling method
    }
}
```
[Back to top](#table-of-content)

## Best practices for using method overriding:

* **Correct Method Signature:** The overriding method in the subclass must have the same signature as the method in the superclass.
  The method signature includes the method name, return type, and parameter list.


* **Access Modifiers:** The access level of the overriding method cannot be more restrictive than the access level of the method in the superclass.
  For example, if the superclass method is declared as public, the overriding method in the subclass must also be declared as public.


* **Final Methods:** A method declared as final in the superclass cannot be overridden in the subclass.


* **Static Methods:** Static methods cannot be overridden in the subclass, as they belong to the class rather than the instance.
  Attempting to override a static method will result in method hiding rather than method overriding.


* **Constructors:** Constructors cannot be overridden, as they have the same name as the class and are not inherited by the subclass.


* **Using the super Keyword:** The super keyword is used to refer to the superclass and can be used to access the superclass’s method from an overridden method in the subclass.


* **Use @Override Annotation:** Always use the **_@Override_** annotation when you intend to override a method.
  This tells the compiler that you intend to override a method in the superclass.
  If you do not correctly override the method (for example, the names or parameters do not match exactly with the method in the superclass), the compiler will generate an error.


* **Don’t Override Methods Indiscriminately:** Only override methods when it is necessary.
  Overriding methods indiscriminately can make the code difficult to understand and maintain.


* **Be Careful with Overriding Methods Called from Constructors:** If you call an overridden method from a constructor, it will execute in a context where some of the fields it wants to use aren’t initialized.
  Therefore, you should avoid doing that if possible.

[Back to top](#table-of-content)

## Pros of method overriding:

* **Runtime Polymorphism:**
  Method overriding is used to achieve runtime polymorphism.
  It allows Java to decide which method to invoke at runtime, based on the type of the object.


* **Code Re-usability:**
  Method overriding allows a subclass to use the methods of its superclass, promoting code re-usability.


* **Flexibility:**
  It provides the flexibility to define a behavior that’s specific to the subclass type, which means a subclass can implement a parent method based on its requirement.


* **Specific Implementation:**
  Method overriding is used when a subclass wants to provide a specific implementation of a method that is already provided by its superclass.


* **Clean and Understandable Code:**
  It helps to produce clean and understandable code.
  The same method name is used in the superclass and subclasses, increasing the readability of the code.


* **Abstract Methods:**
  In the case of abstract methods (methods without a body), method overriding is necessary for the subclass to provide the implementation.

[Back to top](#table-of-content)

## Cons of method overriding:

* **Inheritance Requirement:**
  Method overriding can only be done if the classes are in an inheritance relationship.
  If there is no inheritance relationship, method overriding cannot be used.


* **Package Limitation:**
  Method overriding cannot be done outside the package.


* **Visibility Restriction:**
  In method overriding, you cannot reduce the visibility of the overridden method.
  For example, a public method in the superclass cannot be overridden as a private method in the subclass.


* **Contract Violation:**
  When overriding a method, ensure that the new implementation adheres to the contract established by the superclass.
  Violating this contract can lead to unexpected behavior and make your code harder to maintain.


* **Complexity:**
  Overriding methods can increase the complexity of the code, making it harder to read and maintain.
  It can also lead to confusion if not properly documented.


* **Errors in Overriding:**
  Errors can occur in method overriding if the method signatures are not exactly the same.
  This includes the method name, return type, and parameters.

[Back to top](#table-of-content)

## Conclusion:
Remember, while method overriding is a powerful feature, it should be used wisely.
Overriding methods indiscriminately can make the code difficult to understand and maintain.

[Back to top](#table-of-content)

## Method-overriding-practice-exercises:

### Exercise 1:
Create a basic Method Overriding

<details>
<summary>Solution</summary>

```Java

class Animal {
  public void displayInfo() {
    System.out.println("I am an animal.");
  }
}

class Dog extends Animal {
  @Override
  public void displayInfo() {
    System.out.println("I am a dog.");
  }
}

public class Main {
  public static void main(String[] args) {
    Dog d1 = new Dog();
    d1.displayInfo();
  }
}
```
</details>


### Exercise 2: Make an overriding method with super Keyword

<details>
<summary>Solution</summary>

```java
class Animal {
    public void displayInfo() {
        System.out.println("I am an animal.");
    }
}

class Dog extends Animal {
    public void displayInfo() {
        super.displayInfo();
        System.out.println("I am a dog.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.displayInfo();
    }
}
```
</details>

### Exercise 3: Make an overriding method with Polymorphism

<details>
<summary>Solution</summary>

```java
class X {
    void method(int a) {
        System.out.println("ONE");
    }

    void method(double d) {
        System.out.println("TWO");
    }
}

class Y extends X {
    @Override
    void method(double d) {
        System.out.println("THREE");
    }
}

public class MainClass {
    public static void main(String[] args) {
        new Y().method(100);
    }
}
```
</details>

[Back to top](#table-of-content)