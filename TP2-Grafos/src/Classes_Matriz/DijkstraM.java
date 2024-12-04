package Classes_Matriz;

import java.util.Arrays;

public class DijkstraM {
    private GrafoM grafo;

    public DijkstraM(GrafoM grafo) {
        this.grafo = grafo;
    }

    public int[] calcularCaminhosMinimos(int origem) {
        int numVertices = grafo.numVertices;
        int[] distancias = new int[numVertices]; // Distâncias mínimas
        boolean[] visitados = new boolean[numVertices]; // Vértices visitados

        // Inicializa as distâncias com infinito e marca todos os vértices como não visitados
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        // Processa todos os vértices
        for (int i = 0; i < numVertices; i++) {
            int u = obterVerticeMaisProximo(distancias, visitados); // Obtém o vértice mais próximo não visitado
            visitados[u] = true; // Marca o vértice como visitado

            // Atualiza as distâncias para os vértices adjacentes
            for (int v = 0; v < numVertices; v++) {
                if (!visitados[v] && grafo.matrizAdjacencia[u][v] != 0 // Existe uma aresta
                        && distancias[u] != Integer.MAX_VALUE // A distância até u é finita
                        && distancias[u] + grafo.matrizAdjacencia[u][v] < distancias[v]) { // Encontra um caminho mais curto
                    distancias[v] = distancias[u] + grafo.matrizAdjacencia[u][v];
                }
            }
        }

        return distancias;
    }

    // Método auxiliar para encontrar o vértice mais próximo que ainda não foi visitado
    private int obterVerticeMaisProximo(int[] distancias, boolean[] visitados) {
        int minDistancia = Integer.MAX_VALUE;
        int minIndice = -1;

        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] < minDistancia) {
                minDistancia = distancias[i];
                minIndice = i;
            }
        }

        return minIndice;
    }

    public static void main(String[] args) {
        // Exemplo de grafo ponderado
        GrafoM grafo = new GrafoM(5, true);
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 4, 5);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(2, 3, 4);
        grafo.adicionarAresta(4, 1, 3);
        grafo.adicionarAresta(4, 2, 9);
        grafo.adicionarAresta(4, 3, 2);

        grafo.mostrarGrafoM();

        DijkstraM dijkstra = new DijkstraM(grafo);
        int[] distancias = dijkstra.calcularCaminhosMinimos(0);

        System.out.println("\nDistâncias mínimas a partir do vértice 0:");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("Vértice " + i + ": " + distancias[i]);
        }
    }
}
