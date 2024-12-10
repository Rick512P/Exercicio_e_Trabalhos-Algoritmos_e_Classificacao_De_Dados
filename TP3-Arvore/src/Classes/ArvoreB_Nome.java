package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class ArvoreB_Nome {
    private No raiz;
    private final int grauMinimo;

    public class No {
        ArrayList<String[]> chaves;  // Vetores de 3 elementos
        ArrayList<No> filhos;
        boolean folha;
    
        public No(boolean folha) {
            this.folha = folha;
            this.chaves = new ArrayList<>();
            this.filhos = new ArrayList<>();
        }

    }

    public ArvoreB_Nome(int grauMinimo) {
        this.grauMinimo = grauMinimo;
        this.raiz = new No(true);
    }

    public boolean pesquisa(String nome) {
        return pesquisa(this.raiz, nome) != null;
    }

    private No pesquisa(No no, String nome) {
        System.out.println("Buscando chave: " + nome + " no nó: " + no.chaves); // Exibe o nó atual
    
        int i = 0;
        while (i < no.chaves.size() && nome.compareTo(no.chaves.get(i)[1]) > 0) {
            i++;
        }
    
        if (i < no.chaves.size() && nome.equals(no.chaves.get(i)[1])) {
            System.out.println("Chave encontrada no nó: " + Arrays.toString(no.chaves.get(i))); // Chave encontrada
            return no;
        }
    
        if (no.folha) {
            System.out.println("Chave não encontrada na folha."); // Não encontrou e chegou a uma folha
            return null;
        }
    
        return pesquisa(no.filhos.get(i), nome);
    }
    

    public void insere(String[] elemento) {
        //System.out.println("Inserindo elemento: " + Arrays.toString(elemento)); // Mensagem de depuração
    
        No r = this.raiz;
    
        if (r.chaves.size() == 2 * grauMinimo - 1) {
            //System.out.println("Dividindo a raiz..."); // Indica que a raiz está cheia e será dividida
            No novo = new No(false);
            this.raiz = novo;
            novo.filhos.add(r);
            divideFilho(novo, 0, r);
            insereNaoCheio(novo, elemento);
        } else {
            insereNaoCheio(r, elemento);
        }
    }
    

    private void insereNaoCheio(No no, String[] elemento) {
        String chave = elemento[1];
        int i = no.chaves.size() - 1;
    
        //System.out.println("Inserindo no nó: " + no.chaves + ", chave: " + chave); // Depuração do nó atual
    
        if (no.folha) {
            no.chaves.add(null);
    
            while (i >= 0 && chave.compareTo(no.chaves.get(i)[1]) < 0) {
                no.chaves.set(i + 1, no.chaves.get(i));
                i--;
            }
    
            no.chaves.set(i + 1, elemento);
            //System.out.println("Chave inserida na folha: " + Arrays.toString(elemento)); // Confirma a inserção na folha
        } else {
            while (i >= 0 && chave.compareTo(no.chaves.get(i)[1]) < 0) {
                i--;
            }
    
            i++;
    
            if (no.filhos.get(i).chaves.size() == 2 * grauMinimo - 1) {
                //System.out.println("Dividindo filho no índice: " + i); // Indica a divisão de um filho
                divideFilho(no, i, no.filhos.get(i));
    
                if (chave.compareTo(no.chaves.get(i)[1]) > 0) {
                    i++;
                }
            }
    
            insereNaoCheio(no.filhos.get(i), elemento);
        }
    }
    

    private void divideFilho(No pai, int i, No filho) {
        No novo = new No(filho.folha);
        int meio = grauMinimo - 1;

        for (int j = 0; j < meio; j++)
            novo.chaves.add(filho.chaves.remove(grauMinimo));

        if (!filho.folha)
            for (int j = 0; j <= meio; j++)
                novo.filhos.add(filho.filhos.remove(grauMinimo));

        pai.filhos.add(i + 1, novo);
        pai.chaves.add(i, filho.chaves.remove(grauMinimo - 1));
    }

    public String[] getValorChave(String nome) {
        No no = pesquisa(this.raiz, nome);  // Localiza o nó
        if (no != null) {
            for (String[] chaveValor : no.chaves) {
                if (chaveValor[1].equals(nome)) {
                    return chaveValor;  // Retorna o vetor de 3 elementos
                }
            }
        }
        return null;  // Se o nome não for encontrado
    }


    public void imprime() {
        imprime(raiz, 0);
    }
    
    private void imprime(No no, int nivel) {
        // Exibe o nível e o nó atual
        System.out.println("Nível " + nivel + ": " + no);
    
        // Recursivamente imprime os filhos, se existirem
        if (!no.folha) {
            for (No filho : no.filhos) {
                imprime(filho, nivel + 1);
            }
        }
    }
    

    
}
