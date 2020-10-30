package homework6.task1.com.zoo.animal;

public class Mouse extends Animal implements Running {
    public Mouse(String name) {
        this.name = name;
        says="squeek";
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
