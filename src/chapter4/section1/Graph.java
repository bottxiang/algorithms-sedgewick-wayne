package chapter4.section1;

import chapter1.section3.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by rene on 12/09/17.
 */
@SuppressWarnings("unchecked")
public class Graph {

    private final int vertices;
    private int edges;
    Bag<Integer>[] adjacent;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacent = (Bag<Integer>[]) new Bag[vertices];

        for(int i = 0; i < vertices; i++) {
            adjacent[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int edges = in.readInt();

        for(int i = 0; i < edges; i++) {
            int vertex1 = in.readInt();
            int vertex2 = in.readInt();
            addEdge(vertex1, vertex2);
        }
    }

    public int vertices() {
        return vertices;
    }

    public int edges() {
        return edges;
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacent[vertex1].add(vertex2);
        adjacent[vertex2].add(vertex1);
        edges++;
    }

    public void addDirectedEdge(int vertex1, int vertex2) {
        adjacent[vertex1].add(vertex2);
        edges++;
    }

    public Iterable<Integer> adjacent(int vertex) {
        return adjacent[vertex];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int vertex = 0; vertex < vertices(); vertex++) {
            stringBuilder.append(vertex).append(": ");

            for(int neighbor : adjacent(vertex)) {
                stringBuilder.append(neighbor).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}