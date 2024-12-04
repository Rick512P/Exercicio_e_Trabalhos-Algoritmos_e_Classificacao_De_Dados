package Classes_LE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ordenacao_TopologicaL {
    private GrafoL grafo;

    public Ordenacao_TopologicaL(GrafoL grafo) {
        this.grafo = grafo;
    }

    public ArrayList<Integer> ordenarTopologicamente() {
        int[] grauEntrada = new int[grafo.numVertices]; // Armazena o grau de entrada de cada vértice
        ArrayList<Integer> ordenacao = new ArrayList<>();
        Queue<Integer> fila = new LinkedList<>();

        // Calcula o grau de entrada de cada vértice
        for (int i = 0; i < grafo.numVertices; i++) {
            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(i)) {
                grauEntrada[aresta.destino]++;
            }
        }

        // Adiciona os vértices com grau de entrada 0 à fila
        for (int i = 0; i < grafo.numVertices; i++) {
            if (grauEntrada[i] == 0) {
                fila.add(i);
            }
        }

        // Processa os vértices na fila
        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            ordenacao.add(vertice);

            // Reduz o grau de entrada dos vértices adjacentes
            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(vertice)) {
                grauEntrada[aresta.destino]--;
                if (grauEntrada[aresta.destino] == 0) {
                    fila.add(aresta.destino);
                }
            }
        }

        // Verifica se houve ciclo no grafo
        if (ordenacao.size() != grafo.numVertices) {
            throw new IllegalStateException("O grafo contém ciclos. A ordenação topológica não é possível.");
        }

        return ordenacao;
    }

    public static void main(String[] args) {
        GrafoL grafo = new GrafoL(6, false); // Digrafo com 6 vértices
        grafo.adicionarAresta(5, 2);
        grafo.adicionarAresta(5, 0);
        grafo.adicionarAresta(4, 0);
        grafo.adicionarAresta(4, 1);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 1);

        System.out.println("Grafo representado como lista de adjacência:");
        grafo.mostrarGrafoL();

        Ordenacao_TopologicaL ordenacao = new Ordenacao_TopologicaL(grafo);
        try {
            ArrayList<Integer> resultado = ordenacao.ordenarTopologicamente();
            System.out.println("Ordenação Topológica: " + resultado);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

