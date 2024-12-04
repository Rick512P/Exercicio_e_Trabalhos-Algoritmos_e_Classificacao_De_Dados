package Classes_LE;

import java.util.PriorityQueue;

public class DijkstraL {
    private GrafoL grafo;

    public DijkstraL(GrafoL grafo) {
        this.grafo = grafo;
    }

    public int[] calcularCaminhoMinimo(int origem) {
        int[] distancias = new int[grafo.numVertices];
        final int INFINITO = Integer.MAX_VALUE;
        boolean[] visitados = new boolean[grafo.numVertices];
        PriorityQueue<VerticeDistancia> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.distancia, b.distancia));

        // Inicializa as distâncias
        for (int i = 0; i < grafo.numVertices; i++) {
            distancias[i] = INFINITO;
        }
        distancias[origem] = 0;

        minHeap.add(new VerticeDistancia(origem, 0));

        while (!minHeap.isEmpty()) {
            VerticeDistancia atual = minHeap.poll();
            int u = atual.vertice;

            if (visitados[u]) {
                continue;
            }
            visitados[u] = true;

            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                if (!visitados[v] && distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    minHeap.add(new VerticeDistancia(v, distancias[v]));
                }
            }
        }

        return distancias;
    }

    public static void main(String[] args) {
        GrafoL grafo = new GrafoL(5, true);
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 4, 5);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(1, 4, 2);
        grafo.adicionarAresta(2, 3, 4);
        grafo.adicionarAresta(3, 0, 7);
        grafo.adicionarAresta(3, 2, 6);
        grafo.adicionarAresta(4, 1, 3);
        grafo.adicionarAresta(4, 2, 9);
        grafo.adicionarAresta(4, 3, 2);

        DijkstraL dijkstra = new DijkstraL(grafo);
        int[] distancias = dijkstra.calcularCaminhoMinimo(0);

        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("Vértice " + i + ": " + distancias[i]);
        }
    }

    // Classe para auxiliar na fila de prioridade
    static class VerticeDistancia {
        int vertice;
        int distancia;

        public VerticeDistancia(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }
    }
}
