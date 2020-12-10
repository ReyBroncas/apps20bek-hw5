package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StreamAppTest {

    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }

    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testSum() {
        IntStream intStream;
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);

        int expResult = 4;
        int result = intStream.sum();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSum2() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);
        intStream.sum();

        int result = intStream.sum();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testCount() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);

        int expResult = 6;
        int result = (int) intStream.count();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCount2() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);
        intStream.count();

        int result = (int) intStream.count();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testMax() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);

        int expResult = 2;
        int result = intStream.max();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMax2() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);
        intStream.max();

        int result = intStream.max();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testMin() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);

        int expResult = -1;
        int result = intStream.min();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMin2() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);
        intStream.min();

        int result = intStream.min();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testAvg() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);

        double expResult = 0.666;
        double result = intStream.average();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testToArray() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);

        double expResult = 0.666;
        double result = intStream.average();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testToFilter() {
        int[] intArr = {-1, 0, 2, 2, 0, 1};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {2, 2, 1};
        int[] result = intStream.filter(x -> x > 0).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToFilter2() {
        int[] intArr = {2, -1, -1};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {2};
        int[] result = intStream.filter(x -> x > 0).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToFilter3() {
        int[] intArr = {-1, -1, 2};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {2};
        int[] result = intStream.filter(x -> x > 0).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToFilter4() {
        int[] intArr = {-1, -1};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {};
        int[] result = intStream.filter(x -> x > 0).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToFilterSum() {
        int[] intArr = {-1, -1, 0, 0, 1, 2, 1, 0, 0, -1, -1};
        intStream = AsIntStream.of(intArr);

        int expResult = 4;
        int result = intStream.filter(x -> x > 0).sum();
        assertEquals(expResult, result);
    }

    @Test
    public void testToFilterCount() {
        int[] intArr = {-1, -1, 0, 0, 1, 2, 1, 0, 0, -1, -1};
        intStream = AsIntStream.of(intArr);

        int expResult = 3;
        int result = (int) intStream.filter(x -> x > 0).count();
        assertEquals(expResult, result);
    }

    @Test
    public void testToFilterMax() {
        int[] intArr = {-1, -1, 0, 0, 1, 12, 1, 0, 0, -1, -1};
        intStream = AsIntStream.of(intArr);

        int expResult = 12;
        int result = intStream.filter(x -> x > 0).max();
        assertEquals(expResult, result);
    }

    @Test
    public void testToMap() {
        int[] intArr = {0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {0, 2, 4, 6};
        int[] result = intStream.map(x -> x * 2).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToFilterMap() {
        int[] intArr = {-1, -1, -8, 0, 1, -1, 2, 3, -32, 0};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {2, 4, 6};
        int[] result = intStream.filter(x -> x > 0).map(x -> x * 2).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToFlat() {
        int[] intArr = {0, 10, 20, 30};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {-2, 2, 8, 12, 18, 22, 28, 32};
        int[] result = intStream.flatMap(x -> AsIntStream.of(x - 2, x + 2)).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToFilterFlat() {
        int[] intArr = {0, 10, 20, 30};
        intStream = AsIntStream.of(intArr);

        int[] expResult = {18, 22, 28, 32};
        int[] result = intStream.filter(x -> x > 10).flatMap(x -> AsIntStream.of(x - 2, x + 2)).toArray();
        assertArrayEquals(result, expResult);
    }

    @Test
    public void testToReduce() {
        int[] intArr = {0, 1, 2, 3, 4, 5, 8, 9, 10};
        intStream = AsIntStream.of(intArr);

        int expResult = 42;
        int result = intStream.reduce(0, (sum, x) -> sum += x);
        assertEquals(expResult, result);
    }
}
