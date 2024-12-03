package Classes_Matriz;

import java.util.*;

public class ArvoreGM_Kruskal {
    class Aresta implements Comparable<Aresta> {
        int origem, destino, peso;

        public Aresta(int origem, int destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }

        public int compareTo(Aresta outra) {
            return this.peso - outra.peso;
        }
    }

    class Subconjunto {
        int pai, rank;
    }

    private int vertices;
    private List<Aresta> arestas;

    public ArvoreGM_Kruskal(int vertices) {
        this.vertices = vertices;
        this.arestas = new ArrayList<>();
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        arestas.add(new Aresta(origem, destino, peso));
    }

    private int encontrar(Subconjunto[] subconjuntos, int i) {
        if (subconjuntos[i].pai != i) {
            subconjuntos[i].pai = encontrar(subconjuntos, subconjuntos[i].pai);
        }
        return subconjuntos[i].pai;
    }

    private void unir(Subconjunto[] subconjuntos, int x, int y) {
        int raizX = encontrar(subconjuntos, x);
        int raizY = encontrar(subconjuntos, y);

        if (subconjuntos[raizX].rank < subconjuntos[raizY].rank) {
            subconjuntos[raizX].pai = raizY;
        } else if (subconjuntos[raizX].rank > subconjuntos[raizY].rank) {
            subconjuntos[raizY].pai = raizX;
        } else {
            subconjuntos[raizY].pai = raizX;
            subconjuntos[raizX].rank++;
        }
    }

    public void encontrarMST() {
        List<Aresta> resultado = new ArrayList<>();
        Collections.sort(arestas);

        Subconjunto[] subconjuntos = new Subconjunto[vertices];
        for (int i = 0; i < vertices; i++) {
            subconjuntos[i] = new Subconjunto();
            subconjuntos[i].pai = i;
            subconjuntos[i].rank = 0;
        }

        for (Aresta aresta : arestas) {
            int origemRaiz = encontrar(subconjuntos, aresta.origem);
            int destinoRaiz = encontrar(subconjuntos, aresta.destino);

            if (origemRaiz != destinoRaiz) {
                resultado.add(aresta);
                unir(subconjuntos, origemRaiz, destinoRaiz);
            }
        }

        System.out.println("Arestas na MST usando Kruskal:");
        for (Aresta aresta : resultado) {
            System.out.println(aresta.origem + " - " + aresta.destino + " : " + aresta.peso);
        }
    }
    
    public static void main(String[] args) {
        ArvoreGM_Kruskal kruskal = new ArvoreGM_Kruskal(4);
    
        kruskal.adicionarAresta(0, 1, 10);
        kruskal.adicionarAresta(0, 2, 6);
        kruskal.adicionarAresta(0, 3, 5);
        kruskal.adicionarAresta(1, 3, 15);
        kruskal.adicionarAresta(2, 3, 4);
    
        kruskal.encontrarMST();
    }
    
}
