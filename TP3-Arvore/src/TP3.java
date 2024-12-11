import java.net.URI;
import java.util.Scanner;
import java.awt.Desktop;

import Classes.Busca;
import Classes.Insere_Arvore;

public class TP3 {
    public static void main(String[] args) {
        Insere_Arvore insere_Arvore = new Insere_Arvore(2);
        insere_Arvore.insereDoArquivo("Dex/Dex.arb");

        // Inicializando as buscas
        Busca busca = new Busca(insere_Arvore);

        Scanner scanner = new Scanner(System.in); // Declaração do Scanner
        String entrada;

        while (true) {
            System.out.print("Entre com o número ou nome do Pokémon (ou 0 para sair): ");
            
            entrada = scanner.nextLine().trim(); // Lê a entrada do usuário
            
            if (entrada.equals("0")) {
                System.out.println("Encerrando o programa...");
                break;
            }
            boolean encontrado = false; // Inicializa a variável encontrado
            // Verifica se a entrada é um número
            if (entrada.matches("\\d+")) { // Regex para verificar se a string é composta apenas por dígitos
                int id = Integer.parseInt(entrada); // Converte para número
                System.out.println("");
                encontrado = busca.VerificaNo(id);
                System.out.println("");

                if (encontrado) {
                    // Constrói o URL com base no ID
                    String baseURL = "https://www.pokemon.com/br/pokedex/";
                    String pokemonName = busca.getPokemonNameById(id);
                    String fullURL = baseURL + pokemonName.toLowerCase();
                    WebUtils.openWebPage(fullURL);
                }

            } else {
                /* Caso contrário, trata como nome
                System.out.println("");
                buscaNome.VerificaNo(entrada);
                System.out.println("");

                if (encontrado) {
                    // Constrói o URL com base no nome
                    String baseURL = "https://www.pokemon.com/br/pokedex/";
                    String pokemonName = entrada.toLowerCase(); // Certifique-se de que o nome esteja em minúsculas
                    String fullURL = baseURL + pokemonName;
                    WebUtils.openWebPage(fullURL);
                }
            */}
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
