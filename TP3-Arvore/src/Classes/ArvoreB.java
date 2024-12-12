package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class ArvoreB {
    private No raiz;
    private final int grauMinimo;

    private static class No {
        ArrayList<String[]> chaves;  // Vetores de 3 elementos
        ArrayList<No> filhos;
        boolean folha;

        No(boolean folha) {
            this.folha = folha;
            this.chaves = new ArrayList<>();
            this.filhos = new ArrayList<>();
        }
    }

    public ArvoreB(int grauMinimo) {
        this.grauMinimo = grauMinimo;
        this.raiz = new No(true);
    }

    // Pesquisa uma chave na árvore
    public boolean pesquisa(int chave) {
        return pesquisa(this.raiz, chave) != null;
    }

    public boolean pesquisa(String chave) {
        return pesquisa(this.raiz, chave) != null;
    }

    public boolean pesquisa(int chave, int Busca) {
        return pesquisa(this.raiz, chave, Busca) != null;
    }

    public boolean pesquisa(String chave, int Busca) {
        return pesquisa(this.raiz, chave, Busca) != null;
    }

    private No pesquisa(No no, int chave) {
        int i = 0;

        while (i < no.chaves.size() && chave > Integer.parseInt(no.chaves.get(i)[0]))
            i++;

        if (i < no.chaves.size() && chave == Integer.parseInt(no.chaves.get(i)[0])) {
            System.out.println("Elemento encontrado: " + Arrays.toString(no.chaves.get(i)));
            return no;
        }

        if (no.folha)
            return null;

        return pesquisa(no.filhos.get(i), chave);
    }

    private No pesquisa(No no, String chave) {
        int i = 0;

        while (i < no.chaves.size() && chave.compareToIgnoreCase(no.chaves.get(i)[1]) > 0) i++;

        if (i < no.chaves.size() && chave.compareToIgnoreCase(no.chaves.get(i)[1]) == 0){
            System.out.println("Elemento encontrado: " + Arrays.toString(no.chaves.get(i)));
            return no;
        }

        if (no.folha)
            return null;

        return pesquisa(no.filhos.get(i), chave);
    }

    private No pesquisa(No no, int chave, int Busca) {
        int i = 0;

        while (i < no.chaves.size() && chave > Integer.parseInt(no.chaves.get(i)[0]))
            i++;

        if (i < no.chaves.size() && chave == Integer.parseInt(no.chaves.get(i)[0])) {
            return no;
        }

        if (no.folha)
            return null;

        return pesquisa(no.filhos.get(i), chave, Busca);
    }

    private No pesquisa(No no, String chave, int Busca) {
        int i = 0;
        // Normaliza a chave de busca (remove caracteres especiais e ignora maiúsculas/minúsculas)
        String chaveNormalizada = chave.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    
        while (i < no.chaves.size() && chaveNormalizada.compareTo(no.chaves.get(i)[1].trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase()) > 0) {
            i++;
        }
    
        if (i < no.chaves.size() && chaveNormalizada.compareTo(no.chaves.get(i)[1].trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase()) == 0) {
            return no;
        }
    
        if (no.folha) {
            return null;
        }
    
        return pesquisa(no.filhos.get(i), chave, Busca);
    }
    

    public void insere(String[] elemento) {
        No r = this.raiz;

        if (r.chaves.size() == 2 * grauMinimo - 1) {
            No novo = new No(false);
            this.raiz = novo;
            novo.filhos.add(r);
            divideFilho(novo, 0, r);
            insereNaoCheio(novo, elemento);
        } else {
            insereNaoCheio(r, elemento);
        }
        System.out.println("Inserindo chave: " + Arrays.toString(elemento));
        System.out.println("Árvore após a inserção:");
        imprime();

    }

    public void insere(String[] elemento, int tipo) {
        No r = this.raiz;
            if (r.chaves.size() == 2 * grauMinimo - 1) {
                No novo = new No(false);
                this.raiz = novo;
                novo.filhos.add(r);
                divideFilho(novo, 0, r);
                insereNaoCheio(novo, elemento, tipo);
            } else {
                insereNaoCheio(r, elemento, tipo);
            }
            System.out.println("Inserindo chave: " + Arrays.toString(elemento));
            System.out.println("Árvore após a inserção:");
            imprime();

    }

    private void insereNaoCheio(No no, String[] elemento) {
        int chave = Integer.parseInt(elemento[0]);
        int i = no.chaves.size() - 1;

        if (no.folha) {
            no.chaves.add(null);  // Espaço para o novo elemento

            while (i >= 0 && chave < Integer.parseInt(no.chaves.get(i)[0])) {
                no.chaves.set(i + 1, no.chaves.get(i));
                i--;
            }

            no.chaves.set(i + 1, elemento);
        } else {
            while (i >= 0 && chave < Integer.parseInt(no.chaves.get(i)[0]))
                i--;

            i++;

            if (no.filhos.get(i).chaves.size() == 2 * grauMinimo - 1) {
                divideFilho(no, i, no.filhos.get(i));

                if (chave > Integer.parseInt(no.chaves.get(i)[0]))
                    i++;
            }

            insereNaoCheio(no.filhos.get(i), elemento);
        }
    }

    private void insereNaoCheio(No no, String[] elemento, int tipo) {
        if (tipo == 0) {
            // Caso para inteiros
            int chave = Integer.parseInt(elemento[0]);
            int i = no.chaves.size() - 1;
    
            if (no.folha) {
                no.chaves.add(null); // Espaço para o novo elemento
    
                while (i >= 0 && chave < Integer.parseInt(no.chaves.get(i)[0])) {
                    no.chaves.set(i + 1, no.chaves.get(i));
                    i--;
                }
    
                no.chaves.set(i + 1, elemento);
            } else {
                while (i >= 0 && chave < Integer.parseInt(no.chaves.get(i)[0]))
                    i--;
    
                i++;
    
                if (no.filhos.get(i).chaves.size() == 2 * grauMinimo - 1) {
                    divideFilho(no, i, no.filhos.get(i));
    
                    if (chave > Integer.parseInt(no.chaves.get(i)[0]))
                        i++;
                }
    
                insereNaoCheio(no.filhos.get(i), elemento, tipo);
            }
        } else {
            // Caso para strings
            String chave = elemento[1];
            int i = no.chaves.size() - 1;
    
            if (no.folha) {
                no.chaves.add(null); // Espaço para o novo elemento
    
                while (i >= 0 && chave.compareToIgnoreCase(no.chaves.get(i)[1]) < 0) {
                    no.chaves.set(i + 1, no.chaves.get(i));
                    i--;
                }
    
                no.chaves.set(i + 1, elemento);
            } else {
                while (i >= 0 && chave.compareToIgnoreCase(no.chaves.get(i)[1]) < 0)
                    i--;
    
                i++;
    
                if (no.filhos.get(i).chaves.size() == 2 * grauMinimo - 1) {
                    divideFilho(no, i, no.filhos.get(i));
    
                    if (chave.compareToIgnoreCase(no.chaves.get(i)[1]) > 0)
                        i++;
                }
    
                insereNaoCheio(no.filhos.get(i), elemento, tipo);
            }
        }
    }

    private void divideFilho(No pai, int i, No filho) {
        //System.out.println("Dividindo o nó: " + noParaString(filho));
        No novo = new No(filho.folha);
        int meio = grauMinimo - 1;

        // Transferência de chaves e filhos
        for (int j = 0; j < meio; j++)
            novo.chaves.add(filho.chaves.remove(grauMinimo));

        if (!filho.folha)
            for (int j = 0; j <= meio; j++)
                novo.filhos.add(filho.filhos.remove(grauMinimo));

        pai.filhos.add(i + 1, novo);
        pai.chaves.add(i, filho.chaves.remove(grauMinimo - 1));
        //System.out.println("Novo nó criado: " + noParaString(novo));
        //System.out.println("Pai atualizado: " + noParaString(pai));
    }

    // Exibe a árvore
    public void imprime() {
        imprime(this.raiz, 0);
    }

    private void imprime(No no, int nivel) {
        System.out.println("Nível " + nivel + " " + noParaString(no));

        if (!no.folha) {
            for (No filho : no.filhos)
                imprime(filho, nivel + 1);
        }
    }

    // Método getValorChave
    public String[] getValorChave(int chave) {
        No no = pesquisa(this.raiz, chave   );  // Localiza o nó
        if (no != null) {
            for (String[] chaveValor : no.chaves) {
                if (Integer.parseInt(chaveValor[0]) == chave) {
                    return chaveValor;  // Retorna o vetor de 3 elementos
                }
            }
        }
        return null;  // Se a chave não for encontrada
    }

    public String[] getValorChave(int chave, int Busca) {
        No no = pesquisa(this.raiz, chave, Busca);  // Localiza o nó
        if (no != null) {
            for (String[] chaveValor : no.chaves) {
                if (Integer.parseInt(chaveValor[0]) == chave) {
                    return chaveValor;  // Retorna o vetor de 3 elementos
                }
            }
        }
        return null;  // Se a chave não for encontrada
    }

    public String[] getValorChave(String chave, int Busca) {
        No no = pesquisa(this.raiz, chave, Busca);  // Localiza o nó
        if (no != null) {
            String chaveNormalizada = chave.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            for (String[] chaveValor : no.chaves) {
                if (chaveNormalizada.equals(chaveValor[1].trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase())) {
                    return chaveValor;  // Retorna o vetor de 3 elementos
                }
            }
        }
        return null;  // Se a chave não for encontrada
    }

    // Para printar corretamente:
    private String noParaString(No no) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String[] chave : no.chaves) {
            sb.append(Arrays.toString(chave)).append(", ");
        }
        if (!no.chaves.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove a última vírgula
        }
        sb.append("]");
        return sb.toString();
    }

    
    
    
    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB(2);

        arvore.insere(new String[]{"10", "Mensagem A", "Mensagem B"});
        arvore.insere(new String[]{"20", "Mensagem C", "Mensagem D"});
        arvore.insere(new String[]{"5", "Mensagem E", "Mensagem F"});
        arvore.insere(new String[]{"6", "Mensagem G", "Mensagem H"});
        arvore.insere(new String[]{"12", "Mensagem I", "Mensagem J"});
        arvore.insere(new String[]{"30", "Mensagem K", "Mensagem L"});
        arvore.insere(new String[]{"7", "Mensagem M", "Mensagem N"});
        arvore.insere(new String[]{"17", "Mensagem O", "Mensagem P"});
        arvore.insere(new String[]{"100", "Mensagem Q", "Mensagem R"});

        System.out.println("Estrutura da Árvore B-ID:");
        arvore.imprime();

        System.out.println("");
        System.out.println("");
        ArvoreB nome = new ArvoreB(2);

        nome.insere(new String[]{"10", "A", "Mensagem B"}, 1);
        nome.insere(new String[]{"20", "C", "Mensagem D"}, 1);
        nome.insere(new String[]{"5", "E", "Mensagem F"}, 1);
        nome.insere(new String[]{"6", "B", "Mensagem H"}, 1);
        nome.insere(new String[]{"12", "D", "Mensagem J"}, 1);
        nome.insere(new String[]{"30", "K", "Mensagem L"}, 1);
        nome.insere(new String[]{"7", "J", "Mensagem N"}, 1);
        nome.insere(new String[]{"17", "H", "Mensagem P"}, 1);
        nome.insere(new String[]{"100", "I", "Mensagem R"}, 1);

        System.out.println("Pesquisa: E");
        nome.pesquisa("e");
        System.out.println("Estrutura da Árvore B-Nome:");
        nome.imprime();

        System.out.println("");
        System.out.println("");
    }
}
