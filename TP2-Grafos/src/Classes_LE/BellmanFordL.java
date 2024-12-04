package Classes_LE;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordL {
    private GrafoL grafo;

    public BellmanFordL(GrafoL grafo) {
        this.grafo = grafo;
    }

    public int[] calcularCaminhoMinimo(int origem) {
        int[] distancias = new int[grafo.numVertices];
        final int INFINITO = Integer.MAX_VALUE;

        // Inicializa as distâncias
        for (int i = 0; i < grafo.numVertices; i++) {
            distancias[i] = INFINITO;
        }
        distancias[origem] = 0;

        // Relaxa todas as arestas (V-1) vezes
        for (int i = 0; i < grafo.numVertices - 1; i++) {
            for (int u = 0; u < grafo.numVertices; u++) {
                for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(u)) {
                    int v = aresta.destino;
                    int peso = aresta.peso;
                    if (distancias[u] != INFINITO && distancias[u] + peso < distancias[v]) {
                        distancias[v] = distancias[u] + peso;
                    }
                }
            }
        }

        // Verifica ciclos de peso negativo
        for (int u = 0; u < grafo.numVertices; u++) {
            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;
                if (distancias[u] != INFINITO && distancias[u] + peso < distancias[v]) {
                    throw new IllegalStateException("O grafo contém ciclos de peso negativo.");
                }
            }
        }

        return distancias;
    }

    public static void main(String[] args) {
        GrafoL grafo = new GrafoL(5, true);
        grafo.adicionarAresta(0, 1, -1);
        grafo.adicionarAresta(0, 2, 4);
        grafo.adicionarAresta(1, 2, 3);
        grafo.adicionarAresta(1, 3, 2);
        grafo.adicionarAresta(1, 4, 2);
        grafo.adicionarAresta(3, 2, 5);
        grafo.adicionarAresta(3, 1, 1);
        grafo.adicionarAresta(4, 3, -3);

        BellmanFordL bellmanFord = new BellmanFordL(grafo);
        try {
            int[] distancias = bellmanFord.calcularCaminhoMinimo(0);
            System.out.println("Distâncias a partir do vértice 0:");
            for (int i = 0; i < distancias.length; i++) {
                System.out.println("Vértice " + i + ": " + distancias[i]);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

