import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

import Classes.Busca;
import Classes.Insere_Arvore;

public class TP3 {
    public static void main(String[] args) {
        Insere_Arvore insere_Arvore = new Insere_Arvore(2);
        Insere_Arvore insere_ArvoreAlfa = new Insere_Arvore(2);
        insere_Arvore.insereDoArquivo("Dex/Dex.arb", 0);
        insere_ArvoreAlfa.insereDoArquivo("Dex/Dex.arb", 1);

        // Inicializando as buscas
        Busca busca = new Busca(insere_Arvore);
        Busca buscaAlfa = new Busca(insere_ArvoreAlfa);

        Scanner scanner = new Scanner(System.in); // Declaração do Scanner
        String entrada;

        while (true) {
            System.out.print("Entre com o número ou nome do Pokémon (ou 0 para sair): ");
        
            entrada = scanner.nextLine().trim().replaceAll("[\\s.'''’]", ""); // Lê a entrada do usuário
        
            insere_ArvoreAlfa.imprimeArvore();
            if (entrada.equals("0")) {
                System.out.println("Encerrando o programa...");
                break;
            }
            String [] encontrado = new String[2]; // Inicializa a variável encontrado
            encontrado[0] = "1";
            // Verifica se a entrada é um número
            if (entrada.matches("\\d+")) { // Regex para verificar se a string é composta apenas por dígitos
                int id = Integer.parseInt(entrada); // Converte para número
                System.out.println("");
                encontrado = busca.VerificaNo(id);
                System.out.println("");

                if (Integer.parseInt(encontrado[0]) == 0) {
                    // Constrói o URL com base no ID
                    String baseURL = "https://www.pokemon.com/br/pokedex/";
                    String fullURL = baseURL + encontrado[1].trim().replaceAll("[\\s.'''’^´`]", "");
                    WebUtils.openWebPage(fullURL);
                }

            } else {
                // Caso contrário, trata como nome
                insere_ArvoreAlfa.getValorChave(entrada, 1);
                encontrado = buscaAlfa.VerificaNo(entrada);
                System.out.println("");

                if (Integer.parseInt(encontrado[0]) == 0) {
                    // Constrói o URL com base no nome
                    String baseURL = "https://www.pokemon.com/br/pokedex/";
                    String fullURL = baseURL + encontrado[1].trim().replaceAll("[\\s.'''’`^'`´]", "");
                    WebUtils.openWebPage(fullURL);
                }
            }
        }

        scanner.close(); // Fecha o Scanner para liberar recursos*/
    }

    public class WebUtils {
    public static void openWebPage(String url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(url));
        } catch (Exception e) {
            System.out.println("Não foi possível abrir o navegador: " + e.getMessage());
        }
    }
}
}
