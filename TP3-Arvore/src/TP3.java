import java.util.Scanner;

import Classes.Busca;
import Classes.Insere_Arvore;
import Classes.Insere_Arvore_Nome;
import Classes.Busca_Nome;

public class TP3 {
    public static void main(String[] args) {
        /*Insere_Arvore_Nome insereArvoreNome = new Insere_Arvore_Nome(2);
        insereArvoreNome.insereDoArquivo("../Dex/Dex.arb");

        System.out.println("Estrutura da Árvore B por Nome:");
        insereArvoreNome.imprimeArvore(); // Deve mostrar a estrutura completa da árvore*/
        // Inicializando as árvores
        Insere_Arvore insere_Arvore = new Insere_Arvore(2);
        insere_Arvore.insereDoArquivo("Dex/Dex.arb");
        Insere_Arvore_Nome insere_Arvore_Nome = new Insere_Arvore_Nome(2);
        insere_Arvore_Nome.insereDoArquivo("Dex/Dex.arb");

        // Inicializando as buscas
        Busca busca = new Busca(insere_Arvore);
        Busca_Nome buscaNome = new Busca_Nome(insere_Arvore_Nome);

        Scanner scanner = new Scanner(System.in); // Declaração do Scanner
        String entrada;

        while (true) {
            System.out.print("Entre com o número ou nome do Pokémon (ou 0 para sair): ");
            
            entrada = scanner.nextLine().trim(); // Lê a entrada do usuário
            
            if (entrada.equals("0")) {
                System.out.println("Encerrando o programa...");
                break;
            }

            // Verifica se a entrada é um número
            if (entrada.matches("\\d+")) { // Regex para verificar se a string é composta apenas por dígitos
                int id = Integer.parseInt(entrada); // Converte para número
                System.out.println("");
                busca.VerificaNo(id);
                System.out.println("");
            } else {
                // Caso contrário, trata como nome
                System.out.println("");
                buscaNome.VerificaNo(entrada);
                System.out.println("");
            }
        }

        scanner.close(); // Fecha o Scanner para liberar recursos*/
    }
}
