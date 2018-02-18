package task;

import structure.Point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeIntervals {
    public ArrayList<Point> intervals;

    public MergeIntervals(ArrayList<Point> data) {
        this.intervals = new ArrayList<>(data);
    }

    public MergeIntervals(int count) {
        this.intervals = new ArrayList<>();

        this.intervals.addAll(
                IntStream.of(count)
                        .mapToObj(value -> generateInterval())
                        .collect(Collectors.toList()));
    }

    private Point generateInterval() {
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();

        return new Point(Math.min(x,y), Math.max(x,y));
    }

    public void sort() {
        this.intervals.sort((o1, o2) -> (o1.x <= o2.x) ? 1 : -1);
}

    public ArrayList<Point> merge() {
        this.sort();
        ArrayList<Point> result = new ArrayList<>();

        Point merged = this.intervals.get(0);

        for (int i = 1; i < this.intervals.size(); i++) {
            Point point = this.intervals.get(i);
            // to merge
            if (point.x <= merged.y) merged.y = Math.max(merged.y, point.y);
            else {
                result.add(new Point(merged.x, merged.y));
                merged = point;
            }
        }

        return result;
    }
}
