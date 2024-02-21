# How to Debug
***

## Contents
<!-- TOC -->
* [How to Debug](#how-to-debug)
  * [Contents](#contents)
  * [Overview](#overview)
  * [Examine the code](#examine-the-code)
  * [Set breakpoints](#set-breakpoints)
  * [Run the program in debug mode](#run-the-program-in-debug-mode)
  * [Analyze the program state](#analyze-the-program-state)
  * [Step through the program](#step-through-the-program)
  * [Stop the debugger session and rerun the program](#stop-the-debugger-session-and-rerun-the-program)
  * [Action shortcuts](#action-shortcuts)
  * [Resources](#resources)
<!-- TOC -->

## Overview
***

Debugger makes application debugging much easier. Using debugger, we can **stop** the execution of program at a certain point, **inspect variables**, **evaluate** and some other things. IntelliJ provides inbuilt Java debugger.
The debugger is a powerful tool, which lets you find bugs a lot faster by providing an insight into the internal operations of a program. This is possible by pausing the execution and analyzing the state of the program by thorough examination of variables and how they are changed line by line.

There are different kinds of errors, which you are going to deal with. Some of them are easy to catch, like syntax errors, because they are taken care of by the compiler. Another easy case is when the error can be quickly identified by looking at the stack trace, which helps you figure out where the error occurred.

However, there are errors that can be very tricky and take really long to find and fix.
This is where the debugger is useful. While debugging, you are in full control of the things. In this manual we are covering a basic debugging scenario to get you started.

## Examine the code
***

Let's try a simple debugging case. Imagine we have the following application:

```java
public class AverageFinder {
    public static void main(String[] args) {
        System.out.println("Average finder v0.1");
        double avg = findAverage(args);
        System.out.println("The average is " + avg);
    }

    private static double findAverage(String[] input) {
        double result = 0;
        for (String s : input) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
```

The program is supposed to calculate the average of all values passed as command-line arguments.

It compiles and runs without issues; however, the result is not what one would expect. For instance, when we pass 1 2 3 as the input, the result is 6.0.

First of all, you need to think about where the suspected error might be coming from. We can assume the problem is not in the print statements. Most likely, unexpected results are coming from our findAverage method. In order to find the cause, let's examine its behavior in the runtime.

## Set breakpoints
***

To examine how the program operates at runtime, we need to suspend its execution before the suspected piece of code. This is done by setting breakpoints. Breakpoints indicate the lines of code where the program will be suspended for you to examine its state.

Breakpoint allows stopping program execution at certain point. Breakpoints can be set by hovering the mouse over the Editor’s gutter area and clicking on it.

Click the gutter at the line where the **findAverage** method is called.
![breakpoint.png](images%2Fbreakpoint.png)

## Run the program in debug mode
***

Now let's start the program in debug mode.
When the test is running in debug and has stopped at a breakpoint, I can:

- see all the current variables,
- expand them when they are an object instance of some sort
- resume execution (stop at next breakpoint)
- step over the line to advance execution bit by bit
- step into the code to advance execution, but into the method implementation
- highlight code and “Evaluate Expression”

Since we are going to pass arguments for running and debugging the program, make sure the [Run/Debug configurations](..%2Frun_debug_configurations%2FRun_Debug_configurations.md) has these arguments in place.

1. Click the Run icon in the gutter, then select Modify Run Configuration.
![run_config.png](images%2Frun_config.png)
2. Enter arguments in the Program arguments field.
![setup_arguments.png](images%2Fsetup_arguments.png)
3. Click the Run button near the main method. From the menu, select Debug.
![debug_mod.png](images%2Fdebug_mod.png)
## Analyze the program state
***

After the debugger session has started, the program runs normally until a breakpoint is hit. When this happens, the line where the program paused gets highlighted and the Debug tool window appears.
![debug_window.png](images%2Fdebug_window.png)

The highlighted line **has not been executed yet**. The program now waits for further instructions from you. The suspended state lets you examine variables, which hold the state of the program.

As the findAverage method has not been called yet, all its local variables like result are not yet in scope, however, we can examine the contents of the args array (args is in scope for the main method). The contents of args are displayed inline where args is used:
![debug_tutorial_analyzing.png](images%2Fdebug_tutorial_analyzing.png)

You can also get information about all variables that are currently in scope in the Variables panel.
![debug_config_arguments.png](images%2Fdebug_config_arguments.png)

## Step through the program
***

Now that we are comfortable with the Debug tool window, it's time to step into the **findAverage** method and find out what is happening inside it.

1. To step into a method, click the Step Into button or press **F7**.
![debug_tutorial_step_into.png](images%2Fdebug_tutorial_step_into.png)
Another line gets highlighted in the editor because we advanced the execution point one step forward.
2. Continue stepping with Step Over **F8**.
Notice how it is different from Step Into. While it also advances the execution one step forward, it doesn't visit other methods like Integer.parseInt() along the way.
Let's keep stepping and see how the local variable result is declared and how it is changed with each iteration of the loop.
![debug_tutorial_step_over.png](images%2Fdebug_tutorial_step_over.png)
   Right now the variable s contains the value "3". It is going to be converted to int and be added to result, which currently has the value of 3.0. No errors so far. The sum is calculated correctly.
3. Two more steps take us to the return statement, and we see where the omission was. We are returning result, which has the value of 6.0, without dividing it by the number of inputs. This was the cause of incorrect program output.
![debug_tutorial_result.png](images%2Fdebug_tutorial_result.png)

5. Let's correct the error:
```java
return result / input.length;
```

## Stop the debugger session and rerun the program
***

You can resume program execution by clicking on Resume Program or by using the shortcut F9. To restart the program in debug mode, select Rerun. You can stop debugging your program at any time by using the Stop icon.

1. In order to check that the program works fine, let's stop the debugger session and rerun the program.
![stopping_debugger.png](images%2Fstopping_debugger.png)
2. Click the Run button near the main method. From the menu, select Run.
![debug_tutorial_run_2.png](images%2Fdebug_tutorial_run_2.png)
3. Verify that the program works correctly now.

![debug_tutorial_verify.png](images%2Fdebug_tutorial_verify.png)

## Resources
***

- [Tutorial: Debug your first Java application](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html)
- [Intellij Idea - Debugging](https://www.tutorialspoint.com/intellij_idea/intellij_idea_debugging.htm)
- [Debugger Basics in IntelliJ IDEA](https://blog.jetbrains.com/idea/2020/05/debugger-basics-in-intellij-idea/)
- [How to debug Java with IntelliJ: breakpoints, evaluate expression, watches and variable view](https://www.eviltester.com/2016/07/how-to-debug-java-with-intellij.html)