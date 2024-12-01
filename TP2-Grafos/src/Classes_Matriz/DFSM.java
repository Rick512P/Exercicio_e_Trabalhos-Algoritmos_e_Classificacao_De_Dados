package Classes_Matriz;

import java.util.Stack;

public class DFSM {
    private GrafoM grafoM;

    public DFSM(GrafoM grafoM) {
        this.grafoM = grafoM;
    }

    public DFSM(DigrafoM digrafoM) {
        this.grafoM = digrafoM;
    }

    public void buscaProfundidade(int verticeInicial) {
        if (verticeInicial < 0 || verticeInicial >= grafoM.numVertices) {
            throw new IllegalArgumentException("Vértice inicial inválido.");
        }

        boolean[] visitados = new boolean[grafoM.numVertices]; // Marca os vértices visitados
        Stack<Integer> pilha = new Stack<>(); // Pilha para os vértices a serem processados

        // Inicia a DFSM
        pilha.push(verticeInicial);

        System.out.println("Busca em Profundidade a partir do vértice " + verticeInicial + ":");

        while (!pilha.isEmpty()) {
            int verticeAtual = pilha.pop(); // Remove o próximo vértice da pilha

            if (!visitados[verticeAtual]) {
                System.out.print(verticeAtual + " ");
                visitados[verticeAtual] = true;

                // Itera pelos vértices adjacentes (adicionando à pilha)
                for (int i = grafoM.numVertices - 1; i >= 0; i--) { // Ordem reversa para simular recursividade
                    if (grafoM.matrizAdjacencia[verticeAtual][i] != 0 && !visitados[i]) {
                        pilha.push(i);
                    }
                }
            }
        }

        System.out.println(); // Nova linha ao final da DFSM
    }

    public static void main(String[] args) {

        GrafoM grafoM = new GrafoM(5, false); // GrafoM não ponderado com 5 vértices
        grafoM.adicionarAresta(0, 1);
        grafoM.adicionarAresta(1, 2);
        grafoM.adicionarAresta(2, 3);
        grafoM.adicionarAresta(3, 4);
        System.out.println("");

        System.out.println("Grafo");
        DFSM dfs = new DFSM(grafoM);
        dfs.buscaProfundidade(2); // Busca em profundidade a partir do vértice 2

        DigrafoM digrafoM = new DigrafoM(5, false); // DigrafoM não ponderado com 5 vértices
        digrafoM.adicionarAresta(0, 1);
        digrafoM.adicionarAresta(1, 2);
        digrafoM.adicionarAresta(2, 3);
        digrafoM.adicionarAresta(3, 4);
        System.out.println("");

        System.out.println("Digrafo");
        DFSM dfs2 = new DFSM(digrafoM);
        dfs2.buscaProfundidade(3); // Busca em profundidade a partir do vértice 3
    }
}
