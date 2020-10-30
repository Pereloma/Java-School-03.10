package homework6.task1.com.zoo;


import homework5.task1.com.zoo.exception.BitingException;
import homework6.task1.com.zoo.animal.Cat;
import homework6.task1.com.zoo.animal.Dog;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cat catVasiliy = new Cat("Vasiliy");
        catVasiliy.run(4);

        Dog dogButton = new Dog("Button");
        try {
            dogButton.bite(catVasiliy);
        } catch (BitingException e) {
            System.out.println("Failed to bite");
            e.printStackTrace();
        }
    }
}
