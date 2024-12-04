package Classes_LE;

import java.util.PriorityQueue;

public class PrimL {
    private GrafoL grafo;

    public PrimL(GrafoL grafo) {
        this.grafo = grafo;
    }

    public void obterMST() {
        boolean[] visitados = new boolean[grafo.numVertices];
        PriorityQueue<GrafoL.Aresta> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.peso, b.peso));

        // Inicia a partir do vértice 0
        visitados[0] = true;
        minHeap.addAll(grafo.listaAdjacencia.get(0)); // Corrigido: usa GrafoL.Aresta diretamente

        System.out.println("Árvore Geradora Mínima (Prim):");
        while (!minHeap.isEmpty()) {
            GrafoL.Aresta aresta = minHeap.poll(); // Corrigido: usa GrafoL.Aresta diretamente

            if (!visitados[aresta.destino]) {
                visitados[aresta.destino] = true;
                System.out.println(aresta.origem + " -> " + aresta.destino + " : " + aresta.peso);

                // Adiciona as arestas do novo vértice visitado
                for (GrafoL.Aresta adjacente : grafo.listaAdjacencia.get(aresta.destino)) {
                    if (!visitados[adjacente.destino]) {
                        minHeap.add(adjacente);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafoL grafo = new GrafoL(6, true);
        grafo.adicionarAresta(0, 1, 4);
        grafo.adicionarAresta(0, 2, 4);
        grafo.adicionarAresta(1, 2, 2);
        grafo.adicionarAresta(1, 3, 5);
        grafo.adicionarAresta(2, 3, 5);
        grafo.adicionarAresta(3, 4, 3);

        PrimL prim = new PrimL(grafo);
        prim.obterMST();
    }
}
