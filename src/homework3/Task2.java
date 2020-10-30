package homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    /*
    2. Написать функцию, которая убирает одинаковые значения из списка.
    1 1 1 1 2 2 3 4 5
    Результат программы: 1 2 3 4 5
    */
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, new Integer[]{1, 1, 1, 1, 2, 2, 3, 4, 5});

        for (int i = 0; i < integerList.size(); i++) {
            for (int j = i+1; j < integerList.size(); j++) {
                if(integerList.get(i) == integerList.get(j)){
                    integerList.remove(j);
                    j--;
                }
            }
        }
        System.out.println(integerList);
    }
}
