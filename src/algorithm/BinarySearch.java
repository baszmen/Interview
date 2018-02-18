package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    private ArrayList<Integer> elements;

    public BinarySearch(ArrayList<Integer> data) {
        this.elements = new ArrayList<>(data);
    }

    public int size() {
        return this.elements.size();
    }

    /*
        Recursive binary search. Returns -1 if there is no element in array
     */
    public int search_recursive(int start, int end, int element) {
        if (end < start) return -1;

        int mid = (start + end) / 2;

        if (this.elements.get(mid) == element) return mid;
        if (this.elements.get(mid) > element) return search_recursive(start, mid - 1, element);
        else return search_recursive(mid + 1, end, element);
    }

    /*
        Iterative binary search. Returns -1 if there is no element in array
     */
    public int search_iterative(int start, int end, int element) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (this.elements.get(mid) == element) return mid;
            else if (this.elements.get(mid) > element) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }
}
