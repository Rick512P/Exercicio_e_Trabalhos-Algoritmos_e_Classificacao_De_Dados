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

    // Método para ler arquivo e inserir na árvore
    public void insereDoArquivo(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes.length == 3) {
                    String[] elemento = new String[3];
                    elemento[0] = partes[0].trim();  // Número como String
                    elemento[1] = partes[1].trim();  // Nome
                    elemento[2] = partes[2].trim();  // Tipo

                    try {
                        Integer.parseInt(elemento[0]);  // Validação de número
                        arvoreB.insere(elemento);
                    } catch (NumberFormatException e) {
                        System.out.println("Chave inválida: " + linha);
                    }
                } else {
                    System.out.println("Formato inválido na linha: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void imprimeArvore() {
        System.out.println("Estrutura da Árvore B:");
        arvoreB.imprime();
    }

    public void pesquisa(int chave) {
        boolean encontrado = arvoreB.pesquisa(chave);
        if (!encontrado) {
            System.out.println("Chave " + chave + " não encontrada.");
        }
    }

    public static void main(String[] args) {
        Insere_Arvore insereArvore = new Insere_Arvore(2);

        // Arquivo de exemplo
        String caminhoArquivo = "Dex/Dex.arb";
        insereArvore.insereDoArquivo(caminhoArquivo);

        insereArvore.imprimeArvore();
        insereArvore.pesquisa(1);
    }
}
