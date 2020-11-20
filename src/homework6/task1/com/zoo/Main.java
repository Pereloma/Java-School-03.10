package homework6.task1.com.zoo;


import homework6.task1.com.zoo.animal.*;
import homework6.task1.com.zoo.exception.AviaryException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Aviary aviary = new Aviary(3);

        try {
            aviary.add(new Cat("Vasily"));
            aviary.add(new Dog("Sparky"));
            aviary.add(new Dog("Toby"));
        } catch (AviaryException e) {
            e.printStackTrace();
        }

        try {
            aviary.add(new Cow("Murk"));
            aviary.add(new Elephant("Gyozo"));
        } catch (AviaryException e) {
            e.printStackTrace();
        }
    }
}
