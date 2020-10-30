package homework5.task1.com.zoo.animal;

import homework5.task1.com.zoo.exception.BitingException;

public class Dog extends Animal implements Running,Biting {
    public Dog(String name) {
        this.name = name;
        says="woof";
    }
    @Override
    public void say() {
        System.out.println(says);
    }

    @Override
    public void run() {
        System.out.println(name + " is run");
    }

    @Override
    public void run(int meters) {
        System.out.println(String.format("%s is run %s meters",name,meters));
    }

    @Override
    public void bite(Animal animal) throws BitingException {
        System.out.println(String.format("%s is bite %s",name,animal));
    }
}
