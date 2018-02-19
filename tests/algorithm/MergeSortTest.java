package algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MergeSortTest {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();

        MergeSort sorter = new MergeSort(new ArrayList<>(
                Arrays.stream(numbers).boxed().collect(Collectors.toList())
        ));
        sorter.sort(0, this.numbers.length - 1);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort " + elapsedTime);

        for (int i = 0; i < sorter.getElements().size() - 1; i++) {
            if (sorter.getElements().get(i) > sorter.getElements().get(i + 1)) {
                fail("Should not happen");
            }
        }
        assertTrue(true);

    }

    @Test
    public void itWorksRepeatably() {
        for (int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            MergeSort sorter = new MergeSort(new ArrayList<>(
                    Arrays.stream(numbers).boxed().collect(Collectors.toList())
            ));
            sorter.sort(0, this.numbers.length - 1);
            for (int j = 0; j < sorter.getElements().size() - 1; j++) {
                if (sorter.getElements().get(j) > sorter.getElements().get(j + 1)) {
                    fail("Should not happen");
                }
            }
            assertTrue(true);
        }
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }
}