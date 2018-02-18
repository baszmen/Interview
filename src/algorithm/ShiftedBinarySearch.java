package algorithm;

import java.util.ArrayList;

public class ShiftedBinarySearch {
    ArrayList<Integer> elements;

    public ShiftedBinarySearch(ArrayList<Integer> data) {
        this.elements = new ArrayList<>(data);
    }

    public int size() {
        return this.elements.size();
    }

    public int search_recursive_shifted(int start, int end, int element) {
        if (end < start) return -1;

        int mid = (start + end) / 2;

        if (this.elements.get(mid) == element) return mid;
        if (start == end) return -1;

        // right half is sorted
        if (this.elements.get(mid + 1) < this.elements.get(end)) {
            if (element >= this.elements.get(mid + 1) && element <= this.elements.get(end))
                return search_recursive_shifted(mid+1, end, element);
            return search_recursive_shifted(start, mid - 1, element);
        }
        // left half is sorted
        else {
            if (element >= this.elements.get(start) && element <= this.elements.get(mid-1))
                return search_recursive_shifted(start, mid-1, element);
            return search_recursive_shifted(mid + 1, end, element);
        }
    }
}
