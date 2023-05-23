package streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

//      stream() with existing collections
        List<String> myList = Arrays.asList("amanda", "alex", "sandy", "alina", "sky");

        myList
                .stream()                             // get the stream from the list
                .map(String::toUpperCase)             // apply intermediate map operation passing in the String toUpperCase reference
                .forEach(result -> System.out.println("stream() with existing collections: " + result));          // use forEach to run the lambda expressing printing the contents

//        Stream.of() without a list
        Stream.of("amanda", "alex", "sandy", "alina", "sky")
                .map(String::toUpperCase)
                .forEach(result -> System.out.println("Stream.of() without a list: " + result));

        //    findFirst()
        Stream.of("amanda", "alex", "sandy", "alina", "sky")
                .findFirst()
                .ifPresent(name -> System.out.println("findFirst(): " + name.toUpperCase()));

//        IntStream.range()
        IntStream.range(1, 5)
                .mapToObj(num -> "IntStream.range()" + "number: " + num)
                .forEach(System.out::println);

//        Stream.of() substring
        Stream.of("E38", "E39", "E40", "E41")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(s -> System.out.println("Stream.of() substring: " + s));

        //        Double to Int
        Stream.of(38.0, 39.0, 40.0, 41.0)
                .mapToInt(Double::intValue)
                .mapToObj(cohort -> "Double to Int: " + "E" + cohort)
                .forEach(System.out::println);

//        `collect()` terminal operation
        List<String> output = Stream.of("amanda", "alex", "sandy", "alina", "sky")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("`collect()` terminal operation: " + output);

//        Stream operations:

//        reduce
        int total = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .reduce(0,(sum, num)-> sum += num);
        System.out.println("Reduce: " + total);

//        map
       Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map((num)-> num *2)
                .forEach((result) -> System.out.println("Map: " + result));


//      filter
        Stream.of(1,2,3,4,5,6,7)
                .filter((num) -> num %2 == 0)
                .forEach((filter) ->System.out.println("Filter: " + filter));

//      sorted
        Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
                .sorted()
                .forEach((sorted) -> System.out.println("Sorted: " + sorted));

        Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
                .sorted()
                .limit(4)
                .forEach((limit) -> System.out.println("Limit: " + limit));

        OptionalDouble average = Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
                .mapToInt((n) -> n)
                .average();
        System.out.println("Average: " + average);

        int resultMax = Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
                .mapToInt((n) -> n)
                .max()
                .getAsInt();
        System.out.println("Max: " + resultMax);

        int resultMin = Stream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
                .mapToInt((n) -> n)
                .min()
                .getAsInt();
        System.out.println("Min: " + resultMin);

//        peek()
        int peakOut = IntStream.of(99, 3, 61, 20, 83, 12, 2, 18, 10)
                .peek(n -> System.out.printf("original: %d%n", n))
                .map(n -> n * 2)
                .peek(n -> System.out.printf("doubled : %d%n", n))
                .filter(n -> n % 3 == 0)
                .peek(n -> System.out.printf("filtered: %d%n", n))
                .sum();
        System.out.println("Peak: " + peakOut);

        /*
        * Optional: Specialist Streams
        * Besides regular object streams ships with special kinds of streams for working with the
        * primitive data types int, long and double. As you might have guessed it's
        * IntStream, LongStream and DoubleStream.
        */

        IntStream.range(1, 5)
                .mapToObj(num -> "number: " + num)
                .forEach((range) -> System.out.println("IntStream.range: " + range));

    }

}
