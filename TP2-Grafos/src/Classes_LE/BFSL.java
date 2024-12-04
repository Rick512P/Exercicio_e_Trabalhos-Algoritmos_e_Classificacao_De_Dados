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
        // Exemplo com GrafoL
        GrafoL grafoL = new GrafoL(5, false);
        grafoL.adicionarAresta(0, 1);
        grafoL.adicionarAresta(1, 2);
        grafoL.adicionarAresta(2, 3);
        grafoL.adicionarAresta(3, 4);
        BFSL bfsGrafo = new BFSL(grafoL);
        System.out.println("\nGrafo ");
        bfsGrafo.buscaLargura(0);
    
        // Exemplo com DigrafoL
        DigrafoL digrafoL = new DigrafoL(5, false);
        digrafoL.adicionarAresta(0, 1);
        digrafoL.adicionarAresta(1, 2);
        digrafoL.adicionarAresta(2, 3);
        digrafoL.adicionarAresta(3, 4);
        BFSL bfsDigrafo = new BFSL(digrafoL);
        System.out.println("\nDigrafo ");
        bfsDigrafo.buscaLargura(0);
    }
    
}


