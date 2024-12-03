package Classes_Matriz;
import java.util.*;

public class FordFulkerson {
    private int vertices;
    private int[][] grafo;

    public FordFulkerson(int vertices) {
        this.vertices = vertices;
        grafo = new int[vertices][vertices];
    }

    public void adicionarAresta(int origem, int destino, int capacidade) {
        grafo[origem][destino] = capacidade;
    }

    private boolean bfs(int[][] grafoResidual, int origem, int destino, int[] caminho) {
        boolean[] visitado = new boolean[vertices];
        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        visitado[origem] = true;
        caminho[origem] = -1;

        while (!fila.isEmpty()) {
            int u = fila.poll();

            for (int v = 0; v < vertices; v++) {
                if (!visitado[v] && grafoResidual[u][v] > 0) {
                    fila.add(v);
                    caminho[v] = u;
                    visitado[v] = true;

                    if (v == destino) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int encontrarFluxoMaximo(int origem, int destino) {
        int[][] grafoResidual = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            System.arraycopy(grafo[i], 0, grafoResidual[i], 0, vertices);
        }

        int[] caminho = new int[vertices];
        int fluxoMaximo = 0;

        while (bfs(grafoResidual, origem, destino, caminho)) {
            int fluxoCaminho = Integer.MAX_VALUE;

            for (int v = destino; v != origem; v = caminho[v]) {
                int u = caminho[v];
                fluxoCaminho = Math.min(fluxoCaminho, grafoResidual[u][v]);
            }

            for (int v = destino; v != origem; v = caminho[v]) {
                int u = caminho[v];
                grafoResidual[u][v] -= fluxoCaminho;
                grafoResidual[v][u] += fluxoCaminho;
            }

            fluxoMaximo += fluxoCaminho;
        }

        return fluxoMaximo;
    }

    public static void main(String[] args) {
        int vertices = 6;
        FordFulkerson fordFulkerson = new FordFulkerson(vertices);
    
        fordFulkerson.adicionarAresta(0, 1, 16);
        fordFulkerson.adicionarAresta(0, 2, 13);
        fordFulkerson.adicionarAresta(1, 2, 10);
        fordFulkerson.adicionarAresta(1, 3, 12);
        fordFulkerson.adicionarAresta(2, 1, 4);
        fordFulkerson.adicionarAresta(2, 4, 14);
        fordFulkerson.adicionarAresta(3, 2, 9);
        fordFulkerson.adicionarAresta(3, 5, 20);
        fordFulkerson.adicionarAresta(4, 3, 7);
        fordFulkerson.adicionarAresta(4, 5, 4);
    
        int origem = 0;
        int destino = 5;
        int fluxoMaximo = fordFulkerson.encontrarFluxoMaximo(origem, destino);
    
        System.out.println("O fluxo máximo do grafo é: " + fluxoMaximo);
    }
    
}

