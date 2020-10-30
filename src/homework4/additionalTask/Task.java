package homework4.additionalTask;

import java.util.Scanner;

public class Task {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ведите число");
        int xFib = scan.nextInt();
        int re = 0;
        scan.close();

        while (xFib > 0){
            xFib -= getFib(xFib);
            re ++;
        }
        System.out.println(re);
    }

    public static int getFib(int max){
        int fibOne = 1;
        int fibTwo = 2;

        while (fibOne <= max && fibTwo <= max){
            if (fibOne<fibTwo){
                fibOne = fibOne + fibTwo;
            }
            else {
                fibTwo = fibTwo + fibOne;
            }
        }
        if(fibOne<fibTwo){
            return fibOne;
        }
        else {
            return fibTwo;
        }
    }

}
