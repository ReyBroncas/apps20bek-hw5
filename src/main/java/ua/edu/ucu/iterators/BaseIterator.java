package ua.edu.ucu.iterators;

import java.util.Iterator;

public class BaseIterator implements Iterator<Integer> {
    private final int[] arr;
    private final int length;
    private int index;

    public BaseIterator(int[] values) {
        this.length = values.length;
        this.arr = new int[length];
        this.index = -1;

        System.arraycopy(values, 0, arr, 0, length);
    }
    @Override
    public boolean hasNext() {
        return index < length - 1;
    }

    @Override
    public Integer next() {
        return arr[++index];
    }
}
