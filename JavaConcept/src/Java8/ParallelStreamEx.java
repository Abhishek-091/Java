package Java8;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamEx {
    public static void main(String[] args) {

        List<Integer> list1 = Stream.iterate(1, (Integer val) -> val+1).limit(100000000).toList();


        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                //filter evens using stream
                long startTime = System.currentTimeMillis();
                System.out.println(list1.stream().filter(val -> val%2==0).count());
                System.out.println("Time taken by Stream : " + (System.currentTimeMillis() - startTime));
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                //filter evens using parallel stream
                long startTimeParallel = System.currentTimeMillis();
                System.out.println(list1.parallelStream().filter(val -> val%2==0).count());
                System.out.println("Time taken by Parallel Stream : " + (System.currentTimeMillis() - startTimeParallel));
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();

        System.out.println("Thread are working...");






//        //filter evens using stream
//        long startTime = System.currentTimeMillis();
//        System.out.println(list1.stream().filter(val -> val%2==0).count());
//        System.out.println("Time taken by Stream : " + (System.currentTimeMillis() - startTime));

//        //filter evens using parallel stream
//        long startTimeParallel = System.currentTimeMillis();
//        System.out.println(list1.parallelStream().filter(val -> val%2==0).count());
//        System.out.println("Time taken by Parallel Stream : " + (System.currentTimeMillis() - startTimeParallel));
    }
}
