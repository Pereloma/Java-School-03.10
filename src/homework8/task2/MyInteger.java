package homework8.task2;

import java.util.Iterator;

public class MyInteger implements Iterable<Integer> {
    int anInt;

    public MyInteger(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iter();
    }
    public class Iter implements Iterator<Integer>{
        int remains = anInt;

        @Override
        public boolean hasNext() {
            return remains != 0;
        }

        @Override
        public Integer next() {
            int re = remains%10;
            remains = remains/10;
            return re;
        }
    }
}
