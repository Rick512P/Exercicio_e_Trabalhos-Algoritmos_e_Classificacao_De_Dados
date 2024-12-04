package Classes_LE;

import java.util.ArrayList;
import java.util.Collections;

public class DigrafoL extends GrafoL {
    public DigrafoL(int numVertices, boolean ponderado){
        super(numVertices, ponderado);
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
        if (!ponderado) {
            peso = 1; // Arestas em grafos não ponderados têm peso fixo 1
        }
        listaAdjacencia.get(origem).add(new Aresta(origem, destino, peso)); // Apenas adiciona a aresta no sentido origem -> destino
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        adicionarAresta(origem, destino, 1);
    }

    public static void main(String[] args) {
        System.out.println("\nDigrafo Ponderado:");
        DigrafoL grafo = new DigrafoL(5, true); // Grafo ponderado com 5 vértices
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(2, 3, 1);
        grafo.adicionarAresta(3, 4, 1);
        grafo.mostrarGrafoL();

        System.out.println("\nDigrafo Não Ponderado:");
        DigrafoL grafo2 = new DigrafoL(5, false); // Grafo não ponderado com 5 vértices
        grafo2.adicionarAresta(0, 1);
        grafo2.adicionarAresta(1, 2);
        grafo2.adicionarAresta(2, 3);
        grafo2.adicionarAresta(3, 4);
        grafo2.adicionarAresta(4, 4);
        grafo2.mostrarGrafoL();
    }
}
