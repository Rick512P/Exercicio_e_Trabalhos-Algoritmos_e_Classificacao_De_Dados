package Classes_LE;

import java.util.Arrays;

import Classes_LE.GrafoL.Aresta;

public class FloydWarshallL extends GrafoL{
    private GrafoL grafo;

    public FloydWarshallL(int numVertices, boolean ponderado) {
        super(numVertices, ponderado);
    }

    public void atribui(GrafoL grafo){
        this.grafo = grafo;
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
        listaAdjacencia.get(origem).add(new Aresta(origem, destino, peso));
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
        FloydWarshallL floydWarshall = new FloydWarshallL(4, true);
        floydWarshall.adicionarAresta(0, 1, 3);
        floydWarshall.adicionarAresta(0, 2, 10);
        floydWarshall.adicionarAresta(1, 2, 2);
        floydWarshall.adicionarAresta(1, 3, 8);
        floydWarshall.adicionarAresta(2, 3, -5);

        floydWarshall.atribui(floydWarshall);
        try {
            int[][] distancias = floydWarshall.calcularCaminhosMinimos();
            System.out.println("Matriz de distâncias mínimas:");
            for (int i = 0; i < distancias.length; i++) {
                for (int j = 0; j < distancias[i].length; j++) {
                    if (distancias[i][j] == Integer.MAX_VALUE) {
                        System.out.print("INF ");
                    } else {
                        System.out.print(distancias[i][j] + " ");
                    }
                }
                System.out.println();
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
