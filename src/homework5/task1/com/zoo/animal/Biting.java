package homework5.task1.com.zoo.animal;

import homework5.task1.com.zoo.exception.BitingException;

public interface Biting  {
    void bite(Animal animal) throws BitingException;
}
