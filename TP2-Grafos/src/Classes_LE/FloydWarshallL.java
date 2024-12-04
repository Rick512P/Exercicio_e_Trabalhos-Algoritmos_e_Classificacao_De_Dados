package Classes_LE;

import java.util.Arrays;

public class FloydWarshallL {
    private GrafoL grafo;

    public FloydWarshallL(GrafoL grafo) {
        this.grafo = grafo;
    }

    public int[][] calcularCaminhosMinimos() {
        final int INFINITO = Integer.MAX_VALUE;
        int numVertices = grafo.numVertices;

        // Inicializa a matriz de distâncias
        int[][] distancias = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(distancias[i], INFINITO);
            distancias[i][i] = 0; // Distância do vértice para ele mesmo é 0
        }

        // Preenche a matriz inicial com os pesos das arestas
        for (int u = 0; u < numVertices; u++) {
            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(u)) {
                distancias[u][aresta.destino] = aresta.peso;
            }
        }

        // Floyd-Warshall: Atualiza as distâncias
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancias[i][k] != INFINITO && distancias[k][j] != INFINITO &&
                            distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }

        // Verifica ciclos de peso negativo
        for (int i = 0; i < numVertices; i++) {
            if (distancias[i][i] < 0) {
                throw new IllegalStateException("O grafo contém ciclos de peso negativo.");
            }
        }

        return distancias;
    }

    public static void main(String[] args) {
        // Exemplo com GrafoL
        System.out.println("\n===== GrafoL =====");
        GrafoL grafoL = new GrafoL(4, true);
        grafoL.adicionarAresta(0, 1, 3);
        grafoL.adicionarAresta(0, 2, 10);
        grafoL.adicionarAresta(1, 2, 2);
        grafoL.adicionarAresta(1, 3, 8);
        grafoL.adicionarAresta(2, 3, -5);

        FloydWarshallL floydWarshallGrafo = new FloydWarshallL(grafoL);
        try {
            int[][] distanciasGrafo = floydWarshallGrafo.calcularCaminhosMinimos();
            System.out.println("Matriz de distâncias mínimas para GrafoL:");
            printarMatriz(distanciasGrafo);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Exemplo com DigrafoL
        System.out.println("\n===== DigrafoL =====");
        DigrafoL digrafoL = new DigrafoL(4, true);
        digrafoL.adicionarAresta(0, 1, 3);
        digrafoL.adicionarAresta(0, 2, 10);
        digrafoL.adicionarAresta(1, 2, 2);
        digrafoL.adicionarAresta(1, 3, 8);
        digrafoL.adicionarAresta(2, 3, -5);

        FloydWarshallL floydWarshallDigrafo = new FloydWarshallL(digrafoL);
        try {
            int[][] distanciasDigrafo = floydWarshallDigrafo.calcularCaminhosMinimos();
            System.out.println("Matriz de distâncias mínimas para DigrafoL:");
            printarMatriz(distanciasDigrafo);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printarMatriz(int[][] matriz) {
        final int INFINITO = Integer.MAX_VALUE;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == INFINITO) {
                    System.out.print("INF ");
                } else {
                    System.out.printf("%3d ", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }
}
