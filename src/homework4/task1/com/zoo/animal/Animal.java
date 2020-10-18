package homework4.task1.com.zoo.animal;

public class Animal {
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


    public void say(){
        System.out.println(says);
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.getClass().getSimpleName(),name);
    }
}
