package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Busca_Nome {
    private Insere_Arvore_Nome arvore;  // Instância de Insere_Arvore_Nome

    // Construtor da classe que recebe a instância de Insere_Arvore_Nome
    public Busca_Nome(Insere_Arvore_Nome arvore) {
        this.arvore = arvore;
    }

    public void VerificaNo(String nome) {
        // Realiza a busca pelo nome na árvore
        if (arvore.pesquisa(nome)) {
            exibirConteudoArquivo(nome);
        } else {
            System.out.println("Nome " + nome + " não encontrado.");
        }
    }

    // Método para exibir o conteúdo do arquivo baseado no nome
    private void exibirConteudoArquivo(String nome) {
        // Obtendo o valor do nó na árvore
        String[] no = arvore.getValorChave(nome);  // Usando o método getValorChave da Insere_Arvore_Nome
        
        if (no != null) {
            String arquivoNome = "../Dex/" + nome.toLowerCase() + ".txt"; // Constrói o caminho do arquivo
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
            System.out.println("Nome não encontrado na árvore.");
        }
    }


    public static void main(String[] args) {
        Insere_Arvore_Nome insereArvoreNome = new Insere_Arvore_Nome(2);

        // Arquivo de exemplo
        String caminhoArquivo = "Dex/Dex.arb";
        insereArvoreNome.insereDoArquivo(caminhoArquivo);

        // Busca pelo nome "Pikachu"
        Busca_Nome arvoreBuscaNome = new Busca_Nome(insereArvoreNome);
        arvoreBuscaNome.VerificaNo("Pikachu");
    }
}
