package homework7.task1.com.zoo.animal;

import homework7.task1.com.zoo.exception.AviaryException;
import homework7.task1.com.zoo.exception.AviaryIdenticalAnimalsException;
import homework7.task1.com.zoo.exception.AviaryIsFullException;
import homework7.task1.com.zoo.exception.NullAviaryException;

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

    public void putInAnAviary(Aviary aviary)throws NullAviaryException {
        if(aviary == null)
            throw new NullAviaryException("Non-existent aviary");

        try {
            aviary.add(this);
        } catch (AviaryException e) {
            e.printStackTrace();
        }
    }


    public abstract void say();

    @Override
    public String toString() {
        return String.format("%s %s",this.getClass().getSimpleName().toLowerCase(),name);
    }
}
