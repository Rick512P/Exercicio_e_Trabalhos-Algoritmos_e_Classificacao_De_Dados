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
        // Exemplo com GrafoL
        GrafoL grafoL = new GrafoL(5, false);
        grafoL.adicionarAresta(0, 1);
        grafoL.adicionarAresta(1, 2);
        grafoL.adicionarAresta(2, 3);
        grafoL.adicionarAresta(3, 4);
        DFSL dfsGrafo = new DFSL(grafoL);
        System.out.println("\nGrafo ");
        dfsGrafo.buscaProfundidade(0);

        // Exemplo com DigrafoL
        DigrafoL digrafoL = new DigrafoL(5, false);
        digrafoL.adicionarAresta(0, 1);
        digrafoL.adicionarAresta(1, 2);
        digrafoL.adicionarAresta(2, 3);
        digrafoL.adicionarAresta(3, 4);
        DFSL dfsDigrafo = new DFSL(digrafoL);
        System.out.println("\nDigrafo ");
        dfsDigrafo.buscaProfundidade(0);
    }
}
