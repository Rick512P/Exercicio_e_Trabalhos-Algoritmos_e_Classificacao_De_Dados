package Classes_LE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalL {
    private GrafoL grafo;

    public KruskalL(GrafoL grafo) {
        this.grafo = grafo;
    }

    public List<GrafoL.Aresta> obterMST() {
        List<GrafoL.Aresta> todasArestas = new ArrayList<>();
        List<GrafoL.Aresta> mst = new ArrayList<>();

        // Adiciona todas as arestas do grafo à lista
        for (int i = 0; i < grafo.numVertices; i++) {
            todasArestas.addAll(grafo.listaAdjacencia.get(i));
        }

        // Ordena as arestas pelo peso
        Collections.sort(todasArestas, (a, b) -> Integer.compare(a.peso, b.peso));

        // Inicializa a estrutura de conjuntos disjuntos
        UnionFind uf = new UnionFind(grafo.numVertices);

        // Processa cada aresta em ordem crescente de peso
        for (GrafoL.Aresta aresta : todasArestas) {
            int origem = aresta.origem;
            int destino = aresta.destino;

            // Verifica se a aresta forma um ciclo
            if (uf.find(origem) != uf.find(destino)) {
                mst.add(aresta);
                uf.union(origem, destino);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        GrafoL grafo = new GrafoL(6, true);
        grafo.adicionarAresta(0, 1, 4);
        grafo.adicionarAresta(0, 2, 4);
        grafo.adicionarAresta(1, 2, 2);
        grafo.adicionarAresta(1, 3, 5);
        grafo.adicionarAresta(2, 3, 5);
        grafo.adicionarAresta(3, 4, 3);

        KruskalL kruskal = new KruskalL(grafo);
        List<GrafoL.Aresta> mst = kruskal.obterMST();

        System.out.println("Árvore Geradora Mínima (Kruskal):");
        for (GrafoL.Aresta aresta : mst) {
            System.out.println(aresta.origem + " -> " + aresta.destino + " : " + aresta.peso);
        }
    }
}

// Classe Union-Find para conjuntos disjuntos
class UnionFind {
    private int[] pai;
    private int[] rank;

    public UnionFind(int tamanho) {
        pai = new int[tamanho];
        rank = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            pai[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (pai[x] != x) {
            pai[x] = find(pai[x]); // Compressão de caminho
        }
        return pai[x];
    }

    public void union(int x, int y) {
        int raizX = find(x);
        int raizY = find(y);

        if (raizX != raizY) {
            if (rank[raizX] > rank[raizY]) {
                pai[raizY] = raizX;
            } else if (rank[raizX] < rank[raizY]) {
                pai[raizX] = raizY;
            } else {
                pai[raizY] = raizX;
                rank[raizX]++;
            }
        }
    }
}
