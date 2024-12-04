package Classes_Matriz;

import java.util.ArrayList;
import java.util.Collections;

public class DigrafoM extends GrafoM {

    public DigrafoM(int numVertices, boolean ponderado) {
        super(numVertices, ponderado);
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }
        if (!ponderado) {
            peso = 1; // Arestas em grafos não ponderados têm peso fixo 1
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
        DigrafoM digrafo = new DigrafoM(5, true); // Digrafo ponderado com 5 vértices
        digrafo.adicionarAresta(0, 1, 10);
        digrafo.adicionarAresta(1, 2, 1);
        digrafo.adicionarAresta(2, 3, 1);
        digrafo.adicionarAresta(3, 4, 1);
        digrafo.mostrarGrafoM();

        System.out.println("\nDigrafo Não Ponderado:");
        DigrafoM digrafo2 = new DigrafoM(5, false); // Digrafo não ponderado com 5 vértices
        digrafo2.adicionarAresta(0, 1);
        digrafo2.adicionarAresta(1, 2);
        digrafo2.adicionarAresta(2, 3);
        digrafo2.adicionarAresta(3, 4);
        digrafo2.mostrarGrafoM();
    }
}