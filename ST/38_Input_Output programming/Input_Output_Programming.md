# Input/Output programming

by [Stanislav Scurtu](mailto:stanislav.scurtu@gmail.com)\
Feb 2024

## Overview

This material will introduce you to the basics of Input/Output programming and
teach you how to read and write data in various formats. You will explore different
programming languages and techniques for processing input and generating
output.

## Table of Contents

1. [Introduction to Input/Output programming](#introduction-to-inputoutput-programming)
    - [Understanding Input/Output Programming](#understanding-inputoutput-programming)
    - [Devices and Input/Output Channels](#devices-and-inputoutput-channels)
    - [File I/O Operations](#file-io-operations)
    - [User Input and Output](#user-input-and-output)
    - [Error Handling and Exceptional Situations](#error-handling-and-exceptional-situations)
    - [Conclusion](#conclusion)
2. [Input methods and techniques](#input-methods-and-techniques)
    - [Introduction](#introduction)
    - [Keyboard Input](#keyboard-input)
        - [Reading Input Character by Character](#1-reading-input-character-by-character)
        - [Capturing Entire Lines of Text](#2-capturing-entire-lines-of-text)
    - [File Input](#file-input)
    - [Other Input Methods and Techniques](#other-input-methods-and-techniques)
        - [Command Line Arguments](#1-command-line-arguments)
        - [GUI Input Widgets](#2-gui-input-widgets)
        - [Sensor Input](#3-sensor-input)
    - [Conclusion](#conclusion-1)
3. [Output methods and techniques](#output-methods-and-techniques)
    - [Introduction](#introduction-1)
    - [Print Statements](#print-statements)
    - [Formatting Output](#formatting-output)
    - [File Output](#file-output)
    - [Graphical Output](#graphical-output)
    - [Web-based Output](#web-based-output)
    - [Conclusion](#conclusion-2)
4. [Practical Exercises](#practical-exercises)
5. [Wrap-up](#wrap-up)

# Introduction to Input/Output programming

***
Input/Output (I/O) programming is a fundamental aspect of software development that enables communication between a
computer system and external devices or user input. It involves the exchange of data between the computer and the real
world, allowing software to interact with its environment. This topic explores the essential concepts and techniques
used in Input/Output programming, providing a solid foundation for understanding and implementing I/O operations in
software applications.

## Understanding Input/Output Programming

At its core, Input/Output programming deals with the handling of input and output operations in software. Input refers
to any data received by the program from external sources, such as user input devices (e.g., keyboard, mouse), files, or
network connections. Output, on the other hand, involves sending data from the program to external destinations, such as
displays, files, or network transmissions.

The main objective of Input/Output programming is to facilitate the flow of information, enabling software applications
to receive input and generate meaningful output. This interaction with external devices is crucial for the functionality
and usability of various systems, ranging from simple command-line applications to complex graphical user interfaces.

## Devices and Input/Output Channels

In Input/Output programming, a device refers to any entity with which the software interacts to perform input or output
operations. Devices can be physical, such as keyboards, printers, or sensors, or logical, such as network connections or
file systems. Each device typically provides one or more channels for communication.

Channels act as conduits through which data flows between the program and the device. Each channel has a specific
purpose, such as handling input data streams or output data streams. Understanding the concept of channels is crucial
for effectively managing I/O operations in software.

## File I/O Operations

One common form of Input/Output programming revolves around reading from and writing to files. Files provide a
persistent storage medium for data and allow software applications to store and retrieve information across multiple
program executions. File I/O operations involve reading data from files into the program or writing data from the
program to files.

Understanding how to perform file I/O operations is essential for many applications. It enables the creation,
modification, and deletion of files, as well as the ability to process and analyze existing data stored in files.
Learning file I/O techniques is particularly important in scenarios where the software needs to maintain data integrity,
handle large datasets, or interact with external systems through file-based protocols.

## User Input and Output

Interacting with users is a fundamental aspect of many software applications. Input/Output programming allows software
to receive user input through various devices, such as keyboards, mice, touchscreens, or voice recognition systems. This
input can then be processed by the program to trigger specific actions or provide appropriate responses.

Similarly, software applications often need to provide output to users, whether it's displaying messages, presenting
graphical interfaces, or generating reports. Output techniques involve formatting and presenting information in a
human-readable format, making it more accessible and meaningful to users.

## Error Handling and Exceptional Situations

In Input/Output programming, error handling plays a crucial role in ensuring the reliability and stability of software
applications. Errors can occur due to various reasons, such as hardware failures, network issues, or invalid user input.
Effective error handling mechanisms allow software to gracefully handle such exceptional situations and provide
appropriate feedback or recovery options.

Understanding different error handling techniques and best practices is essential for robust Input/Output programming.
It enables software applications to detect and recover from errors, communicate error states to users, and ensure system
stability even in challenging circumstances.

## Conclusion

Input/Output programming is a fundamental concept in software development that enables communication between computer
systems and the external world. Understanding the principles and techniques involved in Input/Output programming is
essential for creating efficient and user-friendly applications that can handle external data sources, interact with
users, and gracefully handle exceptional situations.

# Input methods and techniques

***

## Introduction

In the realm of programming, input refers to the process by which data is received into a computer system or a program.
This data can be acquired from various sources such as user interactions, sensors, files, or other external devices.
Input methods and techniques serve as crucial components of the Input/Output (I/O) programming process, enabling
software to interact with users and receive data that drives its execution.

This topic explores the different input methods and techniques commonly used in programming, highlighting their
characteristics, implementation, and best practices.

## Keyboard Input

One of the most fundamental forms of input is keyboard input, where users enter data by pressing keys on a physical or
virtual keyboard. In programming, capturing keyboard input involves identifying and processing keystroke events.
Typically, operating systems and programming languages provide libraries or APIs for handling keyboard events.

Keyboard input can be obtained using different approaches, such as reading input character by character or capturing
entire lines of text. Programmers can choose the appropriate method depending on the specific requirements of their
application.

### 1. Reading Input Character by Character

In this approach, a program reads characters one by one from the keyboard. This method is suitable for scenarios where
immediate action is required in response to each key press. To implement this technique, programmers can utilize
functions or methods provided by programming languages to read characters directly from the input buffer.

An example code snippet in Python demonstrates this technique:

```python
import readchar

print("Enter characters, 'q' to quit.")

while True:
    c = readchar.readchar()
    if c == 'q':
        print("Goodbye!")
        break
    else:
        print(f"You typed: {c}")
```

> In this program, the _readchar.readchar()_ function reads a single character from the user input and then prints the
> character to the console. The program checks if the character is 'q' to quit; otherwise, it prints the character.

### 2. Capturing Entire Lines of Text

Alternatively, programmatically capturing entire lines of text entered by the user is useful when the input should be
processed only after the user completes their input. This approach allows users to edit their input before submitting
it. The line input method is commonly used for input fields that require text entry, such as command line interfaces or
text editors.

```python
print("Enter text, type 'quit' to exit.")

while True:
    line = input("Please enter a line of text: ")
    if line == 'quit':
        print("Exiting the program.")
        break
    else:
        print(f"You entered: {line}")
```

> In this program, the _input()_ function is used within a loop to continuously prompt the user for input. The prompt "
> Please enter a line of text: " is displayed to the user, and the function waits for the user to enter a line of text
> and
> press Enter. The entered text is then stored in the variable line. The program checks if the user entered 'quit' to
> exit; otherwise, it prints the line entered by the user. This approach allows users to enter and edit entire lines of
> text before the program processes their input.

## File Input

Input methods are not limited to user interactions; input data can also originate from external files. File input
enables programs to read data stored in files, which can be processed and utilized within the program's execution.
Common data formats for file input include plain text files, CSV (Comma-Separated Values), JSON (JavaScript Object
Notation), and XML (eXtensible Markup Language).

To read from a file in programming languages, developers typically follow these steps:

1. Open the desired file by creating a file object or using specific functions provided by the programming language or
   standard library.
2. Read the content of the file using appropriate methods or functions.
3. Process the obtained data as per the program's requirements.
4. Close the file once data extraction is complete.

Here's an example code snippet in Java demonstrating file input:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputExample {
    public static void main(String[] args) {
        try {
            File inputFile = new File("data.txt");
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line data as desired
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
```

## Other Input Methods and Techniques

Aside from keyboard and file input, programming languages and frameworks offer various additional input methods and
techniques. Some notable ones include:

### 1. Command Line Arguments

Command line arguments allow users to provide input to a program directly from the command line when executing it. This
provides a convenient way to parameterize program behavior without requiring user interaction during runtime.
Programmers can access these arguments within their programs and use them to customize program execution.

### 2. GUI Input Widgets

Graphical User Interfaces (GUIs) provide a rich set of input widgets or controls that allow users to interact
graphically with programs. These widgets include buttons, checkboxes, radio buttons, dropdown menus, sliders, and text
input fields. The programming frameworks or libraries used for GUI development offer APIs to capture input from these
widgets, enabling developers to build interactive applications.

### 3. Sensor Input

With the proliferation of mobile devices, sensor input has become increasingly important. Modern smartphones, tablets,
and wearables contain various sensors, such as accelerometers, GPS, gyroscopes, and touchscreens, enabling developers to
gather input from the surrounding environment. Integrating sensor inputs into a program helps create context-aware and
interactive applications.

## Conclusion

To summarize, Introduction to Input/Output programming provides a solid foundation for understanding the basics of input
and output in programming. It covers the importance of user interaction and the various ways to gather input from users.

# Output methods and techniques

***

## Introduction

In the field of input/output (I/O) programming, the output phase plays a crucial role in making data accessible and
meaningful to users. Output methods and techniques provide a structured approach to present information in a clear and
organized manner. This topic explores various techniques and methods used in output programming to improve the
efficiency and effectiveness of delivering output to users.

## Print Statements

One of the simplest and most common methods of output in programming is the use of print statements. These statements
allow data to be displayed on a console or in the form of a hard copy. Print statements are particularly useful for
debugging purposes or for providing immediate feedback to users. They can be directly embedded in the code or used to
display intermediate results during program execution.

`in Python:`

```python
# Printing a greeting
print("Hello, world!")
```

`in Java:`

```java
class HelloWorld {
    public static void main(String[] args) {
        // Printing a greeting
        System.out.println("Hello, World!");
    }
}
```

> These simple examples demonstrates illustrates the use of print statements to display static text. It's a simple yet
> effective demonstration of how output can be generated in programming.

## Formatting Output

To enhance readability and better convey information, formatting techniques are employed in output programming. These
techniques involve the use of special symbols, characters, or formatting functions to manipulate the appearance of the
output. Common formatting methods include:

1. **String Concatenation:** Combining multiple strings or variables into a single output statement using concatenation
   operators such as the plus sign (+).

```Java
String name = "John";
int age = 30;
System.out.

println("Name: "+name +", Age: "+age);
```

> Name: John, Age: 30

2. **String Interpolation:** Including variables directly within a string using placeholders (e.g., using %s to
   substitute a string value).

```Java
String city = "New York";
double temperature = 25.5;
System.out.

printf("Current temperature in %s is %.1f degrees Celsius%n",city, temperature);
 ```

> Current temperature in New York is 25.5 degrees Celsius

3. **Escape Sequences:** Inserting special characters or symbols within a string to control formatting (e.g., using \n
   for a new line).

```Java
System.out.println("This is the first line.\nThis is the second line.");
```

> This is the first line.
> This is the second line.

4. **Formatting Functions:** Utilizing formatting functions provided by programming languages to control the layout and
   appearance of output.

```Java
String formattedString = String.format("Name: %s, Age: %d", name, age);
System.out.

println(formattedString);
```

> Name: John, Age: 30

## File Output

In addition to display on a console, output can be directed to files, expanding the scope of information sharing and
preservation. File output methods enable programmers to save data in a structured format and access it at a later time.
Some commonly used file output techniques include:

1. **Writing to Text Files:** Saving output in plain text files by opening a file in write mode and using appropriate
   write functions to insert data into the file.

```Java
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SimpleTextFileWriter {
    public static void main(String[] args) throws Exception {
        String text = "Hello, world! This is a sample text file.";
        BufferedWriter writer = new BufferedWriter(new FileWriter("sample.txt"));
        writer.write(text);
        writer.close();
        System.out.println("Data written to sample.txt");
    }
}
```

> This Java code writes a simple string to a text file.

2. **CSV Output:** Writing output in Comma-Separated Values (CSV) format, commonly used for tabular data storage,
   manipulation, and exchange.

```Java
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SimpleCsvFileWriter {
    public static void main(String[] args) throws Exception {
        String[] data = {"Name,Age,City", "John Doe,30,New York", "Jane Doe,25,Los Angeles"};
        BufferedWriter writer = new BufferedWriter(new FileWriter("sample.csv"));

        for (String row : data) {
            writer.write(row);
            writer.newLine();
        }

        writer.close();
        System.out.println("CSV data written to sample.csv");
    }
}
```

> This Java code writes simple CSV data to a file.

3. **Markup Languages:** Storing output using markup languages like HTML or XML to retain structure, enable further
   processing, and support cross-platform compatibility.

```java
import java.io.FileWriter;
import java.io.IOException;

public class HtmlOutputExample {
    public static void main(String[] args) throws IOException {
        String filename = "output.html";
        String htmlContent = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Sample Page</title>
                </head>
                <body>
                    <h1>Hello, world!</h1>
                    <p>This is a simple HTML file written from Java.</p>
                </body>
                </html>
                """;

        FileWriter writer = new FileWriter(filename);
        writer.write(htmlContent);
        writer.close();
        System.out.println("HTML data has been written to " + filename);
    }
}
```

> This Java program generates a simple HTML file containing a title, a heading, and a paragraph.

## Graphical Output

When dealing with complex data or visualizations, graphical output provides a more intuitive way to present information.
By leveraging graphical output methods, programmers can create visual representations of data that are easier to
interpret and understand. Some common techniques for graphical output include:

1. **Charting Libraries:** Utilizing specialized libraries or frameworks like Matplotlib, ggplot, or D3.js to generate
   charts, graphs, or visualizations.
2. **Graphical User Interface (GUI):** Using GUI toolkits, such as Tkinter or JavaFX, to develop applications that
   display more complex and interactive graphical output.
3. **Plotting Techniques:** Employing techniques like scatter plots, histograms, or heatmaps to portray data
   relationships or distributions effectively.

## Web-based Output

In today's interconnected world, sharing output online is often necessary. Web-based output techniques enable
programmers to present information on websites or web applications, making it accessible to a wider audience. Common
methods for web-based output include:

1. **Server-Side Scripting:** Generating output dynamically on the server side using server-side scripting languages
   like PHP, ASP.NET, or Node.js.
2. **Client-Side Scripting:** Using client-side scripting languages such as JavaScript to dynamically manipulate the
   output within a web browser.
3. **Application Programming Interfaces (APIs):** Integrating output into web applications through APIs, allowing other
   systems or applications to access and utilize the output data.

## Conclusion

Output methods and techniques in programming play a crucial role in delivering information to users in a meaningful way.
From simple print statements to complex graphical or web-based output, choosing the appropriate method enhances the user
experience and facilitates data interpretation. By applying various output techniques, programmers can empower users
with well-organized and visually appealing output that meets their needs.

# Practical Exercises

***
In this lesson, we'll put theory into practice through hands-on activities. Click on the items below to check each
exercise and develop practical skills that will help you succeed in the subject.

### Basic Input/Output Program

> Write a program that takes user input and displays it on the screen.
<details>
<summary><b>Expand example in Java</b></summary>

This program does the following:

1. Creates a Scanner object to read user input from the console.
2. Prompts the user to enter some text.
3. Reads the input provided by the user using scanner.nextLine().
4. Displays the input back to the user.
5. Closes the Scanner object to release resources.

When you run this program, it will wait for the user to enter some text. After the user enters the text and presses
Enter, the program will display the entered text back to the user.

```Java
import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
// Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter some text
        System.out.print("Enter some text: ");

        // Read the input provided by the user
        String userInput = scanner.nextLine();

        // Display the input back to the user
        System.out.println("You entered: " + userInput);

        // Close the Scanner object to release resources
        scanner.close();
    }
}
```

</details>

### Temperature Converter

> Write a program that converts temperature from Celsius to Fahrenheit or vice versa based on user input.
<details>
<summary><b>Expand example in Java</b></summary>

This program does the following:

1. Prompts the user to choose the conversion type: Celsius to Fahrenheit or Fahrenheit to Celsius.
2. Reads the user's choice.
3. Based on the choice, prompts the user to enter the temperature.
4. Performs the conversion and displays the result.

You can run this program, choose the conversion type, enter the temperature, and it will convert it accordingly.

```Java
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose the conversion type
        System.out.println("Choose the conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");

        // Read the choice provided by the user
        int choice = scanner.nextInt();

        double temperature;
        double convertedTemperature;

        // Perform the conversion based on the user's choice
        if (choice == 1) {
            // Convert Celsius to Fahrenheit
            System.out.print("Enter temperature in Celsius: ");
            temperature = scanner.nextDouble();
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
        } else if (choice == 2) {
            // Convert Fahrenheit to Celsius
            System.out.print("Enter temperature in Fahrenheit: ");
            temperature = scanner.nextDouble();
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println("Temperature in Celsius: " + convertedTemperature);
        } else {
            System.out.println("Invalid choice. Please enter either 1 or 2.");
        }

        // Close the Scanner object to release resources
        scanner.close();
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
```

</details>

### File Writer

> Write a program that takes user input and saves it to a file.
<details>
<summary><b>Expand example in Java</b></summary>

How It Works:

1. The program starts by creating a Scanner object to read the user's input from the console.
2. The user is prompted to enter some text, which is then read and stored in the userInput variable.
3. A FileWriter is created to write to a file named userInput.txt. If the file doesn't exist, it will be created.
4. The user's input is written to the file using the write() method of the FileWriter.
5. The FileWriter is then closed to free system resources and finalize changes to the file.

```Java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleInputToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter some text:");
        String userInput = scanner.nextLine();

        // Define the filename
        String filename = "userInput.txt";

        // Use FileWriter to write the input to a file
        FileWriter writer = new FileWriter(filename);
        writer.write(userInput);
        writer.close();

        System.out.println("Your input was saved to " + filename);

        scanner.close();
    }
}
```

> Run the program, and when prompted, enter some text. After pressing Enter, the text will be saved to
> simpleUserInput.txt in the program's running directory. The console will display a message confirming that your input
> has been saved.
</details>

# Wrap-up

***
✔️ In conclusion, Input/Output programming is an essential skill for any programmer. It involves understanding how to
interact with the user and display information effectively. By mastering the techniques and methods of input and output,
programmers can create user-friendly and efficient applications.