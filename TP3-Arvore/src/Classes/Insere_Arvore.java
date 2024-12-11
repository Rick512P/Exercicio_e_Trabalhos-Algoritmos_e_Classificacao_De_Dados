package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Insere_Arvore {
    private ArvoreB arvoreB;

    public Insere_Arvore(int grauMinimo) {
        this.arvoreB = new ArvoreB(grauMinimo);
    }

    // Método para ler o arquivo e inserir na árvore
    public void insereDoArquivo(String caminhoArquivo, int tipo) {
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] elementos = linha.split(";");
                if (elementos.length == 3) {
                    arvoreB.insere(elementos, tipo);  // Insere o vetor de strings na árvore
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // Método para realizar a busca pela chave
    public boolean pesquisa(int chave) {
        return arvoreB.pesquisa(chave);
    }

    public boolean pesquisa(int chave, int Busca) {
        return arvoreB.pesquisa(chave, Busca);
    }

    public boolean pesquisa(String chave, int Busca) {
        return arvoreB.pesquisa(chave, Busca);
    }

    // Método para obter o valor associado à chave
    public String[] getValorChave(int chave) {
        return arvoreB.getValorChave(chave);
    }

    public String[] getValorChave(int chave, int busca) {
        return arvoreB.getValorChave(chave, busca);
    }

    public String[] getValorChave(String chave, int busca) {
        return arvoreB.getValorChave(chave, busca);
    }

    public void imprimeArvore() {
        System.out.println("Estrutura da Árvore B:");
        arvoreB.imprime();
    }

    public static void main(String[] args) {
        Insere_Arvore insereArvore = new Insere_Arvore(2);

        String caminhoArquivo = "../Dex/Dex.arb";  // Arquivo de exemplo
        insereArvore.insereDoArquivo(caminhoArquivo, 0);

        insereArvore.imprimeArvore();

        // Testando pesquisas
        int[] chavesTeste = {10, 100, 30, 5, 17};
        for (int chave : chavesTeste) {
            if (insereArvore.pesquisa(chave)) {
                System.out.println("Chave " + chave + " encontrada.");
            } else {
                System.out.println("Chave " + chave + " não encontrada.");
            }
        }
    }
}
