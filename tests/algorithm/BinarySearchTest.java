package algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void search_recursive_base() {
        BinarySearch binarySearch = new BinarySearch(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        assertEquals(2, binarySearch.search_recursive(0, binarySearch.size()-1, 3));
    }

    @Test
    public void search_iterative() {
        BinarySearch binarySearch = new BinarySearch(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        assertEquals(2, binarySearch.search_iterative(0, binarySearch.size()-1, 3));
    }

    @Test
    public void search_not_found() {
        BinarySearch binarySearch = new BinarySearch(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        assertEquals(-1, binarySearch.search_recursive(0, binarySearch.size()-1, 10));


        binarySearch = new BinarySearch(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        assertEquals(-1, binarySearch.search_iterative(0, binarySearch.size()-1, -3));
    }

    @Test
    public void empty_array() {
        BinarySearch binarySearch = new BinarySearch(new ArrayList<>());
        assertEquals(-1, binarySearch.search_recursive(0, 0, 3));

        binarySearch = new BinarySearch(new ArrayList<>());
        assertEquals(-1, binarySearch.search_iterative(0, 0, 3));
    }
}