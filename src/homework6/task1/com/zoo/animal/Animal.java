package homework6.task1.com.zoo.animal;

public abstract class Animal {
    String name;
    String says;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }


    public abstract void say();

    @Override
    public String toString() {
        return String.format("%s %s",this.getClass().getSimpleName().toLowerCase(),name);
    }
}
