package Classes_Matriz;

import java.util.LinkedList;
import java.util.Queue;

public class BFSM {
    private GrafoM grafoM;

    public BFSM(GrafoM grafoM) {
        this.grafoM = grafoM;
    }

    public BFSM(DigrafoM digrafoM) {
        this.grafoM = digrafoM;
    }

    public void buscaLargura(int verticeInicial) {
        if (verticeInicial < 0 || verticeInicial >= grafoM.numVertices) {
            throw new IllegalArgumentException("Vértice inicial inválido.");
        }

        boolean[] visitados = new boolean[grafoM.numVertices]; // Marca os vértices visitados
        Queue<Integer> fila = new LinkedList<>(); // Fila para os vértices a serem processados

        // Inicia a BFSM
        fila.add(verticeInicial);
        visitados[verticeInicial] = true;

        System.out.println("Busca em Largura a partir do vértice " + verticeInicial + ":");

        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll(); // Remove o próximo vértice da fila
            System.out.print(verticeAtual + " ");

            // Itera pelos vértices adjacentes
            for (int i = 0; i < grafoM.numVertices; i++) {
                // Verifica se há aresta e se o vértice ainda não foi visitado
                if (grafoM.matrizAdjacencia[verticeAtual][i] != 0 && !visitados[i]) {
                    fila.add(i);
                    visitados[i] = true;
                }
            }
        }

        System.out.println(); // Nova linha ao final da BFSM
    }

    public static void main(String[] args) {

        GrafoM grafoM = new GrafoM(5, false); // GrafoM não ponderado com 5 vértices
        grafoM.adicionarAresta(0, 1);
        grafoM.adicionarAresta(1, 2);
        grafoM.adicionarAresta(2, 3);
        grafoM.adicionarAresta(3, 4);
        System.out.println("");

        System.out.println("Grafo");
        BFSM bfs = new BFSM(grafoM);
        bfs.buscaLargura(2); // Busca em largura a partir do vértice 0

        DigrafoM digrafoM = new DigrafoM(5, false); // GrafoM não ponderado com 5 vértices
        digrafoM.adicionarAresta(0, 1);
        digrafoM.adicionarAresta(1, 2);
        digrafoM.adicionarAresta(2, 3);
        digrafoM.adicionarAresta(3, 4);
        System.out.println("");

        System.out.println("Digrafo");
        BFSM bfs2 = new BFSM(digrafoM);
        bfs2.buscaLargura(3); // Busca em largura a partir do vértice 0
    }
}
