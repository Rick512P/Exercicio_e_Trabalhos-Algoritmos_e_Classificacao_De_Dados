package Classes_Matriz;

import java.util.Arrays;

public class FloydWarshallM {
    private int[][] grafo;
    private int vertices;
    private boolean ehDigrafo; // Indica se é um Digrafo

    public FloydWarshallM(int vertices, boolean ehDigrafo) {
        this.vertices = vertices;
        this.ehDigrafo = ehDigrafo;
        this.grafo = new int[vertices][vertices];

        // Inicializa a matriz de adjacência
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(grafo[i], Integer.MAX_VALUE / 2); // Previne overflow
            grafo[i][i] = 0; // Distância para si mesmo é 0
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        grafo[origem][destino] = peso;
        if (!ehDigrafo) {
            // Para grafos não direcionados, adiciona a aresta na direção oposta
            grafo[destino][origem] = peso;
        }
    }

    public void encontrarCaminhosMinimos() {
        int[][] distancia = new int[vertices][vertices];

        // Copia a matriz de adjacência para a matriz de distâncias
        for (int i = 0; i < vertices; i++) {
            System.arraycopy(grafo[i], 0, distancia[i], 0, vertices);
        }

        // Floyd-Warshall: Atualiza as distâncias
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distancia[i][k] + distancia[k][j] < distancia[i][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                    }
                }
            }
        }

        // Exibe a matriz de distâncias mínimas
        System.out.println("Matriz de distâncias mínimas:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print((distancia[i][j] == Integer.MAX_VALUE / 2 ? "INF" : distancia[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("===== GrafoM =====");
        FloydWarshallM grafo = new FloydWarshallM(4, false); // Grafo não direcionado
        grafo.adicionarAresta(0, 1, 5);
        grafo.adicionarAresta(0, 3, 10);
        grafo.adicionarAresta(1, 2, 3);
        grafo.adicionarAresta(2, 3, 1);

        grafo.encontrarCaminhosMinimos();

        System.out.println("\n===== DigrafoM =====");
        FloydWarshallM digrafo = new FloydWarshallM(4, true); // Digrafo
        digrafo.adicionarAresta(0, 1, 5);
        digrafo.adicionarAresta(0, 3, 10);
        digrafo.adicionarAresta(1, 2, 3);
        digrafo.adicionarAresta(2, 3, 1);

        digrafo.encontrarCaminhosMinimos();
    }
}
