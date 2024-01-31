# BDD (Behavior Driven Development)
***

![different visions for an information product](resources/tree.png)

Probably everyone has seen this picture.
It clearly shows how important it is, during the development of a product, to speak one language that everyone understands.

This is how this Behavior Driven Development (BDD) emerged.

The main idea of BDD is to use “ordinary” human language that is understandable to all project participants, be it developers, testers or customers.

We create "scenarios" or "stories" about how the program should behave in different settings. This helps everyone understand what exactly we expect from the program and how it can be tested.

Let's look at an example of how we can describe the behavior of a program.

***

User navigates to www.example.com <br>
User enters a valid value in the "username" field <br>
User enters a valid value in the "password" field <br>
User clicks on the "login" button <br>
User is taken to the main page

***

The behavior is understandable, but a couple of questions arise.
1)	Who am I? <br>
      If I am a guest (not registered in the system), then I will not be able to access the site, even if I enter valid values. <br>
      OK. If I am a user, I will go to the main page of the site.<br>
      What if I am a moderator or admin?<br>
      Perhaps I will not get to the main page, but to my personal account, where I can manage the site.<br><br>

2)	We have only five steps and the example is easy.<br>
      What if there are many more steps?<br>
      Can the steps be made more clear? So that you can immediately see where the action is and where the result of this action is?<br>
      And there is an answer to all these questions - the Gerkin language in Given-When-Then format.

![Given-When-Then format](resources/given_when_then_2.webp)

Let's write our scenario using the Gerkin language.

***

**Feature:** login <br>
As a user<br>
I want to be able to log in to the application

**Scenario:** Successful login <br>
**Given** user navigates to www.example.com <br>
**When** user enters a valid value in the "username" field <br>
**And** user enters a valid value in the "password" field <br>
**And** user clicks on the "login" button <br>
**Then** user is taken to the main page <br>

***

So.. <br>
We have a ready-made scenario and to automate it we can use **Cucumber**.<br>
##Cucumber
***
Cucumber is a test automation tool based on Behavior-Driven Development (BDD) principles and associates Gherkin steps with a step definition. <br>
A step definition is a method marked with one of the step keywords: (@Given, @When, @Then, or @But). <br>
It contains either a Regular Expression or a Cucumber Expression that associates a method with Gherkin steps.<br>
Let's look at an example<br>
We wrote the steps in a file with the extension “.feature”

![feature file](resources/feature.png)

And implemented these steps in the ".java" file

![java file](resources/java.png)

####How can we improve our code? <br>
***
If you look at our steps, you will see that some steps will be repeated on other pages: “entering values into fields”, “clicking buttons” and so on. <br>
Therefore, we will move these steps into a separate file CommonSteps.java <br>
Also let's make our steps more functional.

We made one implementation for two steps and passed a String to the method.

![passing String to the method - steps](resources/commonSteps.png) <br><br>
![passing String to the method - implimentation](resources/commonStepsImpl.png)

Cucumber Expressions support basic parameter types such as:
{int}, {float}, {string}, {word}, {biginteger}, {bigdecimal}, {byte}, {short}, {long}, {double}

We can also pass a list to the method

![passing List to the method - steps](resources/listInStep.png) <br><br>
![passing List to the method - implimentation](resources/listInStepImpl.png)

Let's look at a couple more cases <br>
For example, we have two steps that differ in state. (false&true, are&are not, and so on) 

![step with multiple options](resources/stepsOr.png) <br><br>
We can also implement them in one method

![step with multiple options - implimentation](resources/stepsOrImpl.png)

We can also combine multiple descriptions for one method

![multiple descriptions](resources/2steps.png)<br><br>
![multiple descriptions - implimentation](resources/2steps_impl.png)

We can pass tables to the method

![table parameter](resources/table.png) <br><br>
![table parameter - implimentation](resources/table_impl.png)

In Cucumber, you can also pass objects to method as steps parameters.

1. Define an object:

![Define an object](resources/define_an_object.png)

2. Define the transformation:

![Define the transformation](resources/Define_the_transformation.png)

3. Use the object in a scenario step:

![Use the object in a scenario step](resources/Use_the_object_in_a_scenario_step.png)

4. Define the scenario steps:

![Define the scenario steps](resources/Define-the_scenario_steps.png)

***
***

Taking into account everything we talked about above, we did the following test.

![scenario](resources/test1.png)

The test is written. <br>
But for a specific user with a specific login and specific password.<br>
What if we want to check the second user? Is it really necessary to write another test? <br>
No. <br>
We will use ***scenario outline***. <br>
The scenario outline allows us to add examples and run the test a couple of times with different data.

![scenario outline](resources/test2.png)

