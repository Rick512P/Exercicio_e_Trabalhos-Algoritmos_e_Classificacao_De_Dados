package Classes_LE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Classes_LE.GrafoL.Aresta;

public class BellmanFordL extends GrafoL {
    private GrafoL grafo;
    private boolean ehDigrafo; // Indica se é um Digrafo

    public BellmanFordL(int numVertices, boolean ponderado) {
        super(numVertices, ponderado);
    }

    public void atribui(GrafoL grafo) {
        this.grafo = grafo;
        this.ehDigrafo = grafo instanceof DigrafoL; // Define se é DigrafoL ou GrafoL
    }

    @Override
    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Vértices inválidos.");
        }
        listaAdjacencia.get(origem).add(new Aresta(origem, destino, peso));
        if (!ehDigrafo) {
            // Adiciona apenas para grafos não direcionados
            listaAdjacencia.get(destino).add(new Aresta(destino, origem, peso));
        }
    }

    public int[] calcularCaminhoMinimo(int origem) {
        int[] distancias = new int[grafo.numVertices];
        final int INFINITO = Integer.MAX_VALUE;

        // Inicializa as distâncias
        for (int i = 0; i < grafo.numVertices; i++) {
            distancias[i] = INFINITO;
        }
        distancias[origem] = 0;

        // Cria uma lista única de arestas
        List<Aresta> arestasUnicas = obterArestasUnicas();

        // Relaxa todas as arestas (V-1) vezes
        for (int i = 0; i < grafo.numVertices - 1; i++) {
            for (Aresta aresta : arestasUnicas) {
                int u = aresta.origem;
                int v = aresta.destino;
                int peso = aresta.peso;

                // Verifica se é possível relaxar a aresta
                if (distancias[u] != INFINITO && distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                }
            }
        }

        // Verifica ciclos de peso negativo
        boolean cicloNegativoDetectado = false;
        for (Aresta aresta : arestasUnicas) {
            int u = aresta.origem;
            int v = aresta.destino;
            int peso = aresta.peso;

            // Se ainda houver uma aresta que pode ser relaxada, há um ciclo negativo
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

    private List<Aresta> obterArestasUnicas() {
        Set<String> visitadas = new HashSet<>();
        List<Aresta> arestasUnicas = new ArrayList<>();

        for (int u = 0; u < grafo.numVertices; u++) {
            for (Aresta aresta : grafo.listaAdjacencia.get(u)) {
                String chave = ehDigrafo
                        ? u + "->" + aresta.destino // Digrafos consideram direção
                        : Math.min(aresta.origem, aresta.destino) + "-" + Math.max(aresta.origem, aresta.destino);
                if (!visitadas.contains(chave)) {
                    arestasUnicas.add(aresta);
                    visitadas.add(chave);
                }
            }
        }
        return arestasUnicas;
    }

    public static void main(String[] args) {
        System.out.println("===== GrafoL =====");
        BellmanFordL bellmanFordGrafo = new BellmanFordL(5, true);
        bellmanFordGrafo.adicionarAresta(0, 1, -1);
        bellmanFordGrafo.adicionarAresta(0, 2, 4);
        bellmanFordGrafo.adicionarAresta(1, 2, 3);
        bellmanFordGrafo.adicionarAresta(1, 3, 2);
        bellmanFordGrafo.adicionarAresta(1, 4, 2);
        bellmanFordGrafo.adicionarAresta(3, 2, 5);
        bellmanFordGrafo.adicionarAresta(3, 1, 1);
        bellmanFordGrafo.adicionarAresta(4, 3, -3);

        bellmanFordGrafo.atribui(bellmanFordGrafo);
        int[] distanciasGrafo = bellmanFordGrafo.calcularCaminhoMinimo(0);

        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distanciasGrafo.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasGrafo[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasGrafo[i]));
        }

        System.out.println("\n===== DigrafoL =====");
        DigrafoL digrafo = new DigrafoL(5, true);
        BellmanFordL bellmanFordDigrafo = new BellmanFordL(5, true);

        bellmanFordDigrafo.atribui(digrafo);
        digrafo.adicionarAresta(0, 1, -1);
        digrafo.adicionarAresta(0, 2, 4);
        digrafo.adicionarAresta(1, 2, 3);
        digrafo.adicionarAresta(1, 3, 2);
        digrafo.adicionarAresta(1, 4, 2);
        digrafo.adicionarAresta(3, 2, 5);
        digrafo.adicionarAresta(3, 1, 1);
        digrafo.adicionarAresta(4, 3, -3);

        int[] distanciasDigrafo = bellmanFordDigrafo.calcularCaminhoMinimo(0);

        System.out.println("Distâncias a partir do vértice 0:");
        for (int i = 0; i < distanciasDigrafo.length; i++) {
            System.out.println("Vértice " + i + ": " + (distanciasDigrafo[i] == Integer.MAX_VALUE ? "INFINITO" : distanciasDigrafo[i]));
        }
    }
}
