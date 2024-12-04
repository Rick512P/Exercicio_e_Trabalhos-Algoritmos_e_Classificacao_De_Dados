package Classes_LE;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class GrafoL {
    public List<LinkedList<Aresta>> listaAdjacencia;
    public int numVertices;
    public boolean ponderado;

    public GrafoL(int numVertices, boolean ponderado) {
        this.numVertices = numVertices;
        this.ponderado = ponderado;
        this.listaAdjacencia = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            listaAdjacencia.add(new LinkedList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
        if (!ponderado) {
            peso = 1; // Arestas em grafos não ponderados têm peso fixo 1
        } else if (peso < 0) {
            throw new IllegalArgumentException("Pesos negativos não são permitidos em grafos ponderados.");
        }
        listaAdjacencia.get(origem).add(new Aresta(origem, destino, peso));
        listaAdjacencia.get(destino).add(new Aresta(destino, origem, peso)); // Grafo não direcionado
    }

    public void adicionarAresta(int origem, int destino) {
        adicionarAresta(origem, destino, 1);
    }

    public void mostrarGrafoL() {
        for (int i = 0; i < listaAdjacencia.size(); i++) {
            System.out.print(i + ": ");
            for (Aresta aresta : listaAdjacencia.get(i)) {
                System.out.print("[" + aresta.destino + ", " + aresta.peso + "] ");
            }
            System.out.println();
        }
    }

    public static class Aresta {
        public int origem;
        public int destino;
        public int peso;

        public Aresta(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        System.out.println("\nGrafo Ponderado:");
        GrafoL grafo = new GrafoL(5, true); // Grafo ponderado com 5 vértices
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(2, 3, 1);
        grafo.adicionarAresta(3, 4, 1);
        grafo.mostrarGrafoL();

        System.out.println("\nGrafo Não Ponderado:");
        GrafoL grafo2 = new GrafoL(5, false); // Grafo não ponderado com 5 vértices
        grafo2.adicionarAresta(0, 1);
        grafo2.adicionarAresta(1, 2);
        grafo2.adicionarAresta(2, 3);
        grafo2.adicionarAresta(3, 4);
        grafo2.mostrarGrafoL();
    }
}

