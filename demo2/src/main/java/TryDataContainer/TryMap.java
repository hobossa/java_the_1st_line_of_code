package TryDataContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TryMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put(null, 0);
        System.out.println(map);
        System.out.println(map.get("two"));

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> m = iter.next();
            System.out.println(m.getKey() + " - " + m.getValue());
        }

        for (Map.Entry<String, Integer> item :
                map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
