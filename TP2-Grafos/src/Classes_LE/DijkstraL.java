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
        // Teste com GrafoL (não direcionado)
        System.out.println("===== GrafoL =====");
        GrafoL grafoL = new GrafoL(5, true);
        grafoL.adicionarAresta(0, 1, 10);
        grafoL.adicionarAresta(0, 4, 5);
        grafoL.adicionarAresta(1, 2, 1);
        grafoL.adicionarAresta(1, 4, 2);
        grafoL.adicionarAresta(2, 3, 4);
        grafoL.adicionarAresta(4, 3, 2);

        DijkstraL dijkstraL = new DijkstraL(grafoL);
        int[] distanciasL = dijkstraL.calcularCaminhoMinimo(0);
        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distanciasL.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasL[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasL[i]));
        }

        // Teste com DigrafoL (direcionado)
        System.out.println("\n===== DigrafoL =====");
        DigrafoL digrafoL = new DigrafoL(5, true);
        digrafoL.adicionarAresta(0, 1, 10);
        digrafoL.adicionarAresta(0, 4, 5);
        digrafoL.adicionarAresta(1, 2, 1);
        digrafoL.adicionarAresta(1, 4, 2);
        digrafoL.adicionarAresta(2, 3, 4);
        digrafoL.adicionarAresta(4, 3, 2);

        DijkstraL dijkstraDigrafo = new DijkstraL(digrafoL);
        int[] distanciasDigrafo = dijkstraDigrafo.calcularCaminhoMinimo(0);
        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distanciasDigrafo.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasDigrafo[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasDigrafo[i]));
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
