package Classes_Matriz;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;

public class BellmanFordM extends GrafoM{
    private GrafoM grafo;

    public BellmanFordM(int numVertices, boolean ponderadoo) {
        super(numVertices, ponderadoo);
    }

    public void atribui(GrafoM grafo) {
        this.grafo = grafo;
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }

        matrizAdjacencia[origem][destino] = peso;
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
        BellmanFordM bellmanFordM = new BellmanFordM(5, true);

        bellmanFordM.adicionarAresta(0, 1, -1);
        bellmanFordM.adicionarAresta(0, 2, 4);
        bellmanFordM.adicionarAresta(1, 2, 3);
        bellmanFordM.adicionarAresta(1, 3, 2);
        bellmanFordM.adicionarAresta(1, 4, 2);
        bellmanFordM.adicionarAresta(3, 2, 5);
        bellmanFordM.adicionarAresta(3, 1, 1);
        bellmanFordM.adicionarAresta(4, 3, -3);

        bellmanFordM.mostrarGrafoM();

        bellmanFordM.atribui(bellmanFordM);
        try {
            int[] distancias = bellmanFordM.calcularCaminhosMinimos(0);

            System.out.println("\nDistâncias mínimas a partir do vértice 0:");
            for (int i = 0; i < distancias.length; i++) {
                System.out.println("Vértice " + i + ": " + distancias[i]);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
