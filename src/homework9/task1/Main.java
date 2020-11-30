package homework9.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator;
//        integerComparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(getPrimeDivisors(o1)>getPrimeDivisors(o2))
//                    return -1;
//                else return 1;
//            }
//        };

        integerComparator = Comparator.comparing(obj -> getPrimeDivisors(obj));

        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            integers.add((int)(Math.random()*99d)+1);
        }

        for (Integer integer : integers){
            System.out.println(integer);
        }
        System.out.println();
        integers.sort(integerComparator);

        for (Integer integer : integers){
            System.out.println(integer);
        }
    }
    private static int getPrimeDivisors(int value){
        Set<Integer> divisors = new HashSet<>();
        divisors.add(value);

        for (int i = value-1; i > 0; i--) {
            if(value%i == 0)
                divisors.add(i);
        }

        return divisors.size();
    }
}