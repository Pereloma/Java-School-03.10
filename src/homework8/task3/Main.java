package homework8.task3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(3,4);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.put(i,j,(i*10)+j);
            }
        }

        for (Integer integer : matrix){

            System.out.println(integer);
        }
    }


}
