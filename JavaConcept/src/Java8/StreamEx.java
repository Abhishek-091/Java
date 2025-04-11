package Java8;

import java.util.List;
import java.util.function.Predicate;

public class StreamEx {
    public static void main(String[] args) {


        List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9,10);


        //Filter Based On Some Predicate
        //Create Predicate
        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2 == 0;
            }
        };

        //Filter Even Numbers
        List<Integer> evenList = list1.stream()
//                .filter((num) -> num%2 == 0)
                .filter(evenPredicate)
                .toList();


        //Filter Even and double the numbers
        List<Integer> doubleEvenList = list1.stream()
                .filter((num) -> num%2 == 0)
                .map(num -> num*2).toList();


        //Sum of all even numbers
        int sum = list1.stream()
                .filter(num -> num%2==0)
                .mapToInt(Integer::intValue)
                .sum();

        //Print all even elements
//        list1.stream()
//                .filter(num -> num%2==0)
//                        .forEach(System.out::println);

        //Match any ODD number is present : allMatch(Predicate), noneMatch(Predicate)
        Boolean isOddPresent = list1.stream()
                        .anyMatch(num -> num%2!=0);


        List<List<Integer>> nestedList = List.of(List.of(1,2,3,4,5), List.of(6,7,8,9,10));

        nestedList.stream()
                        .flatMap(List::stream)
                                .forEach(System.out::println);


//        System.out.println(isOddPresent);



    }
}
