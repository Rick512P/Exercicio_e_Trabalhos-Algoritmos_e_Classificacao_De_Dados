package Classes_Matriz;
import java.util.*;

public class Dijkstra {
    private int vertices;
    private List<List<int[]>> grafo;

    public Dijkstra(int vertices) {
        this.vertices = vertices;
        grafo = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        grafo.get(origem).add(new int[]{destino, peso});
    }

    public void encontrarCaminhoMinimo(int origem) {
        int[] distancia = new int[vertices];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.add(new int[]{origem, 0});

        while (!heap.isEmpty()) {
            int[] atual = heap.poll();
            int vertice = atual[0];
            int distAtual = atual[1];

            if (distAtual > distancia[vertice]) continue;

            for (int[] vizinho : grafo.get(vertice)) {
                int novoDist = distAtual + vizinho[1];
                if (novoDist < distancia[vizinho[0]]) {
                    distancia[vizinho[0]] = novoDist;
                    heap.add(new int[]{vizinho[0], novoDist});
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Para " + i + ": " + distancia[i]);
        }
    }


    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(5);
    
        dijkstra.adicionarAresta(0, 1, 10);
        dijkstra.adicionarAresta(0, 4, 3);
        dijkstra.adicionarAresta(1, 2, 2);
        dijkstra.adicionarAresta(1, 4, 4);
        dijkstra.adicionarAresta(2, 3, 9);
        dijkstra.adicionarAresta(3, 2, 7);
        dijkstra.adicionarAresta(4, 1, 1);
        dijkstra.adicionarAresta(4, 2, 8);
        dijkstra.adicionarAresta(4, 3, 2);
    
        dijkstra.encontrarCaminhoMinimo(0);
    }
    
}
