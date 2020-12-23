package TryDataContainer;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TryStream {
    public static void main(String[] args) {
        List<String> all = new LinkedList<>();
        all.add("a");
        all.add("bb");
        all.add("ccc");
        all.add("a");
        // forEach
        all.forEach(System.out::println);
        // lambda
        all.forEach((s) -> {
            System.out.println(s.toUpperCase());
        });
        // Stream
        System.out.println("stream1");
        Stream<String> stream1 = all.stream();
        System.out.println(stream1.count());
        // each stream can only be used a once.
        // so we need another stream to distinct
        System.out.println("stream2");
        Stream<String> stream2 = all.stream();
        List<String> newAll2 = stream2.distinct().collect(Collectors.toList());
        newAll2.forEach(System.out::println);
        // filter
        System.out.println("stream3");
        Stream<String> stream3 = all.stream();
        List<String> newAll3 = stream3.filter((s) -> {
            return s.length() > 1;
        }).collect(Collectors.toList());
        newAll3.forEach(System.out::println);
        // map
        System.out.println("stream4");
        Stream<String> stream4 = all.stream();
        List<String> newAll4 = stream4.map((s) -> {
            return s.toUpperCase();
        }).collect(Collectors.toList());
        newAll4.forEach(System.out::println);
        // distinct map filter
        System.out.println("stream5");
        Stream<String> stream5 = all.stream();
        List<String> newAll5 = stream5.distinct().map((s -> {
            return s.toUpperCase();
        })).filter((s -> {
            return s.length() > 1;
        })).collect(Collectors.toList());
        newAll5.forEach(System.out::println);

    }
}
