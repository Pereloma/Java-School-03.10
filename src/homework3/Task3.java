package homework3;

public class Task3 {
/*
    (на массивы) Написать функцию, которая переворачивает массив, размерностью 8.
    Например,
        8 7 6 5 4 3 2 1
    Результат программы:
        1 2 3 4 5 6 7 8
*/
public static void main(String[] args) {
    int[] ints = new int[]{8,7,6,5,4,3,2,1};
    int temp;

    for (int i = 0; i < ints.length/2; i++) {
        temp = ints[i];
        ints[i] = ints[ints.length-i-1];
        ints[ints.length-i-1] = temp;
    }

    for (int i: ints) {
        System.out.print(i + " ");
    }
    System.out.println();
}
}
