package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Insere_Arvore_Nome {
    private ArvoreB_Nome arvoreB_Nome;

    public Insere_Arvore_Nome(int grauMinimo) {
        this.arvoreB_Nome = new ArvoreB_Nome(grauMinimo);
    }

    // Método para ler o arquivo e inserir na árvore baseada em nomes
    public void insereDoArquivo(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
    
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
            return;
        }
    
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                //System.out.println("Lendo linha do arquivo: " + linha); // Depuração da linha lida
                String[] elementos = linha.split(";");
    
                if (elementos.length == 3) {
                    arvoreB_Nome.insere(elementos); // Insere o vetor de strings na árvore
                } else {
                    System.out.println("Linha inválida (não contém 3 elementos): " + linha); // Linha incorreta
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
    

    // Método para realizar a busca pelo nome
    public boolean pesquisa(String nome) {
        return arvoreB_Nome.pesquisa(nome);
    }

    // Método para obter o valor associado ao nome
    public String[] getValorChave(String nome) {
        return arvoreB_Nome.getValorChave(nome);
    }

    public void imprimeArvore() {
        System.out.println("Estrutura da Árvore B por Nome:");
        arvoreB_Nome.imprime();
    }

    public static void main(String[] args) {
        Insere_Arvore_Nome insereArvoreNome = new Insere_Arvore_Nome(2);

        String caminhoArquivo = "Dex/Dex_Nomes.arb";  // Arquivo de exemplo
        insereArvoreNome.insereDoArquivo(caminhoArquivo);

        insereArvoreNome.imprimeArvore();

        // Testando pesquisas
        String[] nomesTeste = {"Pikachu", "Charmander", "Bulbasaur", "Eevee", "Squirtle"};
        for (String nome : nomesTeste) {
            if (insereArvoreNome.pesquisa(nome)) {
                System.out.println("Nome " + nome + " encontrado.");
            } else {
                System.out.println("Nome " + nome + " não encontrado.");
            }
        }
    }
}
