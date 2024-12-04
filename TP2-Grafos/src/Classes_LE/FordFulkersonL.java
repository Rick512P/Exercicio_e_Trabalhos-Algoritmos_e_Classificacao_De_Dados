package Classes_LE;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonL {
    private GrafoL grafo;
    private int[][] capacidadeResidual;

    public FordFulkersonL(GrafoL grafo) {
        this.grafo = grafo;
        inicializarCapacidades();
    }

    private void inicializarCapacidades() {
        int numVertices = grafo.numVertices;
        capacidadeResidual = new int[numVertices][numVertices];

        for (int u = 0; u < numVertices; u++) {
            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(u)) {
                capacidadeResidual[u][aresta.destino] = aresta.peso;
                // Adiciona arestas reversas para GrafoL (não direcionado)
                if (!(grafo instanceof DigrafoL)) {
                    capacidadeResidual[aresta.destino][u] = aresta.peso;
                }
            }
        }
    }

    public int calcularFluxoMaximo(int origem, int destino) {
        int numVertices = grafo.numVertices;
        int fluxoMaximo = 0;
        int[] caminho = new int[numVertices];

        // Enquanto houver um caminho com capacidade residual positiva
        while (bfs(origem, destino, caminho)) {
            // Determina o fluxo ao longo do caminho encontrado
            int fluxoCaminho = Integer.MAX_VALUE;
            for (int v = destino; v != origem; v = caminho[v]) {
                int u = caminho[v];
                fluxoCaminho = Math.min(fluxoCaminho, capacidadeResidual[u][v]);
            }

            // Atualiza as capacidades residuais
            for (int v = destino; v != origem; v = caminho[v]) {
                int u = caminho[v];
                capacidadeResidual[u][v] -= fluxoCaminho;
                capacidadeResidual[v][u] += fluxoCaminho;
            }

            // Incrementa o fluxo máximo pelo fluxo do caminho encontrado
            fluxoMaximo += fluxoCaminho;
        }

        return fluxoMaximo;
    }

    private boolean bfs(int origem, int destino, int[] caminho) {
        boolean[] visitado = new boolean[grafo.numVertices];
        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        visitado[origem] = true;
        caminho[origem] = -1;

        while (!fila.isEmpty()) {
            int u = fila.poll();

            for (int v = 0; v < grafo.numVertices; v++) {
                if (!visitado[v] && capacidadeResidual[u][v] > 0) {
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

    public static void main(String[] args) {
        // Exemplo com GrafoL
        System.out.println("\n===== GrafoL =====");
        GrafoL grafo = new GrafoL(6, true);
        grafo.adicionarAresta(0, 1, 16);
        grafo.adicionarAresta(0, 2, 13);
        grafo.adicionarAresta(1, 2, 10);
        grafo.adicionarAresta(1, 3, 12);
        grafo.adicionarAresta(2, 4, 14);
        grafo.adicionarAresta(3, 4, 7);
        grafo.adicionarAresta(4, 5, 4);

        grafo.mostrarGrafoL();

        FordFulkersonL fordFulkersonGrafo = new FordFulkersonL(grafo);
        int fluxoMaximoGrafo = fordFulkersonGrafo.calcularFluxoMaximo(0, 5);
        System.out.println("Fluxo Máximo no GrafoL de 0 para 5: " + fluxoMaximoGrafo);

        // Exemplo com DigrafoL
        System.out.println("\n===== DigrafoL =====");
        DigrafoL digrafo = new DigrafoL(6, true);
        digrafo.adicionarAresta(0, 1, 16);
        digrafo.adicionarAresta(0, 2, 13);
        digrafo.adicionarAresta(1, 2, 10);
        digrafo.adicionarAresta(1, 3, 12);
        digrafo.adicionarAresta(2, 4, 14);
        digrafo.adicionarAresta(3, 4, 7);
        digrafo.adicionarAresta(4, 5, 4);

        digrafo.mostrarGrafoL();

        FordFulkersonL fordFulkersonDigrafo = new FordFulkersonL(digrafo);
        int fluxoMaximoDigrafo = fordFulkersonDigrafo.calcularFluxoMaximo(0, 5);
        System.out.println("Fluxo Máximo no DigrafoL de 0 para 5: " + fluxoMaximoDigrafo);
    }
}
