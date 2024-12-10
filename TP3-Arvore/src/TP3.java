import java.util.Scanner;

import Classes.Busca;
import Classes.Insere_Arvore;

public class TP3 {
    public static void main(String[] args) {
        Insere_Arvore insere_Arvore = new Insere_Arvore(2);
        insere_Arvore.insereDoArquivo("Dex/Dex.arb");
        Busca busca = new Busca(insere_Arvore);
        Scanner scanner = new Scanner(System.in); // Declaração do Scanner
        int chave = 1;

        while (chave != 0){
            System.out.print("Entre com o número da dex a buscar: ");
            
            chave = scanner.nextInt(); // Lê o número inserido pelo usuário
            
            if (chave != 0){
                System.out.println("");
                busca.VerificaNo(chave);
                System.out.println("");
            }
        }
        scanner.close(); // Fecha o Scanner para liberar recursos
        
    }
}

