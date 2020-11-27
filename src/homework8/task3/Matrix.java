package homework8.task3;

import java.util.ArrayList;
import java.util.Arrays;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix = (Matrix<?>) o;
        return Arrays.equals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E>{

        int x;
        int y;
        boolean hasNext;
        int circle;

        public Itr() {
            this.x = 0;
            this.y = -1;
            this.circle = 0;
        }

        @Override
        public boolean hasNext() {
            int minLength;
            if (data[0].length == data.length && data.length % 2 == 0){
                minLength = (data.length-1)/2;

                if(y == minLength && x == data[0].length-1-minLength)
                    return false;
            }
            else {
                if(data[0].length > data.length)
                    minLength = (data.length-1)/2;
                else
                    minLength = (data[0].length-1)/2;

                if(y == data[0].length-1-minLength && x == data.length-1-minLength){
                    return false;
                }
            }
            return true;
        }

        @Override
        public E next() {
            if(y<data[x].length-circle-1 && x==circle){
                y++;
            }
            else if(x<data.length-circle-1 && y == data[x].length-circle-1){
                x++;
            }
            else if(y>circle){
                y--;
            }
            else if(x!=circle+1){
                x--;
            }
            else{
                circle++;
                x = circle;
                y = circle;
            }


            return (E) data[x][y];
        }

    }
}
