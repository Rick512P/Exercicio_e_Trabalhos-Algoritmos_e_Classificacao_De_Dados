package Classes_Matriz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TempoExecucaoM {

    public static void medirTempoArquivos(String pasta) {
        File diretorio = new File(pasta);
        File[] arquivos = diretorio.listFiles((dir, nome) -> nome.endsWith(".gr")); // Filtra arquivos .gr

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum arquivo .gr encontrado na pasta: " + pasta);
            return;
        }

        for (File arquivo : arquivos) {
            System.out.println("\n==============================================");
            System.out.println("Lendo arquivo: " + arquivo.getName());
            GrafoM grafo = lerGrafoDeArquivo(arquivo);

            if (grafo == null) {
                System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                continue;
            }

            //grafo.mostrarGrafoM(); // Exibe a matriz de adjacência

            int fonte = 0; // Vértice inicial para os algoritmos

            // Executa Bellman-Ford
            System.out.println("\n===== Tempo de execução - Bellman-Ford =====");
            long tempoTotalBellmanFord = 0;
            boolean cicloNegativoDetectado = false;

            for (int i = 1; i <= 10; i++) {
                BellmanFordM bellmanFord = new BellmanFordM(grafo);
                try {
                    long inicio = System.nanoTime();
                    bellmanFord.calcularCaminhosMinimos(fonte);
                    long fim = System.nanoTime();
                    long duracao = (fim - inicio) / 1_000_000; // Convertendo para milissegundos
                    tempoTotalBellmanFord += duracao;
                    System.out.println("Execução " + i + ": " + duracao + " ms");
                } catch (IllegalStateException e) {
                    System.out.println("Execução " + i + ": Ciclo de peso negativo detectado. Pulando.");
                    cicloNegativoDetectado = true;
                    break; // Interrompe as execuções para este grafo
                }
            }

            if (!cicloNegativoDetectado) {
                long tempoMedioBellmanFord = tempoTotalBellmanFord / 10;
                System.out.println("Média de execução (Bellman-Ford): " + tempoMedioBellmanFord + " ms");
            } else {
                System.out.println("Ciclo negativo detectado, média de execução não calculada para Bellman-Ford.");
            }

            // Executa Dijkstra
            System.out.println("\n===== Tempo de execução - Dijkstra =====");
            long tempoTotalDijkstra = 0;
            for (int i = 1; i <= 10; i++) {
                DijkstraM dijkstra = new DijkstraM(grafo);
                long inicio = System.nanoTime();
                dijkstra.calcularCaminhosMinimos(fonte);
                long fim = System.nanoTime();
                long duracao = (fim - inicio) / 1_000_000; // Convertendo para milissegundos
                tempoTotalDijkstra += duracao;
                System.out.println("Execução " + i + ": " + duracao + " ms");
            }
            long tempoMedioDijkstra = tempoTotalDijkstra / 10;
            System.out.println("Média de execução (Dijkstra): " + tempoMedioDijkstra + " ms");
        }
    }

    // Método para ler um grafo a partir de um arquivo .gr
    private static GrafoM lerGrafoDeArquivo(File arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int numVertices = 0;
            GrafoM grafo = null;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                // Ignora comentários
                if (linha.startsWith("c")) {
                    continue;
                }

                // Processa o cabeçalho
                if (linha.startsWith("p")) {
                    String[] partes = linha.split("\\s+");
                    numVertices = Integer.parseInt(partes[2]);
                    grafo = new GrafoM(numVertices, true); // Grafo ponderado
                }

                // Processa as arestas
                if (linha.startsWith("a")) {
                    String[] partes = linha.split("\\s+");
                    int origem = Integer.parseInt(partes[1]) - 1; // Converte para índice 0
                    int destino = Integer.parseInt(partes[2]) - 1; // Converte para índice 0
                    int peso = Integer.parseInt(partes[3]);
                    if (grafo != null) {
                        grafo.adicionarAresta(origem, destino, peso);
                    }
                }
            }

            return grafo;
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Pasta onde estão os arquivos .gr
        String pasta = "./Grafos";
        medirTempoArquivos(pasta);
    }
}
