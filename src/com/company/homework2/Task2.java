package com.company.homework2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        System.out.println("Введите искомый индекс k");
        Scanner in = new Scanner(System.in);
        int length = 1;
        long sumOfPreviousNumbers = 0;
        long k = in.nextLong()+1;
        long tempFirst = 9;
        long tempTwo = 1;

        if (k < 10) {
            System.out.println(k);
        }else if (k < 10) {
            System.out.println(1);
        } else {
            //получаем длинну и сумму преведущих чисел(в k)
            while (true) {
                if (k <= tempFirst) {
                    break;
                } else {
                    sumOfPreviousNumbers = tempFirst;
                    length++;
                    tempTwo *= 10;
                    tempFirst = tempFirst + (tempTwo * 9 * length);
                }
            }

            //получаем сумму преведущих чисел(в строке)
            tempFirst = 9;
            for (int i = 0; i < length - 2; i++) {
                tempFirst = (tempFirst * 10) + 9;
            }

            //нахождение конечного результата
            sumOfPreviousNumbers = (k - sumOfPreviousNumbers);
            if (sumOfPreviousNumbers % length == 0) {
                tempTwo = (sumOfPreviousNumbers / length) + tempFirst;
                System.out.println(tempTwo % 10);
            } else {
                tempTwo = length - (sumOfPreviousNumbers - (sumOfPreviousNumbers / length * length));
                tempFirst = (sumOfPreviousNumbers / length) + tempFirst;
                for (int i = 0; i < tempTwo; i++) {
                    tempFirst /= 10;
                }
                System.out.println(tempFirst % 10);
            }
        }
    }
}
