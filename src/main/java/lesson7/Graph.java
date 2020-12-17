package lesson7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int vertexCount;
    private int edgeCount;
    private final LinkedList<Integer>[] adjList;

    public Graph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Количество вершин должно быть натуральным числом");
        }
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public List<Integer> getAdjList(int vertex) {
        //Возвращает неизменяемый лист, при этом не генерирует новый список, а
        //хранит под капотом изначальный список
        return Collections.unmodifiableList(adjList[vertex]);
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        //Сравнение перенесено выше, так как нет смысла добавлять ссылку на самого себя,
        //еще и увеличивая счетчик ребер
        if (v1 == v2) {
            return;
        }
        adjList[v1].add(v2);
        adjList[v2].add(v1);
        edgeCount++;
    }
}
