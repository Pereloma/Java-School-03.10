package homework7.task1.com.zoo.animal;

public class Duck extends Animal implements Running,Flying{
    public Duck(String name) {
        this.name = name;
        says="quack";
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
    public void fly() {
        System.out.println(name + " is fly");
    }

    @Override
    public void fly(int meters) {
        System.out.println(String.format("%s is fly %s meters",name,meters));
    }
}
