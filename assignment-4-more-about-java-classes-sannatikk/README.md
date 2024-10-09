[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/x7rnFY1I)
# Assignment 4: More about Java classes

In this repository, you will find a series of exercises about Java Classes concepts introduced during the lecture, i.e. abstract and interface classes.

## Workflow (the same as usual)

1. Clone this repository to your local machine.

2. Open the project in VS Code.

3. Run the project as it is, just to make sure it works. The program should output something like `Main does nothing`.

4. You can also run the tests now. Obviously, if you haven't finished exercises, tests will fail now and you will see a lot of errors.

5. Follow the instructions below for each exercise to complete the exercise.

6. You can any time run the tests to see if your answer code is correct.

7. Finally when you are satisfied with your answers, commit and push the repository back to the classroom.

## Shape drawing as abstract art (1p)

Implement a class hierarchy for different shapes. Each shape should calculate its area differently. This exercise is basically a reimplementation of the previous exercises using interfaces.

Create an abstract class `Shape`:

- Add a protected attribute `String name`.

- Implement a constructor `Shape(String name)` to initialize the name attribute.

- Implement the abstract method `public abstract  Double calculateArea()`.

- Implement the method `public String getName()` that returns the name of the shape.

Create a class `Circle` that extends abstract class `Shape`:

- Add a private attribute `Double radius`.

- Implement the constructor `Circle(String name,  Double radius)` to initialize the name and radius attributes.

- Override the `calculateArea()` method to return the area of the circle (using `Math.PI * radius * radius`).

Create a class `Rectangle` that extends `Shape`:

- Add private attributes `Double length` and `Double width`.

- Implement the constructor `Rectangle(String name,  Double length,  Double width)` to initialize the name, length, and width attributes.

- Override the `calculateArea()` method to return the area of the rectangle (using `length * width`).

## Media Player (1p)

First, create the interface `Playable` with the following:

- Method `String play()`.

- Method `String pause(Integer seconds)`.

- Method `String stop()`.

- Then create class `VideoFile` that implements the above interface.

- The classes should have public static attribute `fileName`, which is the name of file to be played.

Assuming the filename is `Sash! - La Primavera.mp4`, the implemented methods should return the following:

- Play: `Playing videofile Sash! - La Primavera.mp4`.

- Pause: `Videofile Sash! - La Primavera.mp4 paused for 10 seconds`, when `pause` method has parameter value `10`.

- Stop: `Videofile Sash! - La Primavera.mp4 stopped`

This exercise is quite simple for now but we'll extend this code later..

## Notification System (2p)

Implement a notification system, where different types of notifications (email, SMS) are sent using abstract classes and interfaces.

Create an abstract class `Notification`:

- Add a protected attributes `String recipient` and `String message`.

- Implement a constructor `Notification(String recipient, String message)` to set the attribute values.

- Has abstract method `public abstract String formatMessage()`.

Create an interface `Sendable`:

- Declare the method `String send()`.

Create a class `EmailNotification` that extends `Notification` and implements `Sendable`:

- Implement constructor `EmailNotification(String recipient, String message)` that calls superclass constructor.

- Override the `formatMessage()` method to format the message for email. Example output is `john.doe@example.com: Welcome to the system!`, where you have both the email address (as recipient) and message.

- Implement the `send()` method to simulate sending the email, which returns `Sent email to john.doe@example.com: Welcome to the system!`

Create a class `SMSNotification` that extends `Notification` and implements `Sendable`:

- Implement constructor `SMSNotification(String recipient, String message)` that calls superclass constructor. Recipient should be phone number in the form `0123456789`.

- Override the `formatMessage()` method to format the message for email. Example output is `+358-123456789: Good morning`, where you have both the phone number (as recipient) and message. Note that you must remove the first zero from the phone number, before adding the country code of Finland (+358) to the output.

- Implement the `send()` method to simulate sending the email, which returns `Sent SMS +358-123456789: Good morning`.

## Shopping List (3p)

First, create a class `Product` that has the following:

- private attributes `Double price`, `Integer quantity`, `String name`.

- Constructor to set the values (in the above order).

- Getter for the attribute `name`.

- Method `public Double getTotal()` which calculates the total price of the given quantity of items.

Next, write an interface `Searchable` that has the following methods:

- `LinkedList<Product> searchByName(String name)`, which returns a list of all the products in the shopping list with the given name. Note that you need to search for all the names that contain at least partially the given name. For example, if the parameter is `fish`, you need to return both the products `Catfish` and `Goldfish`.

- `LinkedList<Product> searchSmaller(Double value)`, which returns a list of all the products in the shopping list, which price is less than the given value.

- `LinkedList<Product> searchGreaterOrEqual(String name)`, which returns a list of all the products in the shopping list, which price is equal or greater than the given value.

- `Double getTotalByName(String name)`, which calculates the total price of products in a shopping list with the given name.

Finally, create the class `ShoppingList` that implements the interface `Searchable`, and additionally has the following:

- a private linked list containing elements of object type `Product`.

- public method `addItem(String name, Double price, Integer quantity)`. Note that each item is considered separate entry, so do not add up new items to the existing items. It is possible that for example the price is different when shopping is continued at later time.
