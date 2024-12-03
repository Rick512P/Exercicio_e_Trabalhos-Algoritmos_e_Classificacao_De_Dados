package Classes_Matriz;
import java.util.*;

public class FloydWarshall {
    private int[][] grafo;
    private int vertices;

    public FloydWarshall(int vertices) {
        this.vertices = vertices;
        this.grafo = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(grafo[i], Integer.MAX_VALUE / 2); // Previne overflow
            grafo[i][i] = 0; // Distância para si mesmo é 0
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        grafo[origem][destino] = peso;
    }

    public void encontrarCaminhosMinimos() {
        int[][] distancia = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            System.arraycopy(grafo[i], 0, distancia[i], 0, vertices);
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distancia[i][j] > distancia[i][k] + distancia[k][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                    }
                }
            }
        }

        System.out.println("Matriz de distâncias mínimas:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print((distancia[i][j] == Integer.MAX_VALUE / 2 ? "INF" : distancia[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall floydWarshall = new FloydWarshall(4);
    
        floydWarshall.adicionarAresta(0, 1, 5);
        floydWarshall.adicionarAresta(0, 3, 10);
        floydWarshall.adicionarAresta(1, 2, 3);
        floydWarshall.adicionarAresta(2, 3, 1);
    
        floydWarshall.encontrarCaminhosMinimos();
    }
    
}
