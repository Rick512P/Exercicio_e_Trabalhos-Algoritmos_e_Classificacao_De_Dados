package Classes_LE;

import java.util.ArrayList;
import java.util.List;

import Classes_LE.GrafoL.Aresta;

public class BellmanFordL extends GrafoL {
    private GrafoL grafo;

    public BellmanFordL (int numVertices, boolean ponderado){
        super(numVertices, ponderado);
    }

    public void atribui(GrafoL grafo) {
        this.grafo = grafo;
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
        listaAdjacencia.get(origem).add(new Aresta(origem, destino, peso));
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

                    // Verifica se é possível relaxar a aresta
                    if (distancias[u] != INFINITO && distancias[u] + peso < distancias[v]) {
                        distancias[v] = distancias[u] + peso;
                    }
                }
            }
        }

        // Verifica ciclos de peso negativo
        boolean cicloNegativoDetectado = false;
        for (int u = 0; u < grafo.numVertices; u++) {
            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                // Se ainda houver uma aresta que pode ser relaxada, há um ciclo negativo
                if (distancias[u] != INFINITO && distancias[u] + peso < distancias[v]) {
                    cicloNegativoDetectado = true;
                    System.out.println("Ciclo de peso negativo detectado a partir do vértice " + u + " para " + v);
                }
            }
        }

        if (cicloNegativoDetectado) {
            System.out.println("Aviso: O grafo contém ciclos de peso negativo, os resultados podem não ser válidos.");
        }

        return distancias;
    }

    public static void main(String[] args) {
        BellmanFordL bellmanFord = new BellmanFordL(5, true);
        bellmanFord.adicionarAresta(0, 1, -1);
        bellmanFord.adicionarAresta(0, 2, 4);
        bellmanFord.adicionarAresta(1, 2, 3);
        bellmanFord.adicionarAresta(1, 3, 2);
        bellmanFord.adicionarAresta(1, 4, 2);
        bellmanFord.adicionarAresta(3, 2, 5);
        bellmanFord.adicionarAresta(3, 1, 1);
        bellmanFord.adicionarAresta(4, 3, -3);

        bellmanFord.atribui(bellmanFord);
        int[] distancias = bellmanFord.calcularCaminhoMinimo(0);
        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("Vértice " + i + ": " + (distancias[i] == Integer.MAX_VALUE ? "INFINITO" : distancias[i]));
        }
    }
}
