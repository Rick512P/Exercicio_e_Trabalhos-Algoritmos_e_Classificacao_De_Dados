package Classes_Matriz;

import java.util.Arrays;

public class BellmanFordM {
    private GrafoM grafo;

    public BellmanFordM(GrafoM grafo) {
        this.grafo = grafo;
    }

    public int[] calcularCaminhosMinimos(int origem) {
        int numVertices = grafo.numVertices;
        int[] distancias = new int[numVertices];
        final int INFINITO = Integer.MAX_VALUE;

        // Inicializa as distâncias
        Arrays.fill(distancias, INFINITO);
        distancias[origem] = 0;

        // Relaxa todas as arestas (V-1) vezes
        for (int i = 0; i < numVertices - 1; i++) {
            for (int u = 0; u < numVertices; u++) {
                for (int v = 0; v < numVertices; v++) {
                    if (grafo.matrizAdjacencia[u][v] != 0 && distancias[u] != INFINITO) {
                        int novaDistancia = distancias[u] + grafo.matrizAdjacencia[u][v];
                        if (novaDistancia < distancias[v]) {
                            distancias[v] = novaDistancia;
                        }
                    }
                }
            }
        }

        // Verifica a presença de ciclos de peso negativo
        for (int u = 0; u < numVertices; u++) {
            for (int v = 0; v < numVertices; v++) {
                if (grafo.matrizAdjacencia[u][v] != 0 && distancias[u] != INFINITO) {
                    int novaDistancia = distancias[u] + grafo.matrizAdjacencia[u][v];
                    if (novaDistancia < distancias[v]) {
                        throw new IllegalStateException("O grafo contém ciclos de peso negativo.");
                    }
                }
            }
        }

        return distancias;
    }

    public static void main(String[] args) {
        // Exemplo de grafo ponderado com pesos negativos
        GrafoM grafo = new GrafoM(5, true);
        grafo.adicionarAresta(0, 1, -1);
        grafo.adicionarAresta(0, 2, 4);
        grafo.adicionarAresta(1, 2, 3);
        grafo.adicionarAresta(1, 3, 2);
        grafo.adicionarAresta(1, 4, 2);
        grafo.adicionarAresta(3, 2, 5);
        grafo.adicionarAresta(3, 1, 1);
        grafo.adicionarAresta(4, 3, -3);

        grafo.mostrarGrafoM();

        BellmanFordM bellmanFord = new BellmanFordM(grafo);
        try {
            int[] distancias = bellmanFord.calcularCaminhosMinimos(0);

            System.out.println("\nDistâncias mínimas a partir do vértice 0:");
            for (int i = 0; i < distancias.length; i++) {
                System.out.println("Vértice " + i + ": " + distancias[i]);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
