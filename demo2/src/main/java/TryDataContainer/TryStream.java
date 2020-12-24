package TryDataContainer;

import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Orders {
    private final String name;    // product name
    private final double price;
    private final int amount;

    public Orders(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}

public class TryStream {
    public static void main(String[] args) {
        List<String> all = new LinkedList<>();
        all.add("a");
        all.add("bb");
        all.add("ccc");
        all.add("a");

        // forEach
        System.out.println("\nforEach");
        all.forEach(System.out::println);

        // lambda
        System.out.println("\nforEach lambda");
        all.forEach((s) -> {
            System.out.println(s.toUpperCase());
        });

        // Stream
        System.out.println("\nstream1");
        Stream<String> stream1 = all.stream();
        System.out.println(stream1.count());

        // each stream can only be used a once.
        // so we need another stream to distinct
        // stream distinct
        System.out.println("\nstream2");
        Stream<String> stream2 = all.stream();
        List<String> newAll2 = stream2.distinct().collect(Collectors.toList());
        newAll2.forEach(System.out::println);

        // stream filter
        System.out.println("\nstream3");
        Stream<String> stream3 = all.stream();
        List<String> newAll3 = stream3.filter((s) -> {
            return s.length() > 1;
        }).collect(Collectors.toList());
        newAll3.forEach(System.out::println);

        // stream map
        System.out.println("\nstream4");
        Stream<String> stream4 = all.stream();
        List<String> newAll4 = stream4.map((s) -> {
            return s.toUpperCase();
        }).collect(Collectors.toList());
        newAll4.forEach(System.out::println);

        // distinct + map + filter
        System.out.println("\nstream5");
        Stream<String> stream5 = all.stream();
        List<String> newAll5 = stream5.distinct().map((s -> {
            return s.toUpperCase();
        })).filter((s -> {
            return s.length() > 1;
        })).collect(Collectors.toList());
        newAll5.forEach(System.out::println);

        // skip
        System.out.println("\nstream6");
        Stream<String> stream6 = all.stream();
        List<String> newAll6 = stream6.skip(1).collect(Collectors.toList());
        newAll6.forEach(System.out::println);

        // limit
        System.out.println("\nstream7");
        Stream<String> stream7 = all.stream();
        List<String> newAll7 = stream7.limit(2).collect(Collectors.toList());
        newAll7.forEach(System.out::println);

        // anyMatch
        System.out.println("\nstream8");
        Stream<String> stream8 = all.stream();
        if (stream8.anyMatch((s) -> {
            return s.equals("bb");
        })) {
            System.out.println("bb in the list");
        }
        ;

        // anyMatch multiple conditions
        System.out.println("\nstream9");
        Predicate<String> p1 = (s) -> {
            return s.length() > 2;
        };
        Predicate<String> p2 = (s) -> {
            return s.equals("a");
        };
        Stream<String> stream9 = all.stream();
        if (stream9.anyMatch(p1.or(p2))) {
            System.out.println("p1 or p2");
        } else {
            System.out.println("doesn't match any cases.");
        }

        // MapReduce
        List<Orders> orders = new LinkedList<>();
        orders.add(new Orders("apple", 3.5, 200));
        orders.add(new Orders("pear", 4.0, 500));
        orders.add(new Orders("orange", 2.0, 300));
        orders.add(new Orders("banana", 8.0, 900));
        System.out.println("\nmap");
        orders.stream().map((x) -> {
            return x.getAmount() * x.getPrice();
        }).forEach(System.out::println);

        System.out.println("\nreduce");
        double totalPrice = orders.stream().map((x) -> {
            return x.getAmount() * x.getPrice();
        }).reduce((sum, m) -> {
            return sum + m;
        }).get();
        System.out.println("total prices is :" + totalPrice);

        System.out.println("\nDoubleSummaryStatistics mapToDouble");
        DoubleSummaryStatistics dss = orders.stream().mapToDouble((x) -> {
            return x.getPrice() * x.getAmount();
        }).summaryStatistics();
        System.out.println("count: " + dss.getCount()
                + "\nsum: " + dss.getSum()
                + "\nmax: " + dss.getMax()
                + "\nmin: " + dss.getMin()
                + "\navg: " + dss.getAverage());
    }
}
