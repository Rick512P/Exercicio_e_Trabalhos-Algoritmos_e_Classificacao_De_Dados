package market;

public class Produto {

  //Criação de variáveis
  private int quantidadeEstoque;
  private double preco;
  private Descricao descricao;

  //construtor variavel
  public Produto(double preco, int quantidadeEstoque, Descricao descricao) {
    this.preco = preco;
    this.quantidadeEstoque = quantidadeEstoque;
    this.descricao = descricao;
  }

  //construtor padrao
  public Produto() // produto padrão
  {
    preco = 0;
    quantidadeEstoque = 5;
    descricao = Descricao.ARROZ;
  }

  //retorna quantiadade de produtos em estoque
  public int getquantidadeEstoque() {
    return quantidadeEstoque;
  }

  //retorna preço do produto
  public double getpreco() {
    return preco;
  }

  //retorna qual o alimento/produto
  public Descricao getdescricao() {
    return descricao;
  }

  //retorna quantidade atualizada de produtos em estoque de acordo com a quantia comprada
  public void compra(int quantidade) {
    quantidadeEstoque = quantidadeEstoque - quantidade;
  }

  //main padrão de testes
  public static void main(String[] args) {
    Produto p = new Produto();
    System.out.println(p.getpreco());
    System.out.println(p.getquantidadeEstoque());
    System.out.println(p.getdescricao());
    p.compra(1);
    System.out.println(p.getquantidadeEstoque());
  }

}