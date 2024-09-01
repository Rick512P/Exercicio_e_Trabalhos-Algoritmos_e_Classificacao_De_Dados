package market;

public class Produto {

  private int quantidadeEstoque;
  private double preco;
  private Descricao descricao;

  public Produto(double preco, int quantidadeEstoque, Descricao descricao) {
    this.preco = preco;
    this.quantidadeEstoque = quantidadeEstoque;
    this.descricao = descricao;
  }

  public Produto() // produto padrão
  {
    preco = 0;
    quantidadeEstoque = 5;
    descricao = Descricao.ARROZ;
  }

  public int getquantidadeEstoque() {
    return quantidadeEstoque;
  }

  public double getpreco() {
    return preco;
  }

  public Descricao getdescricao() {
    return descricao;
  }

  public void compra(int quantidade) {
    quantidadeEstoque = quantidadeEstoque - quantidade;
  }

  public static void main(String[] args) {
    Produto p = new Produto();
    System.out.println(p.getpreco());
    System.out.println(p.getquantidadeEstoque());
    System.out.println(p.getdescricao());
    p.compra(1);
    System.out.println(p.getquantidadeEstoque());
  }

}