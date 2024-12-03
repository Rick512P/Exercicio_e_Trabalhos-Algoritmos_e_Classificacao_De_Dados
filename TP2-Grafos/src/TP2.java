import Classes_Matriz.*;


import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class TP2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char opcao;

        while (true) {
            System.out.println("Menu de Algoritmos de Grafos:");
            System.out.println("1. GrafoM");
            System.out.println("2. DigrafoM");
            System.out.println("3. BFSM");
            System.out.println("4. DFSM");
            System.out.println("5. Ordenacao_TopologicaM");
            System.out.println("6. ArvoreGM_Kruskal");
            System.out.println("7. ArvoreGM_Prim");
            System.out.println("8. Caminho Minimo - Bellman-Ford");
            System.out.println("9. Caminho Minimo - Dijkstra");
            System.out.println("a. Caminho Minimo - Floyd-Warshall");
            System.out.println("b. Fluxo Maximo - Ford-Fulkerson");

            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
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
                    BellmanFord.main(args);
                    break;
                case '9':
                    Dijkstra.main(args);
                    break;
                case 'a':
                    FloydWarshall.main(args);
                    break;
                case 'b':
                    FordFulkerson.main(args);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

