package algorithm;

import java.util.*;

public class BFS {
    ArrayList<ArrayList<Integer>> edges;
    Map<Integer, Boolean> visited;
    Map<Integer, Integer> distance;
    Queue<Integer> queue;

    public BFS(ArrayList<ArrayList<Integer>> edges) {
        this.edges = edges;
        this.visited = new HashMap<>();
        this.distance = new HashMap<>();
        this.queue = new ArrayDeque<>();
    }

    public void clear() {
       this.edges.clear();
       this.visited.clear();
       this.queue.clear();
       this.distance.clear();
    }

    public void BFS(int start) {
        this.clear();

        this.distance.put(start, 0);
        this.visited.put(start, true);
        queue.add(start);
        while (!queue.isEmpty()) {
            int parent = queue.remove();
            ArrayList<Integer> children = this.edges.get(parent);
            for (int child : children) {
                if (!this.visited.get(child)) {
                    this.distance.put(child, this.distance.get(parent));
                    this.visited.put(child, true);
                    queue.add(child);
                }
            }
        }
    }
}
