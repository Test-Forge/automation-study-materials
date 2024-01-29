# Exception Handling and Custom Exceptions Guide

## Overview

Exception handling is a critical aspect of writing robust and reliable code. This guide provides comprehensive
information on exception handling and the creation of custom exceptions. Understanding these concepts is essential for
developing software that gracefully handles errors and ensures a smooth user experience.

## Table of Contents

1. [Introduction to Exception Handling](#1-introduction-to-exception-handling)
2. [Benefits of Exception Handling](#2-benefits-of-exception-handling)
3. [Basic Exception Handling in Java](#3-basic-exception-handling-in-java)
4. [Exception Handling Best Practices](#4-exception-handling-best-practices)
5. [Exception Handling Example](#5-exception-handling-example)
6. [Custom Exceptions](#6-custom-exceptions)

- [Why Use Custom Exceptions?](#61-why-use-custom-exceptions)
- [Creating Custom Exceptions](#62-creating-custom-exceptions)
- [Best Practices for Custom Exceptions](#63-best-practices-for-custom-exceptions)

7. [Practice](#7-practice)

## 1. Introduction to Exception Handling

Exception handling is a programming paradigm that deals with the occurrence of runtime errors. It allows developers to
gracefully handle unexpected situations and provide alternative paths for execution when errors occur.

## 2. Benefits of Exception Handling

- **Robustness:** Exception handling improves the robustness of your code by handling unexpected situations.
- **Readability:** Well-implemented exception handling makes code more readable and maintainable.
- **Maintainability:** It simplifies debugging and maintenance by isolating error-handling logic.
- **User Experience:** Properly handled exceptions contribute to a smoother user experience.

## 3. Basic Exception Handling in Java

In Java, exception handling is implemented using `try`, `catch`, and `finally` blocks. Here's a basic example:

```java
try{
        // Code that may throw an exception
        }catch(ExceptionType e){
        // Handle the exception
        }finally{
        // Code that executes regardless of whether an exception occurred
        }
```

## 4. Exception Handling Best Practices

- **Handle only specific exceptions:** <br> Catching and handling all exceptions is not a good practice. Instead, try to
  catch only specific exceptions that you are expecting. This helps to improve the readability and maintainability of
  the code.
- **Use meaningful exception messages:** <br> When you catch an exception, always use meaningful and informative
  messages. This helps to identify the root cause of the exception quickly and take appropriate actions.
- **Log exceptions:** <br> Logging exceptions is essential for debugging and troubleshooting. Use a logging framework
  like Log4j or Java Util Logging to log exceptions.
- **Don’t swallow exceptions:** <br> Swallowing exceptions means catching an exception but not doing anything about it.
  This is a bad practice as it can lead to unexpected behavior and errors in the application.
- **Throw checked exceptions:** <br> Checked exceptions are those that the Java compiler requires you to catch or
  declare in the method signature. Always throw checked exceptions instead of catching them silently.
- **Use finally block for resource cleanup:** <br> The 'finally' block is always executed, whether an exception occurs
  or not. Use the 'finally' block to release any resources that were acquired in the try block, such as closing database
  connections, files, or streams.
- **Use exception chaining:** <br> Exception chaining is a technique where you wrap an exception in another exception.
  This helps to preserve the original exception’s stack trace and provide more meaningful information about the error.
- **Use custom exceptions:** <br> Custom exceptions are user-defined exceptions that are specific to an application. Use
  custom exceptions to provide more meaningful and descriptive errors to the users.
- **Don’t catch Error:** <br> Errors are severe exceptions that cannot be recovered from. Avoid catching Error in your
  code as it can lead to unpredictable behavior.
- **Keep exception handling code separate:** Keep the exception handling code separate from the main logic of the
  application. This makes the code more readable and easier to maintain.

## 5. Exception Handling Example

This Java example demonstrates exception handling with multiple `catch` blocks, a `finally` block, and `logging`.

```java
import java.util.logging.Logger;

public class ExceptionHandlingExample {

    private static final Logger logger = Logger.getLogger(ExceptionHandlingExample.class.getName());

    public static void main(String[] args) {
        try {
            // Code that may throw exceptions
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero exception
            logger.severe("ArithmeticException occurred: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle array index out of bounds exception
            logger.severe("ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other exceptions
            logger.severe("An unexpected exception occurred: " + e.getMessage());
        } finally {
            // Code that will be executed regardless of whether an exception occurs or not
            System.out.println("Finally block executed.");
        }
    }

    public static int divide(int numerator, int denominator) {
        // Method that may throw an ArithmeticException
        return numerator / denominator;
    }
}
```

## Explanation

1. **`divide` Method:**
    - The `divide` method simulates an arithmetic operation that may result in an `ArithmeticException` (division by
      zero).

2. **`main` Method:**
    - Contains a try-catch block where we attempt to call the `divide` method with arguments that lead to an exception.

3. **Multiple Catch Blocks:**
    - Different catch blocks handle specific types of exceptions:
        - `ArithmeticException`: Handles division by zero exception.
        - `ArrayIndexOutOfBoundsException`: Handles array index out of bounds exception.
        - `Exception`: Catches any other unexpected exceptions.

4. **`finally` Block:**
    - Contains code that will be executed regardless of whether an exception occurs or not.
    - A message is printed to indicate that the `finally` block has been executed.

5. **Logging:**
    - The `Logger` class is used for logging exceptions.
    - The `severe` method is employed to log messages with a higher severity level.

<details>
<summary>Good to know: Types of Exceptions</summary>
<br>

**Types of Exceptions in Java**

Java exceptions are categorized into two main types:

- **Checked exceptions:**
  <br> Are exceptions which you must handle properly in your code. The compiler will force you to properly handle these
  exceptions. You can either catch these exceptions or declare them in the throws clause of your method.
- **Unchecked exceptions:**
  <br> Also known as runtime exceptions, are exceptions that do not need to be caught explicitly or declared using the
  throws keyword. They usually represent programming errors, such as invalid calculations or incorrect usage of APIs,
  that can be prevented by proper code design and testing.

```plaintext
Throwable
|
├── Error
|
└── Exception
    |
    ├── IOException
    |
    ├── SQLException
    |
    ├── RuntimeException
    |   |
    |   ├── NullPointerException
    |   |
    |   ├── ArrayIndexOutOfBoundsException
    |   |
    |   └── ArithmeticException
    |
    └── ... (other subclasses of Exception)
```

In the above exception hierarchy tree, Throwable is the root class.

- **Exception:** This is the base class for all checked exceptions.
- **RuntimeException:** This is the base class for all unchecked exceptions.

</details>

## 6. Custom Exceptions

### 6.1 Why Use Custom Exceptions?

Custom exceptions allow developers to create application-specific exception types, providing more meaningful error
messages and aiding in the debugging process.

### 6.2 Creating Custom Exceptions

To create a custom exception in Java, you need to extend the `Exception` class or one of its subclasses. Here's an
example:

```java
public class CustomException extends Exception {
    // Constructors and additional methods can be added here
}
```

### 6.3 Best Practices for Custom Exceptions

- **Descriptive Names:** Use names that clearly indicate the nature of the problem.
- **Inheritance:** Extend from appropriate exception classes for better categorization.
- **Provide Context:** Include additional information in the exception to aid debugging.

## 7. Practice

# File Operations and Mathematical Operations Exercise

## Objective

Create a Java program that reads data from a file, converts the read lines into integers, performs mathematical
operations, and handles exceptions appropriately.

## Steps to Implement

1. **Read from File:**
    - Utilize `FileReader` to read from a file. (You can create a sample text file for this exercise.)

2. **Read Lines from File:**
    - Use `BufferedReader` to read lines from the file.

3. **Convert Lines to Integers:**
    - Convert the read lines into integers. Assume the file contains integer values.

4. **Perform Mathematical Operations:**
    - Implement a method for performing mathematical operations (e.g., sum, average) on the read integers.

5. **Handle Exceptions:**
    - Handle exceptions that may occur during file operations, conversion to integers, or mathematical operations.

## Requirements

1. **Reading and Conversion Method:**
    - Implement a method for reading lines from the file and converting them to integers.

2. **Mathematical Operations Method:**
    - Implement a method for performing mathematical operations on the integers.

3. **Exception Handling:**
    - Handle exceptions appropriately using try-catch blocks.

4. **Logging Exceptions:**
    - Log exceptions using a logging framework (e.g., Log4j or Java Util Logging).

## Additional Challenges

1. **Custom Exceptions:**
    - Create custom exceptions for specific error scenarios (e.g., invalid file format, division by zero during
      mathematical operations).

<details>
<summary>Implementation here</summary>
<br>

[FileOperationExercise Class](<Exercise/FileOperationExercise.java>)

[InvalidDataException Class](<Exercise/InvalidDataException.java>)

[Sample text file](<Exercise/sample_file.txt>)

**Change values in the [file](<sample_file.txt>) to get different exceptions:**

- `g` value for `InvalidDataException` (custom exception in this case).
- `10` value for `ArithmeticException`

**Change [fileName](<FileOperationExercise.java>)** to get `IOException`

</details>