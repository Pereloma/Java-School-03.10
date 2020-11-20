package homework7.task1.com.zoo;


import homework7.task1.com.zoo.animal.*;
import homework7.task1.com.zoo.exception.AviaryException;
import homework7.task1.com.zoo.exception.NullAviaryException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Aviary aviary1 = new Aviary((int) (Math.random()*10));
        Aviary aviary2 = new Aviary((int) (Math.random()*10));
        Aviary aviary3 = new Aviary((int) (Math.random()*10));

        try {
            new Cat("V").putInAnAviary(aviary1);
            new Dog("D").putInAnAviary(aviary1);
            new Cat("C").putInAnAviary(aviary1);
            new Elephant("V").putInAnAviary(aviary2);
            aviary3 = null;
            new Lion("S").putInAnAviary(aviary3);
        } catch (NullAviaryException e) {
            e.printStackTrace();
        }
    }
}
