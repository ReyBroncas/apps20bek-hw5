package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;

public class FilterIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private IntPredicate predicate;

    public FilterIterator(Iterator<Integer> iterator, IntPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        int next = iterator.next();
        Integer tmpNext = null;

        while (iterator.hasNext() &&
                !predicate.test(next)) {
            next = iterator.next();
        }
        if (predicate.test(next)) {
            tmpNext = next;
        }
        return tmpNext;
    }
}
