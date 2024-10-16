[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/5uVj_i7C)

# Assignment 6: Java Design Patterns

In this repository, you will find the exercises related to design patterns in Java.

A this point in the course, these exercises require that you study the Java programming language material by yourself. All the utilized classes have not been presented during lectures.

## Workflow (the same as usual)

1. Clone this repository to your local machine.
2. Open the project in VS Code or your preferred IDE.
3. Run the project as it is, just to make sure it works. The program should output something like `Main does nothing`.
4. Run the tests now. Since you haven't completed the exercises yet, tests will fail, and you will see errors.
5. Follow the instructions below for each exercise to complete the assignments.
6. Run the tests again to check if your solutions are correct.
7. Commit and push the repository back to GitHub Classroom when you are satisfied with your answers.

## Singleton Pattern (1p)

You are tasked with creating a logger for an application. The logger should be a singleton to ensure that all parts of the application use the same logger instance and logs will be synchronized. 

Create a class `Logger`:

- Make the constructor private to prevent instantiation from other classes.

- Create a private static variable of the same class, called `INSTANCE`.

- Provide a public and static method `getInstance()` that returns the singleton instance. The method should create a new instance only if it doesn't exist.

- Implement a method `String log(String message)` to return the log message with a prefix `Logger:`. So, it should return log messages like `Logger: Test message`.

## Builder Pattern (1p)

Next, let's practise the Builder pattern, which is somewhat familiar to us through the examples with method chaining and the class `StringBuilder`. Further example with Java and explanation of the pattern can be found [here](https://www.geeksforgeeks.org/builder-pattern-in-java/).

Write a class `Calculator`, which provides the four common arithmetic operations (addition, subtraction, multiplication and division) through the Builder pattern. Below is an example illustrating how the class should work, where the result of the "equation" should be `((5+2)*2)-2.5 = 11.5`.

```Java
Calculator cb = new Calculator(5.0); // Initial value 5.0
Double result = cb.add(2.0).multiply(2.0).subtract(2.5).getResult();
```

The class should have the following members:

- A private member `Double result`, which has the current result of the operations.

- A public constructor that takes the initial value of `result` as parameter.

- Getter for the member `result`.

- Methods `add`, `subtract`, `multiply`, `divide`, which all take one `Double value` as parameter, perform the corresponding operation with result and the value, and return the current class instance, as required by the pattern.

## Factory Method Pattern (2p)

Let's create a shape factory! This time the factory will create either circle or rectangle.

Start with interface `Shape` which has the following members:

- `Double getArea()` that returns the area of the shape.
- `Double[] getParams` with returns the constructor parameters (more about this below) as Double array.

Write class `Circle` that implements interface `Shape`, and additionally:

- Member variable `Double radius`.

- Constructor with the parameter `Double[] params`.

- The constructor must check that for circle, there is exactly one parameter in the array, i.e. the `radius` of the circle in `params[0]`. If there are more or less items in the array, it throws `IllegalArgumentException` with message `Number of parameters wrong for circle, needs radius`. Do not catch this exception in the method, since we want to test it.

Write class `Rectangle` that implements interface `Shape`, and additionally:

- Member variables of type Double `width` and `length`.

- Again constructor with the parameter `Double[] params`.

- The constructor must check that there are exactly two parameters in the Double array, i.e. the `width` and `length` of the rectangle. If there are more or less parameters than two, it throws `IllegalArgumentException` with message `Number of parameters wrong for rectangle, needs width and length`. Do not catch this exception in the method, since we want to test it.

Finally, create class `ShapeFactory` that follows the *Factory Method* pattern to create instances of shapes, i.e. circle or rectangle.

- As in the Factory Method, declare default constructor as private.

- Add static method `create(String type, Double[] params)` that creates the shapes. So it must return an instance of interface `Shape` based on the parameter `type`, which can be either `"circle"` or `"rectangle"`. The parameter `params` is passed to the constructor of the instances to be created. Thus it contains either the radius of a circle or the width and length of the rectangle.

![That's all folks!](thatsall.png)
