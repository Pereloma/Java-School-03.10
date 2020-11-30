package homework9.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add((int)(Math.random()*99d)+1);
        }

        for (Integer integer : integerList){
            System.out.println(integer);
        }
        System.out.println();

        System.out.println(countTheNumberOfItems(integerList, o -> o > 50));
    }
    public static <E> int countTheNumberOfItems(Collection<E> collection, Predicate<E> predicate){
        int res = 0;

        for (E number:collection){
            if(predicate.test(number))
                res++;
        }

        return res;
    }
}
