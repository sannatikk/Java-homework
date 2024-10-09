package exercises;
import java.util.Map;
import java.util.HashMap;

 public class CharacterCounter {

    public Map<Character, Integer> count(String inputString) { // map means key-value pairs, here a character and an integer
        
        // this method accepts a String as input and counts the number of occurrences of each character in the string
        // it returns a map with the character as key and the count as value
        // so if the input is "hello", the output will be {h=1, e=1, l=2, o=1}
        // you can use a HashMap to store the character counts

        // Map is an interface, HashMap is a class that implements the Map interface
        // an interface tells a class what it should do, but not how to do it
        // the class tells the interface how exactly to do it

        // so a Map is a data structure that stores key-value pairs
        // while HashMap is a specific implementation of the Map interface
        // HashMap stores unique keys and their corresponding values

        // analogy: a tv remote control is like an interface, and the tv is like a class
        // a remote control has buttons, but doesn't know how the tv works
        // the tv knows HOW to turn on, change channel, etc. when the button is pressed



        Map<Character, Integer> finalMap = new HashMap<>(); // create a new HashMap to store the character counts
        Integer charAmount = inputString.length(); // get the length of the input string

        for (int i = 0; i < charAmount; i++) { // iterate over all chracters
            char currentChar = inputString.charAt(i); // get the current character
            if (finalMap.containsKey(currentChar)) { // if the map already contains the character
                finalMap.put(currentChar, finalMap.get(currentChar) + 1); // increment the count by PUTTING into the map under the currentChar with the current (GET) count value +1
            } else {
                finalMap.put(currentChar, 1); // if the character is not in the map, add it with a count of 1
                // format is mapName.put(key, value);
            }
        }

        return finalMap;
    }

}
