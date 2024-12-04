package Classes_LE;

import java.util.LinkedList;

public class FordFulkersonL {
    private GrafoL grafo;
    private int[][] capacidade; // Capacidade de cada aresta no grafo

    public FordFulkersonL(GrafoL grafo) {
        this.grafo = grafo;
        this.capacidade = new int[grafo.numVertices][grafo.numVertices];

        // Inicializa a matriz de capacidades a partir da lista de adjacência
        for (int u = 0; u < grafo.numVertices; u++) {
            for (GrafoL.Aresta aresta : grafo.listaAdjacencia.get(u)) {
                capacidade[u][aresta.destino] = aresta.peso;
            }
        }
    }

    public int calcularFluxoMaximo(int fonte, int sorvedouro) {
        int[][] fluxoResidual = new int[grafo.numVertices][grafo.numVertices];
        int fluxoMaximo = 0;

        // Copia as capacidades iniciais para o grafo residual
        for (int i = 0; i < grafo.numVertices; i++) {
            System.arraycopy(capacidade[i], 0, fluxoResidual[i], 0, grafo.numVertices);
        }

        int[] caminho = new int[grafo.numVertices];

        // Enquanto houver um caminho aumentante
        while (existeCaminhoAumentante(fluxoResidual, fonte, sorvedouro, caminho)) {
            // Encontra o fluxo mínimo no caminho aumentante encontrado
            int fluxoCaminho = Integer.MAX_VALUE;
            for (int v = sorvedouro; v != fonte; v = caminho[v]) {
                int u = caminho[v];
                fluxoCaminho = Math.min(fluxoCaminho, fluxoResidual[u][v]);
            }

            // Atualiza as capacidades residuais
            for (int v = sorvedouro; v != fonte; v = caminho[v]) {
                int u = caminho[v];
                fluxoResidual[u][v] -= fluxoCaminho;
                fluxoResidual[v][u] += fluxoCaminho;
            }

            // Incrementa o fluxo máximo
            fluxoMaximo += fluxoCaminho;
        }

        return fluxoMaximo;
    }

    private boolean existeCaminhoAumentante(int[][] fluxoResidual, int fonte, int sorvedouro, int[] caminho) {
        boolean[] visitados = new boolean[grafo.numVertices];
        LinkedList<Integer> fila = new LinkedList<>();

        fila.add(fonte);
        visitados[fonte] = true;
        caminho[fonte] = -1;

        while (!fila.isEmpty()) {
            int u = fila.poll();

            for (int v = 0; v < grafo.numVertices; v++) {
                if (!visitados[v] && fluxoResidual[u][v] > 0) {
                    fila.add(v);
                    caminho[v] = u;
                    visitados[v] = true;

                    // Se chegou ao sorvedouro, retorna verdadeiro
                    if (v == sorvedouro) {
                        return true;
                    }
                }
            }
        }

        return false; // Não há caminho aumentante
    }

    public static void main(String[] args) {
        GrafoL grafo = new GrafoL(6, true);
        grafo.adicionarAresta(0, 1, 16);
        grafo.adicionarAresta(0, 2, 13);
        grafo.adicionarAresta(1, 2, 10);
        grafo.adicionarAresta(1, 3, 12);
        grafo.adicionarAresta(2, 1, 4);
        grafo.adicionarAresta(2, 4, 14);
        grafo.adicionarAresta(3, 2, 9);
        grafo.adicionarAresta(3, 5, 20);
        grafo.adicionarAresta(4, 3, 7);
        grafo.adicionarAresta(4, 5, 4);

        FordFulkersonL fordFulkerson = new FordFulkersonL(grafo);
        int fluxoMaximo = fordFulkerson.calcularFluxoMaximo(0, 5);

        System.out.println("O fluxo máximo é: " + fluxoMaximo);
    }
}
