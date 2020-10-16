package com.company.homework2;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Ведите ширину");
            int x = scan.nextInt();
            System.out.println("Введите высоту");
            int y = scan.nextInt();
            System.out.println("Введите текст");
            String text = scan.next();
            System.out.println("");

            //проверка на ошибки
            if(x<(text.length()+2) || y<3){
                System.out.println("Ошибка");
            }else {
                //получаем половину Y
                int halfY;
                if (x % 2 == 0) {
                    halfY = (y / 2) - 2;
                } else {
                    halfY = (y / 2) - 1;
                }

                //получаем половину размера текста
                int halfSpacesSize = (x - text.length() - 2) / 2;

                //получаем начало и конец рамки
                StringBuilder temp = new StringBuilder("***");
                for (int i = 0; i < x - 3; i++) {
                    temp.append('*');
                }
                String frameStrEnd = temp.toString();
                System.out.println(frameStrEnd);

                //получаем пропуски рамки
                temp = new StringBuilder("*");
                for (int i = 0; i < x - 2; i++) {
                    temp.append(' ');
                }
                temp.append('*');
                String frameSkip = temp.toString();

                //Рисуем рамку с текстом
                for (int i = 0; i < y - 2; i++) {
                    if (i == halfY) {//строка с текстом
                        System.out.print("*");
                        for (int j = 0; j < x - 1; j++) {
                            if (j == halfSpacesSize) {
                                System.out.print(text);
                                j += text.length();
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("*");
                    } else {//строки пробелы
                        System.out.println(frameSkip);
                    }
                }
                System.out.println(frameStrEnd);
            }
        }
}
