package Classes_Matriz;

import java.util.*;

public class Grafo {
    public int vertices;
    private List<List<Integer>> listaAdj;
    private int[][] matrizAdj;

    // Construtor
    public Grafo(int vertices) {
        this.vertices = vertices;
        this.listaAdj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            listaAdj.add(new ArrayList<>());
        }
        this.matrizAdj = new int[vertices][vertices];
    }

    // Adicionar uma aresta
    public void adicionarAresta(int origem, int destino, int peso) {
        listaAdj.get(origem).add(destino);
        listaAdj.get(destino).add(origem); // Para grafos não direcionados

        matrizAdj[origem][destino] = peso;
        matrizAdj[destino][origem] = peso;
    }
}