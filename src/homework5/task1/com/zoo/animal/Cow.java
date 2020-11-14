package homework5.task1.com.zoo.animal;

public class Cow extends Animal implements Running{
    public Cow(String name) {
        this.name = name;
        says="moo";
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
