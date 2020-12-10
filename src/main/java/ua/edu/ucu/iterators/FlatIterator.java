package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntToIntStreamFunction;

import java.util.Iterator;

public class FlatIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Iterator<Integer> tmpIterator;
    private IntToIntStreamFunction func;

    public FlatIterator(Iterator<Integer> iterator,
                        IntToIntStreamFunction func) {
        this.iterator = iterator;
        this.func = func;
    }

    @Override
    public boolean hasNext() {
        if (tmpIterator != null && tmpIterator.hasNext()) {
            return true;
        }
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (tmpIterator != null && tmpIterator.hasNext()) {
            return tmpIterator.next();
        }
        Integer next = iterator.next();
        if (next == null) {
            return next;
        }
        tmpIterator = new BaseIterator(func.applyAsIntStream(next).toArray());
        return tmpIterator.next();
    }
}
