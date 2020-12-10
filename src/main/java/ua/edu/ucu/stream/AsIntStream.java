package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterators.BaseIterator;
import ua.edu.ucu.iterators.FilterIterator;
import ua.edu.ucu.iterators.FlatIterator;
import ua.edu.ucu.iterators.MapIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class AsIntStream implements IntStream {
    private final Iterator<Integer> iterator;

    private AsIntStream(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    private AsIntStream(int[] arr) {
        iterator = new BaseIterator(arr);
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    private int findMaxValue(boolean isMax) {
        checkIfNotEmpty();
        int multiplyValue, max;
        Integer value;

        if (isMax) {
            multiplyValue = 1;
        } else {
            multiplyValue = -1;
        }

        max = iterator.next();
        while (iterator.hasNext()) {
            value = iterator.next();
            if ((value != null)
                    && (value * multiplyValue > max * multiplyValue)) {
                max = value;
            }
        }
        return max;
    }

    private void checkIfNotEmpty() {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Double average() {
        checkIfNotEmpty();
        int sum = 0, len = 0;
        Integer value;

        while (iterator.hasNext()) {
            value = iterator.next();
            if (value != null) {
                sum += value;
            }
            ++len;
        }
        return (double) sum / len;
    }

    @Override
    public Integer max() {
        return findMaxValue(true);
    }

    @Override
    public Integer min() {
        return findMaxValue(false);
    }

    @Override
    public long count() {
        checkIfNotEmpty();
        long len = 0;

        while (iterator.hasNext()) {
            if (iterator.next() != null) {
                ++len;
            }
        }
        return len;
    }

    @Override
    public Integer sum() {
        checkIfNotEmpty();
        int sum = 0;
        Integer value;

        while (iterator.hasNext()) {
            value = iterator.next();
            if (value != null) {
                sum += value;
            }
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIterator(iterator,
                predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        checkIfNotEmpty();
        Integer value;

        while (iterator.hasNext()) {
            value = iterator.next();
            if (value != null) {
                action.accept(value);
            }
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(iterator, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatIterator(iterator, func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        checkIfNotEmpty();
        Integer value;
        int result = identity;

        while (iterator.hasNext()) {
            value = iterator.next();
            if (value != null) {
                result = op.apply(result, value);
            }
        }
        return result;
    }

    @Override
    public int[] toArray() {
        checkIfNotEmpty();
        Integer value;
        ArrayList<Integer> tmpArray = new ArrayList<>();

        while (iterator.hasNext()) {
            value = iterator.next();
            if (value != null) {
                tmpArray.add(value);
            }
        }

        int length = tmpArray.size();
        int[] newArray = new int[length];

        for (int i = 0; i < length; ++i) {
            newArray[i] = tmpArray.get(i);
        }
        return newArray;
    }
}
