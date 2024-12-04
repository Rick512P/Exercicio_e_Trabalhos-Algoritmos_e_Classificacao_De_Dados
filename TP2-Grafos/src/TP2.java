import Classes_Matriz.*;
import Classes_LE.*;

import java.util.Scanner;

public class TP2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char opcao;

        while (true) {
            System.out.println("\nMenu de Algoritmos de Grafos:");
            System.out.println("===== Implementações em Matriz =====");
            System.out.println("1. GrafoM");
            System.out.println("2. DigrafoM");
            System.out.println("3. BFSM");
            System.out.println("4. DFSM");
            System.out.println("5. Ordenacao_TopologicaM");
            System.out.println("6. ArvoreGM_Kruskal");
            System.out.println("7. ArvoreGM_Prim");
            System.out.println("8. Caminho Minimo - Bellman-Ford (Matriz)");
            System.out.println("9. Caminho Minimo - Dijkstra (Matriz)");
            System.out.println("a. Caminho Minimo - Floyd-Warshall (Matriz)");
            System.out.println("b. Fluxo Maximo - Ford-Fulkerson (Matriz)");

            System.out.println("\n===== Implementações em Lista de Adjacência =====");
            System.out.println("c. GrafoL");
            System.out.println("d. GrafoL");
            System.out.println("e. Caminho em Largura (BFS - Lista)");
            System.out.println("f. Caminho em Profundidade (DFS - Lista)");
            System.out.println("g. Ordenacao Topológica (Lista)");
            System.out.println("h. Árvore Geradora Mínima (Kruskal - Lista)");
            System.out.println("i. Árvore Geradora Mínima (Prim - Lista)");
            System.out.println("j. Caminho Minimo - Bellman-Ford (Lista)");
            System.out.println("k. Caminho Minimo - Dijkstra (Lista)");
            System.out.println("l. Caminho Minimo - Floyd-Warshall (Lista)");
            System.out.println("m. Fluxo Máximo - Ford-Fulkerson (Lista)");

            System.out.println("\nn. Comparar desempenho dos algoritmos de Caminho Minimo (BellMan e Dijkstra) para LE");
            System.out.println("\no. Comparar desempenho dos algoritmos de Caminho Minimo (BellMan e Dijkstra) para Matriz");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
                // Implementações em Matriz
                case '1':
                    GrafoM.main(args);
                    break;
                case '2':
                    DigrafoM.main(args);
                    break;
                case '3':
                    BFSM.main(args);
                    break;
                case '4':
                    DFSM.main(args);
                    break;
                case '5':
                    Ordenacao_TopologicaM.main(args);
                    break;
                case '6':
                    ArvoreGM_Kruskal.main(args);
                    break;
                case '7':
                    ArvoreGM_Prim.main(args);
                    break;
                case '8':
                    BellmanFordM.main(args); // Matriz
                    break;
                case '9':
                    DijkstraM.main(args); // Matriz
                    break;
                case 'a':
                    FloydWarshall.main(args); // Matriz
                    break;
                case 'b':
                    FordFulkerson.main(args); // Matriz
                    break;

                // Implementações em Lista de Adjacência
                case 'c':
                    GrafoL.main(args); // Exemplo básico de GrafoL
                    break;
                case 'd':
                    DigrafoL.main(args); // Exemplo básico de GrafoL
                    break;
                case 'e':
                    BFSL.main(args); // BFS - Lista
                    break;
                case 'f':
                    DFSL.main(args); // DFS - Lista
                    break;
                case 'g':
                    Ordenacao_TopologicaL.main(args); // Ordenação Topológica - Lista
                    break;
                case 'h':
                    KruskalL.main(args); // Kruskal - Lista
                    break;
                case 'i':
                    PrimL.main(args); // Prim - Lista
                    break;
                case 'j':
                    BellmanFordL.main(args); // Bellman-Ford - Lista
                    break;
                case 'k':
                    DijkstraL.main(args); // Dijkstra - Lista
                    break;
                case 'l':
                    FloydWarshallL.main(args); // Floyd-Warshall - Lista
                    break;
                case 'm':
                    FordFulkersonL.main(args); // Ford-Fulkerson - Lista
                    break;

                // Comparação de Desempenho
                case 'n':
                    System.out.println("Executando testes de desempenho...");
                    TempoExecucaoArquivos.main(null);
                    break;
                case 'o':
                    System.out.println("Executando testes de desempenho...");
                    TempoExecucaoM.main(null);
                    break;
                // Sair
                case '0':
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
