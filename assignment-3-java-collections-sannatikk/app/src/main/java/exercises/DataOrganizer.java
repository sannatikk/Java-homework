package exercises;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class DataOrganizer {

    public HashMap<String, ArrayList<Integer>> groupAndSort(ArrayList<Integer> numbers) {

        // this method groups numbers in the parameter array into two lists within the map:
        // Key "Even" returns a list of even numbers, sorted in ascending order
        // Key "Odd" returns a list of odd numbers, sorted in descending order

        // create a new HashMap to store the lists
        HashMap<String, ArrayList<Integer>> finalMap = new HashMap<>(); 

        // create two new ArrayLists to store the even and odd numbers
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();

        // iterate over all numbers
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i); // get the current number
            if (currentNumber % 2 == 0) {       // if the number is even
                evenList.add(currentNumber);    // add it to the even list
            } else {                            // if the number is odd
                oddList.add(currentNumber);     // add it to the odd list
            }
        }

        // sort the even list in ascending order
        evenList.sort(null);

        // sort the odd list in descending order
        oddList.sort(null);
        oddList.sort(Collections.reverseOrder());

        // put the even list into the map under the key "Even"
        finalMap.put("Even", evenList);

        // put the odd list into the map under the key "Odd"
        finalMap.put("Odd", oddList);

        return finalMap;

    }
    
}
