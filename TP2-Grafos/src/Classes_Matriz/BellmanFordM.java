package Classes_Matriz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BellmanFordM extends GrafoM {
    private GrafoM grafo;
    private boolean ehDigrafo; // Indica se é um Digrafo

    public BellmanFordM(int numVertices, boolean ponderado) {
        super(numVertices, ponderado);
    }

    public void atribui(GrafoM grafo) {
        this.grafo = grafo;
        this.ehDigrafo = grafo instanceof DigrafoM; // Define se é DigrafoM ou GrafoM
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
        matrizAdjacencia[origem][destino] = peso;
        if (!ehDigrafo) {
            matrizAdjacencia[destino][origem] = peso; // Adiciona para o GrafoM
        }
    }

    public int[] calcularCaminhosMinimos(int origem) {
        int[] distancias = new int[grafo.numVertices];
        final int INFINITO = Integer.MAX_VALUE;

        // Inicializa as distâncias
        for (int i = 0; i < grafo.numVertices; i++) {
            distancias[i] = INFINITO;
        }
        distancias[origem] = 0;

        // Obter todas as arestas únicas
        List<ArestaM> arestasUnicas = obterArestasUnicas();

        // Relaxa todas as arestas (V-1) vezes
        for (int i = 0; i < grafo.numVertices - 1; i++) {
            for (ArestaM aresta : arestasUnicas) {
                int u = aresta.origem;
                int v = aresta.destino;
                int peso = aresta.peso;

                // Relaxamento
                if (distancias[u] != INFINITO && distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                }
            }
        }

        // Verifica ciclos de peso negativo
        boolean cicloNegativoDetectado = false;
        for (ArestaM aresta : arestasUnicas) {
            int u = aresta.origem;
            int v = aresta.destino;
            int peso = aresta.peso;

            if (distancias[u] != INFINITO && distancias[u] + peso < distancias[v]) {
                cicloNegativoDetectado = true;
                System.out.println("Ciclo de peso negativo detectado: " + u + " -> " + v);
            }
        }

        if (cicloNegativoDetectado) {
            System.out.println("Aviso: O " + (ehDigrafo ? "Digrafo" : "Grafo") + " contém ciclos de peso negativo, os resultados podem não ser válidos.");
        }

        return distancias;
    }

    private List<ArestaM> obterArestasUnicas() {
        Set<String> visitadas = new HashSet<>();
        List<ArestaM> arestasUnicas = new ArrayList<>();
    
        for (int u = 0; u < grafo.numVertices; u++) {
            for (int v = 0; v < grafo.numVertices; v++) {
                if (grafo.matrizAdjacencia[u][v] != 0) {
                    String chave = ehDigrafo
                            ? u + "->" + v // Digrafos consideram direção
                            : Math.min(u, v) + "-" + Math.max(u, v);
                    if (!visitadas.contains(chave)) {
                        arestasUnicas.add(new ArestaM(u, v, grafo.matrizAdjacencia[u][v]));
                        visitadas.add(chave);
                    }
                }
            }
        }
        return arestasUnicas;
    }
    

    // Classe auxiliar para representar uma aresta
    private static class ArestaM {
        int origem;
        int destino;
        int peso;

        public ArestaM(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== GrafoM =====");
        BellmanFordM bellmanFordGrafo = new BellmanFordM(5, true);
        bellmanFordGrafo.adicionarAresta(0, 1, -1);
        bellmanFordGrafo.adicionarAresta(0, 2, 4);
        bellmanFordGrafo.adicionarAresta(1, 2, 3);
        bellmanFordGrafo.adicionarAresta(1, 3, 2);
        bellmanFordGrafo.adicionarAresta(1, 4, 2);
        bellmanFordGrafo.adicionarAresta(3, 2, 5);
        bellmanFordGrafo.adicionarAresta(3, 1, 1);
        bellmanFordGrafo.adicionarAresta(4, 3, -3);

        bellmanFordGrafo.atribui(bellmanFordGrafo);
        int[] distanciasGrafo = bellmanFordGrafo.calcularCaminhosMinimos(0);

        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distanciasGrafo.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasGrafo[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasGrafo[i]));
        }

        System.out.println("\n===== DigrafoM =====");
        DigrafoM digrafo = new DigrafoM(5, true);
        BellmanFordM bellmanFordDigrafo = new BellmanFordM(5, true);

        bellmanFordDigrafo.atribui(digrafo);
        digrafo.adicionarAresta(0, 1, -1);
        digrafo.adicionarAresta(0, 2, 4);
        digrafo.adicionarAresta(1, 2, 3);
        digrafo.adicionarAresta(1, 3, 2);
        digrafo.adicionarAresta(1, 4, 2);
        digrafo.adicionarAresta(3, 2, 5);
        digrafo.adicionarAresta(3, 1, 1);
        digrafo.adicionarAresta(4, 3, -3);

        int[] distanciasDigrafo = bellmanFordDigrafo.calcularCaminhosMinimos(0);

        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distanciasDigrafo.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasDigrafo[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasDigrafo[i]));
        }
    }
}
