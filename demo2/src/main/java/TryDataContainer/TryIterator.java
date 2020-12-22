package TryDataContainer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TryIterator {
    public static void main(String[] args) {
        List<String> all  = new LinkedList<>();
        all.add("Hello");
        all.add("hello");
        all.add("World");
        Iterator<String> it = all.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (String s: all) {
            System.out.println(s);
        }

        ListIterator<String> lIt = all.listIterator();
        // bidirectional iterator
        while (lIt.hasNext()) {
            System.out.println(lIt.next());
        }
        while (lIt.hasPrevious()) {
            System.out.println(lIt.previous());
        }

    }
}
