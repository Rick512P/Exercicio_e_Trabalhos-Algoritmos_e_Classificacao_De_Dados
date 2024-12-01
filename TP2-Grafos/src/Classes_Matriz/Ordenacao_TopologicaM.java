package Classes_Matriz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ordenacao_TopologicaM {
    private GrafoM grafo;

    public Ordenacao_TopologicaM(GrafoM grafo) {
        this.grafo = grafo;
    }

    public ArrayList<Integer> ordenarTopologicamente() {
        int[] grauEntrada = new int[grafo.numVertices]; // Armazena o grau de entrada de cada vértice
        ArrayList<Integer> ordenacao = new ArrayList<>();
        Queue<Integer> fila = new LinkedList<>();

        // Calcula o grau de entrada de cada vértice
        for (int i = 0; i < grafo.numVertices; i++) {
            for (int j = 0; j < grafo.numVertices; j++) {
                if (grafo.matrizAdjacencia[j][i] != 0) {
                    grauEntrada[i]++;
                }
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
            for (int i = 0; i < grafo.numVertices; i++) {
                if (grafo.matrizAdjacencia[vertice][i] != 0) {
                    grauEntrada[i]--;
                    if (grauEntrada[i] == 0) {
                        fila.add(i);
                    }
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
        // Exemplo de uso
        GrafoM grafo = new GrafoM(5, false);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.mostrarGrafoM();
        System.out.println("");

        System.out.println("Grafo");
        Ordenacao_TopologicaM ordenacaog = new Ordenacao_TopologicaM(grafo);
        try {
            ArrayList<Integer> resultadog = ordenacaog.ordenarTopologicamente();
            System.out.println("Ordenação Topológica: " + resultadog);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("");

        System.out.println("Digrafo");
        DigrafoM digrafo = new DigrafoM(5, false);
        digrafo.adicionarAresta(0, 2, 10);
        digrafo.adicionarAresta(2, 1, 21);
        digrafo.adicionarAresta(2, 3, 13);
        digrafo.adicionarAresta(3, 4, 143);
        //digrafo.adicionarAresta(4, 0, 143);
        digrafo.mostrarGrafoM();

        Ordenacao_TopologicaM ordenacaod = new Ordenacao_TopologicaM(digrafo);
        try {
            ArrayList<Integer> resultadod = ordenacaod.ordenarTopologicamente();
            System.out.println("Ordenação Topológica: " + resultadod);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
