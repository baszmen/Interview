package algorithm;

import java.util.ArrayList;

public class MergeSort {
    private ArrayList<Integer> elements;

    public MergeSort(ArrayList<Integer> data) {
        this.elements = new ArrayList<>(data);
    }

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort (start, mid);
            sort (mid + 1, end);
            merge (start, mid, end);
        }
    }

    public void merge(int start, int mid, int end) {
        ArrayList<Integer> helper = new ArrayList<>(this.elements);

        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (helper.get(i) < helper.get(j)) {
                this.elements.set(k, helper.get(i));
                i++;
            } else {
                this.elements.set(k, helper.get(j));
                j++;
            }
            k++;
        }

        while (i <= mid) {
            this.elements.set(k, helper.get(i));
            i++;
            k++;
        }

        while (j <= end) {
            this.elements.set(k, helper.get(j));
            j++;
            k++;
        }
    }
}
