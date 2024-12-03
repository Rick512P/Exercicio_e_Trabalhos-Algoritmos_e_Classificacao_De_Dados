package Classes_Matriz;

import java.util.*;

public class ArvoreGM_Prim {
    private int vertices;
    private List<List<int[]>> grafo;

    public ArvoreGM_Prim(int vertices) {
        this.vertices = vertices;
        grafo = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        grafo.get(origem).add(new int[]{destino, peso});
        grafo.get(destino).add(new int[]{origem, peso});
    }

    public void encontrarMST() {
        boolean[] visitado = new boolean[vertices];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        heap.add(new int[]{0, 0}); // Começa do vértice 0
        int pesoTotal = 0;

        System.out.println("Arestas na MST usando Prim:");
        while (!heap.isEmpty()) {
            int[] atual = heap.poll();
            int vertice = atual[0];
            int peso = atual[1];

            if (visitado[vertice]) continue;

            visitado[vertice] = true;
            pesoTotal += peso;

            System.out.println("Vertice: " + vertice + ", Peso: " + peso);

            for (int[] vizinho : grafo.get(vertice)) {
                if (!visitado[vizinho[0]]) {
                    heap.add(vizinho);
                }
            }
        }

        System.out.println("Peso total da MST: " + pesoTotal);
    }


    public static void main(String[] args) {
        ArvoreGM_Prim prim = new ArvoreGM_Prim(4);
    
        prim.adicionarAresta(0, 1, 10);
        prim.adicionarAresta(0, 2, 6);
        prim.adicionarAresta(0, 3, 5);
        prim.adicionarAresta(1, 3, 15);
        prim.adicionarAresta(2, 3, 4);
    
        prim.encontrarMST();
    }
    
}
