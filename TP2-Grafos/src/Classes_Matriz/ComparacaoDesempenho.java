package Classes_Matriz;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ComparacaoDesempenho {

    // Função para criar grafos variados
    public static GrafoM PreencheGrafo(GrafoM grafo) {
        
        Random random = new Random();
        for (int i = 0; i < grafo.numVertices; i++) {
            for (int j = i + 1; j < grafo.numVertices; j++) {
                if (random.nextBoolean()) { // Adiciona aresta com 50% de chance
                    int peso = random.nextInt(20) + 1;
                    grafo.adicionarAresta(i, j, peso);
                }
            }
        }

        return grafo;
    }

    public static DigrafoM PreencheGrafo(DigrafoM grafo) {
        Random random = new Random();
        for (int i = 0; i < grafo.numVertices; i++) {
            for (int j = i + 1; j < grafo.numVertices; j++) {
                if (random.nextBoolean()) { // Adiciona aresta com 50% de chance
                    int peso = random.nextInt(20) + 1;
                    grafo.adicionarAresta(i, j, peso);
                }
            }
        }

        return grafo;
    }

    // Executa e mede o tempo de cada algoritmo no grafo
    public static void executarTestesPorGrafo(GrafoM grafo, int execucoes) {
        System.out.println("Executando testes no grafo...");
        Map<String, Long> tempos = new LinkedHashMap<>();

        // BFSM
        long tempoBFSM = medirTempo(() -> {
            for (int i = 0; i < execucoes; i++) {
                BFSM bfs = new BFSM(grafo);
                bfs.buscaLargura(0); // Busca em largura a partir do vértice 0
            }
        });
        tempos.put("BFSM", tempoBFSM);

        // DFSM
        long tempoDFSM = medirTempo(() -> {
            for (int i = 0; i < execucoes; i++) {
                DFSM dfs = new DFSM(grafo);
                dfs.buscaProfundidade(0); // Busca em profundidade a partir do vértice 0
            }
        });
        tempos.put("DFSM", tempoDFSM);

        // Ordenação Topológica
        if (grafo instanceof DigrafoM) { // Apenas digrafos podem ser ordenados topologicamente
            long tempoOrdenacaoTopologica = medirTempo(() -> {
                for (int i = 0; i < execucoes; i++) {
                    Ordenacao_TopologicaM ordenacao = new Ordenacao_TopologicaM(grafo);
                    try {
                        ordenacao.ordenarTopologicamente();
                    } catch (IllegalStateException e) {
                        // Ciclo detectado, ordenação não é possível
                    }
                }
            });
            tempos.put("Ordenação Topológica", tempoOrdenacaoTopologica);
        }

        // Exibir tempos
        //tempos.forEach((algoritmo, tempo) -> System.out.println(algoritmo + ": " + tempo/1000000000 + " s"));
        tempos.forEach((algoritmo, tempo) -> 
            System.out.println(algoritmo + ": " + String.format("%.6f s", tempo / 1_000_000_000.0))
        );

        System.out.println("------------------------------------------");
    }

    // Medir tempo de execução de um bloco de código
    public static long medirTempo(Runnable runnable) {
        Instant inicio = Instant.now();
        runnable.run();
        Instant fim = Instant.now();
        return Duration.between(inicio, fim).toNanos();
    }

    // Função principal para criar 15 grafos e executar os testes
    public static void executarTestes() {
        int[] tamanhos = {10, 20, 30}; // Tamanhos dos grafos
        boolean[] ponderado = {false, true}; // Grafos ponderados e não ponderados
        boolean[] direcionado = {false, true}; // Grafos não direcionados e direcionados
        int execucoes = 10;

        System.out.println("Comparando desempenho dos algoritmos em grafos:");
        System.out.println("==========================================");

        for (int tamanho : tamanhos) {
            for (boolean isPonderado : ponderado) {
                for (boolean isDirecionado : direcionado) {
                    if (isDirecionado == true){
                        DigrafoM grafo = new DigrafoM(tamanho, isPonderado);
                        
                        grafo = PreencheGrafo(grafo);
                        System.out.printf("Digrafo: Tamanho %d, Ponderado %b, Direcionado %b%n",
                                tamanho, isPonderado, isDirecionado);
                        executarTestesPorGrafo(grafo, execucoes);
                    }
                    else{
                        GrafoM grafo = new GrafoM(tamanho, isPonderado);
                        
                        grafo = PreencheGrafo(grafo);
                        System.out.printf("Grafo: Tamanho %d, Ponderado %b, Direcionado %b%n",
                                tamanho, isPonderado, isDirecionado);
                        executarTestesPorGrafo(grafo, execucoes);
                    }
                }
            }
        }
    }

    // Método principal para integração
    public static void main(String[] args) {
        executarTestes();
    }
}
