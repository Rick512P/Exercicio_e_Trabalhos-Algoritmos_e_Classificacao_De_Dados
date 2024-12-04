package Classes_LE;

import java.util.LinkedList;
import java.util.Queue;

public class BFSL {
    private GrafoL grafoL;

    public BFSL(GrafoL grafoL) {
        this.grafoL = grafoL;
    }

    public void buscaLargura(int verticeInicial) {
        if (verticeInicial < 0 || verticeInicial >= grafoL.numVertices) {
            throw new IllegalArgumentException("Vértice inicial inválido.");
        }

        boolean[] visitados = new boolean[grafoL.numVertices]; // Marca os vértices visitados
        Queue<Integer> fila = new LinkedList<>(); // Fila para os vértices a serem processados

        // Inicia a BFS
        fila.add(verticeInicial);
        visitados[verticeInicial] = true;

        System.out.println("Busca em Largura a partir do vértice " + verticeInicial + ":");

        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll(); // Remove o próximo vértice da fila
            System.out.print(verticeAtual + " ");

            // Itera pelos vértices adjacentes na lista de adjacência
            for (GrafoL.Aresta aresta : grafoL.listaAdjacencia.get(verticeAtual)) {
                int destino = aresta.destino;
                if (!visitados[destino]) {
                    fila.add(destino);
                    visitados[destino] = true;
                }
            }
        }

        System.out.println(); // Nova linha ao final da BFS
    }

    public static void main(String[] args) {
        GrafoL grafoL = new GrafoL(5, false); // Grafo não ponderado com 5 vértices
        grafoL.adicionarAresta(0, 1);
        grafoL.adicionarAresta(1, 2);
        grafoL.adicionarAresta(2, 3);
        grafoL.adicionarAresta(3, 4);

        System.out.println("Grafo");
        BFSL bfs = new BFSL(grafoL);
        bfs.buscaLargura(0); // Busca em largura a partir do vértice 0
    }
}

