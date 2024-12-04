package Classes_Matriz;

import java.util.Arrays;

public class DijkstraM {
    private GrafoM grafo;
    private boolean ehDigrafo; // Indica se é um Digrafo

    public DijkstraM(GrafoM grafo) {
        this.grafo = grafo;
        this.ehDigrafo = grafo instanceof DigrafoM; // Verifica se é DigrafoM ou GrafoM
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
            if (u == -1) break; // Todos os vértices restantes são inatingíveis
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
        System.out.println("===== GrafoM =====");
        GrafoM grafo = new GrafoM(5, true);
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 4, 5);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(2, 3, 4);
        grafo.adicionarAresta(4, 1, 3);
        grafo.adicionarAresta(4, 2, 9);
        grafo.adicionarAresta(4, 3, 2);

        grafo.mostrarGrafoM();

        DijkstraM dijkstraGrafo = new DijkstraM(grafo);
        int[] distanciasGrafo = dijkstraGrafo.calcularCaminhosMinimos(0);

        System.out.println("\nDistâncias mínimas a partir do vértice 0:");
        for (int i = 0; i < distanciasGrafo.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasGrafo[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasGrafo[i]));
        }

        System.out.println("\n===== DigrafoM =====");
        DigrafoM digrafo = new DigrafoM(5, true);
        digrafo.adicionarAresta(0, 1, 10);
        digrafo.adicionarAresta(0, 4, 5);
        digrafo.adicionarAresta(1, 2, 1);
        digrafo.adicionarAresta(2, 3, 4);
        digrafo.adicionarAresta(4, 1, 3);
        digrafo.adicionarAresta(4, 2, 9);
        digrafo.adicionarAresta(4, 3, 2);

        digrafo.mostrarGrafoM();

        DijkstraM dijkstraDigrafo = new DijkstraM(digrafo);
        int[] distanciasDigrafo = dijkstraDigrafo.calcularCaminhosMinimos(0);

        System.out.println("\nDistâncias mínimas a partir do vértice 0:");
        for (int i = 0; i < distanciasDigrafo.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasDigrafo[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasDigrafo[i]));
        }
    }
}
