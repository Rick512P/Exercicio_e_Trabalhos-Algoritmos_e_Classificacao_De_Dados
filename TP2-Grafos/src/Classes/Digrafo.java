package Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Digrafo extends Grafo {

    public Digrafo(int numVertices, boolean ponderado) {
        super(numVertices, ponderado);
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }
        if (!ponderado) {
            peso = 1; // Arestas em grafos não ponderados têm peso fixo 1
        } else if (peso < 0) {
            throw new IllegalArgumentException("Pesos negativos não são permitidos em grafos ponderados.");
        }

        matrizAdjacencia[origem][destino] = peso;
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        int peso = 1;
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }

        matrizAdjacencia[origem][destino] = peso;
    }
    public static void main(String[] args) {
        
        System.out.println("\nDigrafo Ponderado:");
        Digrafo digrafo = new Digrafo(5, true); // Digrafo ponderado com 5 vértices
        digrafo.adicionarAresta(0, 1, 10);
        digrafo.adicionarAresta(1, 2, 1);
        digrafo.adicionarAresta(2, 3, 1);
        digrafo.adicionarAresta(3, 4, 1);
        digrafo.mostrarGrafo();

        System.out.println("\nDigrafo Não Ponderado:");
        Digrafo digrafo2 = new Digrafo(5, false); // Digrafo não ponderado com 5 vértices
        digrafo2.adicionarAresta(0, 1);
        digrafo2.adicionarAresta(1, 2);
        digrafo2.adicionarAresta(2, 3);
        digrafo2.adicionarAresta(3, 4);
        digrafo2.mostrarGrafo();
    }
}