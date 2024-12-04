package Classes_Matriz;

import java.util.Arrays;

public class GrafoM {
    protected int[][] matrizAdjacencia;
    protected int numVertices;
    protected boolean ponderado;

    public GrafoM(int numVertices, boolean ponderado) {
        this.numVertices = numVertices;
        this.ponderado = ponderado;
        this.matrizAdjacencia = new int[numVertices][numVertices];

        // Inicializa a matriz com 0 (sem arestas)
        for (int[] row : matrizAdjacencia) {
            Arrays.fill(row, 0);
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }
        if (!ponderado) {
            peso = 1; // Arestas em grafos não ponderados têm peso fixo 1
        }

        matrizAdjacencia[origem][destino] = peso;
        matrizAdjacencia[destino][origem] = peso; // Grafo não direcionado
    }
    
    public void adicionarAresta(int origem, int destino) {
        int peso = 1;
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }

        matrizAdjacencia[origem][destino] = peso;
        matrizAdjacencia[destino][origem] = peso; // Grafo não direcionado
    }
    
    public void mostrarGrafoM() {
        System.out.println("\nMatriz de Adjacência do Grafo:");
        for (int[] row : matrizAdjacencia) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        System.out.println("\nGrafo Ponderado:");
        GrafoM grafo = new GrafoM(5, true); // Grafo ponderado com 5 vértices
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(2, 3, 1);
        grafo.adicionarAresta(3, 4, 1);
        grafo.mostrarGrafoM();

        System.out.println("\nGrafo Não Ponderado:");
        GrafoM grafo2 = new GrafoM(5, false); // Grafo não ponderado com 5 vértices
        grafo2.adicionarAresta(0, 1);
        grafo2.adicionarAresta(1, 2);
        grafo2.adicionarAresta(2, 3);
        grafo2.adicionarAresta(3, 4);
        grafo2.mostrarGrafoM();
    }
}
