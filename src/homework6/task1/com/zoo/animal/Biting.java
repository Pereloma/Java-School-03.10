package homework6.task1.com.zoo.animal;

import homework6.task1.com.zoo.exception.BitingException;

public interface Biting  {
    void bite(Animal animal) throws BitingException, homework6.task1.com.zoo.exception.BitingException;
}
