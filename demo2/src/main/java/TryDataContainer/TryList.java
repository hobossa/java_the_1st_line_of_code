package TryDataContainer;

import java.util.ArrayList;
import java.util.List;

public class TryList {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();   // or LinkedList
        System.out.println("The length of list is: " + all.size() + ". Is this list empty: " + all.isEmpty());
        all.add("Hello");
        all.add("Hello");
        all.add("World");
        System.out.println("The length of list is: " + all.size() + ". Is this list empty: " + all.isEmpty());
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
        for (String str : all) {
            System.out.println(str);
        }
        Object obj[] = all.toArray();
        for (int i = 0; i < obj.length; i++) {
            System.out.println((String) obj[i]);
        }
        all.remove("Hello");
        for (String s : all) {
            System.out.println(s);
        }
    }
}
