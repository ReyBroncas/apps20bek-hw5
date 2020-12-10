package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class MapIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private final IntUnaryOperator mapper;

    public MapIterator(Iterator<Integer> iterator, IntUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        Integer value = iterator.next();
        if (value == null) {
            return value;
        }
        return mapper.apply(value);
    }
}
