package homework8.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Matrix<E> implements Iterable<E>{
    private Object[][] data;

    public Matrix(int sizeX, int sizeY) {
        this.data = new Object[sizeX][sizeY];
    }
    public E get(int x, int y){
        return (E) data[x][y];
    }

    public boolean put(){
        return false;
    }

    public boolean put(int x, int y, E element){
        data[x][y] = element;
        if(data[x][y] == element)
            return true;
        else return false;
    }


    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
    private class Itr implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}
