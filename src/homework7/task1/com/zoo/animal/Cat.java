package homework7.task1.com.zoo.animal;

public class Cat extends Animal implements Running {
    public Cat(String name) {
        this.name = name;
        says="meow";
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
}
