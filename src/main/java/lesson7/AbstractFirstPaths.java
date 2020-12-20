package lesson7;

import java.util.LinkedList;

public abstract class AbstractFirstPaths {

    protected final boolean[] marked;
    protected final int[] edgeTo;
    protected final int source;

    protected AbstractFirstPaths(boolean[] marked, int[] edgeTo, int source) {
        this.marked = marked;
        this.edgeTo = edgeTo;
        this.source = source;
    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
