import Classes.Insere_Arvore;

public class TP3 {
    public static void main(String[] args) {
        //Insere_Arvore.main(args);
        //ArvoreB.main(args);

        Insere_Arvore insereArvore = new Insere_Arvore(2);
        String caminhoArquivo = "Dex/Dex.arb";
        insereArvore.insereDoArquivo(caminhoArquivo);
        insereArvore.pesquisa(136);

    }
}
