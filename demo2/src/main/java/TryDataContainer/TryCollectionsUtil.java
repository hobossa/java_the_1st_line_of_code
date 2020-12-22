package TryDataContainer;

import java.util.*;

public class TryCollectionsUtil {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        Collections.addAll(all, "dasf", "fadfqv", "qeyvbc","aqbco");
        System.out.println(all);
        Collections.sort(all);
        System.out.println(all);
        System.out.println(Collections.binarySearch(all, "fadfqv"));
        Collections.reverse(all);
        System.out.println(all);
        List<String> copy = new LinkedList<>(Arrays.asList(new String[all.size()]));
        Collections.copy(copy, all);    // dest should has enough capacity ro receive src.
        System.out.println(copy);
        // binarySearch , copy ..
    }
}
