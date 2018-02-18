package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ShiftedBinarySearchTest {

    @Test
    public void search_recursive_shifted_base() {
         ShiftedBinarySearch sbs = new ShiftedBinarySearch(new ArrayList<>(Arrays.asList(5)));
         assertEquals(-1, sbs.search_recursive_shifted(0, sbs.size() - 1, 65));
    }
}