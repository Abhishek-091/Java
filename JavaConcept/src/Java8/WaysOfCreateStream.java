package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WaysOfCreateStream {
    public static void main(String[] args) {

        //From Collection
        List<Integer> list = List.of(1,2,3,4,5);

        Stream<Integer> stream = list.stream();


        //From Array
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream1  = Arrays.stream(arr);

        //Stream Builder
        Stream.Builder<Integer> stream2 = Stream.builder();
        stream2.add(1);
        stream2.add(2);
        stream2.add(3);

        //Using static method
        Stream<Integer> stream3 = Stream.of(1,2,3,4,5);

        //From Stream Iterate
        Stream<Integer> stream4 = Stream.iterate(1, (Integer val) -> val+1).limit(10);

        stream4.forEach(System.out::println);

    }
}
