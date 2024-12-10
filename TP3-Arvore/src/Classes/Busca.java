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

    public void VerificaNo(int chave){
        // Realiza a busca pela chave na árvore
        if (arvore.pesquisa(chave, 1)) {
            exibirConteudoArquivo(chave);
        } else {
            System.out.println("Chave " + chave + " não encontrada.");
        }
    }
    // Método para exibir o conteúdo do arquivo baseado no valor chave
    private void exibirConteudoArquivo(int chave) {
        // A árvore armazena as informações nas folhas (vetores de 3 elementos)

        // Obtendo o valor da chave na árvore
        String[] no = arvore.getValorChave(chave, 1);  // Usando o método getValorChave da Insere_Arvore

        if (no != null) {
            String arquivoNome = "../Dex/" + no[2].trim(); // Formando o caminho para o arquivo
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

    public static void main(String[] args) {
        Insere_Arvore insereArvore = new Insere_Arvore(2);

        // Arquivo de exemplo
        String caminhoArquivo = "Dex/Dex.arb";
        insereArvore.insereDoArquivo(caminhoArquivo);

        // Busca pela chave 136
        Busca arvoreBusca = new Busca(insereArvore);
        arvoreBusca.VerificaNo(136);
    }
}
