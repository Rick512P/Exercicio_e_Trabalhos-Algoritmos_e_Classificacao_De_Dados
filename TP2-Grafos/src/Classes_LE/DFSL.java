package Classes_LE;

import java.util.Stack;

public class DFSL {
    private GrafoL grafoL;

    public DFSL(GrafoL grafoL) {
        this.grafoL = grafoL;
    }

    public void buscaProfundidade(int verticeInicial) {
        if (verticeInicial < 0 || verticeInicial >= grafoL.numVertices) {
            throw new IllegalArgumentException("Vértice inicial inválido.");
        }

        boolean[] visitados = new boolean[grafoL.numVertices]; // Marca os vértices visitados
        Stack<Integer> pilha = new Stack<>(); // Pilha para controlar o percurso

        // Inicia a DFS
        pilha.push(verticeInicial);
        System.out.println("Busca em Profundidade a partir do vértice " + verticeInicial + ":");

        while (!pilha.isEmpty()) {
            int verticeAtual = pilha.pop();

            // Se o vértice ainda não foi visitado
            if (!visitados[verticeAtual]) {
                visitados[verticeAtual] = true;
                System.out.print(verticeAtual + " ");

                // Adiciona os vértices adjacentes à pilha (não visitados)
                for (GrafoL.Aresta aresta : grafoL.listaAdjacencia.get(verticeAtual)) {
                    if (!visitados[aresta.destino]) {
                        pilha.push(aresta.destino);
                    }
                }
            }
        }

        System.out.println(); // Nova linha ao final da DFS
    }

    public static void main(String[] args) {
        GrafoL grafoL = new GrafoL(5, false); // Grafo não ponderado com 5 vértices
        grafoL.adicionarAresta(0, 1);
        grafoL.adicionarAresta(1, 2);
        grafoL.adicionarAresta(2, 3);
        grafoL.adicionarAresta(3, 4);

        System.out.println("Grafo");
        DFSL dfs = new DFSL(grafoL);
        dfs.buscaProfundidade(0); // Busca em profundidade a partir do vértice 0
    }
}
