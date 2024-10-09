[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/L3u70buO)
# Assignment 3 - Java Collections

In this repository, you will find a series of exercises about Java Collections.

You may find the exercises quite challenging, that is why each award more points. 

## Workflow (the same as usual)

1. Clone this repository to your local machine.

2. Open the project in VS Code.

3. Run the project as it is, just to make sure it works. The program should output something like `Main does nothing`.

4. You can also run the tests now. Obviously, if you haven't finished exercises, tests will fail now and you will see a lot of errors.

5. Follow the instructions below for each exercise to complete the exercise.

6. You can any time run the tests to see if your answer code is correct.

7. Finally when you are satisfied with your answers, commit and push the repository back to the classroom.

## Set Operations (1p)

Lets focus on the three set operations union, intersection and difference, to the two given member sets in the class.

Now a class `SetOperations` has:

- Add private members `HashSet<Integer> set1` and `HashSet<Integer> set2`.

- Implement the constructor `SetOperations(HashSet<Integer> s1, HashSet<Integer> s2)`, which will initialize the two member sets `set1` and `set2`.

- Implement the method `public HashSet<Integer> union()`, which returns the union of the member sets.

- Implement the method `public HashSet<Integer> intersection()`, which returns the union of the member sets.

- Implement the method `public HashSet<Integer> difference()`, which returns the difference of the member sets.

Hints:

- Use the class `HashSet` instead the interface `Set`.

- If you are not familiar with Set Theory, you should study the basic set operations briefly in the Internet.

## Character Counter (2p)

The class `CharacterCounter` counts the number of occurrences of a character in a string.

The class has only the following method `public Map<Character, Integer> count(String inputString)`.

The method accepts a String as input and counts the number of occurrences of each character in the string. The method returns a `Map` where the key is the character and the value is the count of that character in the string.

So, if the input string is `hello` the method will return a Map containing `{e:1, h:1, l:2, o:1 }`.

If the input string is empty, the method should return an empty HashMap.

Hints:

- Use a `HashMap` to store the characters and their counts.

- You may need to convert the input string to an array of characters.

- Review the Java documentation for HashMap and String classes; you may find useful methods to simplify the implementation.

## Data Operations (2p)

Emphasize the use of `List` and `Map` interface implementations focusing on sorting and grouping data.

The class `DataOrganizer` only has the method `HashMap<String, ArrayList<Integer>> groupAndSort(ArrayList<Integer> numbers)`. Note that in the method returns a map with String as the key and ArrayList as the value.

The method groups numbers in the parameter array into two lists within the map:

- Key `Even` returns list of even numbers, sorted in ascending order.

- Key `Odd` returns list of odd numbers, sorted in descending order.

## Fibonacci (3p)

Let's continue our exploration with the Fibonacci sequence.

The class `Fibonacci` has:

- private member `Vector<Integer>`, a collection storing the sequence.

- Constructor with Integer parameter. It will initialize the Fibonacci sequence into the private Vector collection. If this parameter is 8, you will need to calculate and store the first 8 Fibonacci numbers into the collection. It is tested that the collection actually has this sequence.

- Getter for the private collection, i.e. method `getNumbers()`.

- Method `addNext()` which will calculate and add the next Fibonacci number into the collection and return it. 

- Method `isFibonacci(Integer num)` which will check if the given number is a Fibonacci number. Additionally, this method will add the missing Fibonacci sequence until the `num` into the collection. 

- Method `compareSequence(Vector<Integer> seq)` that will check (true / false) if the given sequence is a Fibonacci sequence. Again, similarly this method will add the missing sequence between to the collection. Last number in the updated sequence is the largest Fibonacci number equal or smaller than the largest number in `seq`. 

Hints:

- If the collection sequence is `{0, 1, 1, 2, 3 }` and when next is added, it will become `{0, 1, 1, 2, 3, 5 }`.

- If the sequence is `{0, 1, 1, 2, 3, 5}` and parameter to be checked  for Fibonacci number is 22, the sequence will be updated to `{0, 1, 1, 2, 3, 5, 8, 13, 21}`.

- If the current sequence is `{0, 1, 1, 2, 3, 5, 8, 13}` and the sequence to be checked is `{5, 8, 13, 21, 34, 55, 999}`, the collection will be updated to `987` as the last number.
