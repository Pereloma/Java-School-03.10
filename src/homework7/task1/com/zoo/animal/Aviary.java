package homework7.task1.com.zoo.animal;

import homework7.task1.com.zoo.exception.AviaryIdenticalAnimalsException;
import homework7.task1.com.zoo.exception.AviaryIsFullException;

public class Aviary {
    Animal[] animalsAviary;
    int size = 0;

    public Aviary(int size) {
        this.animalsAviary = new Animal[size];
    }

    public void add(Animal animal) throws AviaryIsFullException, AviaryIdenticalAnimalsException {
        if (animalsAviary.length <= size) {
            throw new AviaryIsFullException("the aviary is full");
        }
        for (Animal aviaryAnimal : animalsAviary) {
            if(aviaryAnimal != null){
                if(aviaryAnimal.getClass().equals(animal.getClass()))
                    throw new AviaryIdenticalAnimalsException("The same animals in the aviary");
            }
        }

        for (int i = 0; i < animalsAviary.length; i++) {
            if(animalsAviary[i] == null) {
                animalsAviary[i] = animal;
                break;
            }
        }
        size++;
    }
    public void add(Animal  ... animals) throws AviaryIsFullException, AviaryIdenticalAnimalsException {
        if (animalsAviary.length < animals.length + size ) {
            throw new AviaryIsFullException("the aviary is full");
        }

        for (Animal aviaryAnimal : animalsAviary) {
            for (Animal newAnimal : animals)
                if(aviaryAnimal != null) {
                    if (aviaryAnimal.getClass().equals(newAnimal.getClass()))
                        throw new AviaryIdenticalAnimalsException("The same animals in the aviary");
                }
        }
        for (Animal newAnimal : animals){
            for (int i = 0; i < animalsAviary.length; i++) {
                if(animalsAviary[i] == null) {
                    animalsAviary[i] = newAnimal;
                    break;
                }
            }
        }

        size += animals.length;
    }
}

