package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Busca {
    private Insere_Arvore arvore;  // Instância de Insere_Arvore

    // Construtor da classe que recebe a instância de Insere_Arvore e a chave a ser buscada
    public Busca(Insere_Arvore arvore) {
        this.arvore = arvore;
        
    }

    public String[] VerificaNo(int chave){
        // Realiza a busca pela chave na árvore
        String [] CHAVE = new String[2];
        CHAVE[0] = "1";
        if (arvore.pesquisa(chave, 1)) {
            exibirConteudoArquivo(chave);
            String[] chaveValores = arvore.getValorChave(chave, 1);
            CHAVE[0] = "0";
            CHAVE[1] = chaveValores[2];
            return CHAVE;
        } else {
            System.out.println("Chave " + chave + " não encontrada.");
            return CHAVE;
        }
    }

    public String[] VerificaNo(String chave){
        // Realiza a busca pela chave na árvore
        String [] CHAVE = new String[2];
        CHAVE[0] = "1";
        if (arvore.pesquisa(chave, 1)) {
            exibirConteudoArquivo(chave);
            String[] chaveValores = arvore.getValorChave(chave, 1);
            CHAVE[0] = "0";
            CHAVE[1] = chaveValores[2];
            return CHAVE;
        } else {
            System.out.println("Chave " + chave + " não encontrada.");
            return CHAVE;
        }
    }

    // Método para exibir o conteúdo do arquivo baseado no valor chave
    private void exibirConteudoArquivo(int chave) {

        // Obtendo o valor da chave na árvore
        String[] no = arvore.getValorChave(chave, 1);  // Usando o método getValorChave da Insere_Arvore

        if (no != null) {
            String arquivoNome = "Dex/" + no[2].trim().replaceAll("[\\s.'''’]", "") + ".txt"; // Formando o caminho para o arquivo
            File arquivo = new File(arquivoNome);
            if (arquivo.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        System.out.println(linha); // Exibe o conteúdo do arquivo
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                }
            } else {
                System.out.println("Arquivo não encontrado: " + arquivoNome);
            }
        } else {
            System.out.println("Chave não encontrada na árvore.");
        }
        
    }

    private void exibirConteudoArquivo(String chave) {

        // Obtendo o valor da chave na árvore
        String[] no = arvore.getValorChave(chave, 1);  // Usando o método getValorChave da Insere_Arvore

        if (no != null) {
            String arquivoNome = "Dex/" + no[2].trim().replaceAll("[\\s.'''’]", "") + ".txt"; // Formando o caminho para o arquivo
            File arquivo = new File(arquivoNome);
            if (arquivo.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        System.out.println(linha); // Exibe o conteúdo do arquivo
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                }
            } else {
                System.out.println("Arquivo não encontrado: " + arquivoNome);
            }
        } else {
            System.out.println("Chave não encontrada na árvore.");
        }
        
    }

    public String getPokemonNameById(int chave) {
        // Obtendo o valor da chave na árvore
        String[] no = arvore.getValorChave(chave, 1); // Usando o método getValorChave da Insere_Arvore
    
        if (no != null) {
            String arquivoNome = "Dex/" + no[2].trim().replaceAll("[\\s.'''’]", "") + ".txt"; // Formando o caminho para o arquivo
            File arquivo = new File(arquivoNome);
            if (arquivo.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha = br.readLine(); // Supondo que o nome do Pokémon está na primeira linha
                    if (linha != null && !linha.isEmpty()) {
                        return linha.trim().replaceAll("[\\s.'''’]", ""); // Retorna o nome do Pokémon
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                }
            } else {
                System.out.println("Arquivo não encontrado: " + arquivoNome);
            }
        } else {
            System.out.println("Chave não encontrada na árvore.");
        }
    
        return null; // Retorna null se o nome não for encontrado
    }
    

    public static void main(String[] args) {
        Insere_Arvore insereArvore = new Insere_Arvore(2);

        // Arquivo de exemplo
        String caminhoArquivo = "Dex/Dex.arb";
        insereArvore.insereDoArquivo(caminhoArquivo, 0);

        // Busca pela chave 136
        Busca arvoreBusca = new Busca(insereArvore);
        arvoreBusca.VerificaNo(136);
    }
}
