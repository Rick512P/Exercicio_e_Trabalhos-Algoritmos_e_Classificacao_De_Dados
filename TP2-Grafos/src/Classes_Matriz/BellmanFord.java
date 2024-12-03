package Classes_Matriz;
import java.util.*;

public class BellmanFord {
    class Aresta {
        int origem, destino, peso;

        public Aresta(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }
    }

    private int vertices;
    private List<Aresta> arestas;

    public BellmanFord(int vertices) {
        this.vertices = vertices;
        this.arestas = new ArrayList<>();
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        arestas.add(new Aresta(origem, destino, peso));
    }

    public void encontrarCaminhoMinimo(int origem) {
        int[] distancia = new int[vertices];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        for (int i = 1; i < vertices; i++) {
            for (Aresta aresta : arestas) {
                if (distancia[aresta.origem] != Integer.MAX_VALUE &&
                    distancia[aresta.origem] + aresta.peso < distancia[aresta.destino]) {
                    distancia[aresta.destino] = distancia[aresta.origem] + aresta.peso;
                }
            }
        }

        for (Aresta aresta : arestas) {
            if (distancia[aresta.origem] != Integer.MAX_VALUE &&
                distancia[aresta.origem] + aresta.peso < distancia[aresta.destino]) {
                System.out.println("O grafo contém ciclo negativo.");
                return;
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Para " + i + ": " + distancia[i]);
        }
    }

    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord(5);
    
        bellmanFord.adicionarAresta(0, 1, -1);
        bellmanFord.adicionarAresta(0, 2, 4);
        bellmanFord.adicionarAresta(1, 2, 3);
        bellmanFord.adicionarAresta(1, 3, 2);
        bellmanFord.adicionarAresta(1, 4, 2);
        bellmanFord.adicionarAresta(3, 2, 5);
        bellmanFord.adicionarAresta(3, 1, 1);
        bellmanFord.adicionarAresta(4, 3, -3);
    
        bellmanFord.encontrarCaminhoMinimo(0);
    }
    
}
