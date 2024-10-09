package exercises;
import java.util.HashSet;

public class SetOperations {

    private HashSet<Integer> set1;
    private HashSet<Integer> set2;

    public SetOperations(HashSet<Integer> s1, HashSet<Integer> s2) {
        this.set1 = s1;
        this.set2 = s2;
    }

    public HashSet<Integer> union() {   // union = all elements in set1 and set2, no duplicates
        HashSet<Integer> union = new HashSet<>(set1);   // you can omit the type on the right-hand side if it's inferrable from the left-hand side
        union.addAll(set2);
        return union;
    }

    public HashSet<Integer> intersection(){ // intersection = all elements that exist in both set1 and set2, no duplicates
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public HashSet<Integer> difference(){ // difference = all elements that exist in set1 but not in set2, no duplicates
        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2); 
        return difference;
    }


}
