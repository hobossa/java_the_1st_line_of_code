package TryDataContainer;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TrySet {
    public static void main(String[] args) {
        Set<String> all = new HashSet<>();
        all.add("def");
        all.add("abc");
        all.add("ghi");
        all.add("abc");
        all.add("cde");
        System.out.println(all);    // [abc, def, cde, ghi]

        // TreeSet ordered set
        Set<String> all2 = new TreeSet<>();
        all2.add("def");
        all2.add("abc");
        all2.add("ghi");
        all2.add("abc");
        all2.add("cde");
        System.out.println(all2);   // [abc, cde, def, ghi]
    }
}
