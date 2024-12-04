package Classes_Matriz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TempoExecucaoM {

    public static void medirTempoArquivos(String pasta) {
        File diretorio = new File(pasta);
        File[] arquivos = diretorio.listFiles((dir, nome) -> nome.endsWith(".gr")); // Filtra arquivos .gr

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum arquivo .gr encontrado na pasta: " + pasta);
            return;
        }

        // Ordena os arquivos com base no número após "sample"
        Arrays.sort(arquivos, (f1, f2) -> {
            String nome1 = f1.getName();
            String nome2 = f2.getName();

            // Extrai os números dos nomes dos arquivos
            int numero1 = extrairNumero(nome1);
            int numero2 = extrairNumero(nome2);

            return Integer.compare(numero1, numero2);
        });

        for (File arquivo : arquivos) {
            System.out.println("\n==============================================");
            System.out.println("Lendo arquivo: " + arquivo.getName());
            GrafoM grafo = lerGrafoDeArquivo(arquivo);

            if (grafo == null) {
                System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                continue;
            }

            int fonte = 0; // Vértice inicial para os algoritmos

            // Executa Bellman-Ford
            System.out.println("\n===== Tempo de execução - Bellman-Ford =====");
            double tempoTotalBellmanFord = 0;
            boolean cicloNegativoDetectado = false;

            for (int i = 1; i <= 10; i++) {
                BellmanFordM bellmanFord = new BellmanFordM(grafo.numVertices, grafo.ponderado);
                bellmanFord.atribui(grafo);
                try {
                    double inicio = System.nanoTime();
                    bellmanFord.calcularCaminhosMinimos(fonte);
                    double fim = System.nanoTime();
                    double duracao = (fim - inicio) / 1_000_000; // Convertendo para milissegundos
                    tempoTotalBellmanFord += duracao;
                    System.out.printf("Execução %d: %.5f ms%n", i, duracao);
                } catch (IllegalStateException e) {
                    System.out.println("Execução " + i + ": Ciclo de peso negativo detectado. Pulando.");
                    cicloNegativoDetectado = true;
                    break; // Interrompe as execuções para este grafo
                }
            }

            if (!cicloNegativoDetectado) {
                double tempoMedioBellmanFord = tempoTotalBellmanFord / 10;
                System.out.printf("Média de execução (Bellman-Ford): %.5f ms%n", tempoMedioBellmanFord);
            } else {
                System.out.println("Ciclo negativo detectado, média de execução não calculada para Bellman-Ford.");
            }

            // Executa Dijkstra somente se não houver ciclo negativo
            if (!cicloNegativoDetectado) {
                System.out.println("\n===== Tempo de execução - Dijkstra =====");
                double tempoTotalDijkstra = 0;
                for (int i = 1; i <= 10; i++) {
                    DijkstraM dijkstra = new DijkstraM(grafo);
                    double inicio = System.nanoTime();
                    dijkstra.calcularCaminhosMinimos(fonte);
                    double fim = System.nanoTime();
                    double duracao = (fim - inicio) / 1_000_000; // Convertendo para milissegundos
                    tempoTotalDijkstra += duracao;
                    System.out.printf("Execução %d: %.5f ms%n", i, duracao);
                }
                double tempoMedioDijkstra = tempoTotalDijkstra / 10;
                System.out.printf("Média de execução (Dijkstra): %.5f ms%n", tempoMedioDijkstra);
            } else {
                System.out.println("Pulos Dijkstra devido à presença de ciclos de peso negativo no grafo.");
            }
        }
    }

    // Método para extrair números do nome do arquivo
    private static int extrairNumero(String nome) {
        // Exemplo de nome: sample500-249500.gr
        String[] partes = nome.replace("sample", "").split("-");
        try {
            return Integer.parseInt(partes[1].replace(".gr", ""));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return 0; // Retorna 0 se não conseguir extrair um número
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
