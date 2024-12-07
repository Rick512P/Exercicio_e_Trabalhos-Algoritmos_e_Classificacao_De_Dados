package mercado;

public class Item {
  public Produto produto;
  private int quantidade;

  // construtor
  public Item(Produto produto, int quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
  }

  // construtor padrao
  public Item() {
    produto = new Produto();
    quantidade = 0;
  }

  public void setQuantidade(int quantidade) {
    if (quantidade > 0) { //nao aceitarei quantidade negativa
      this.quantidade = quantidade;
    } else {
      System.out.println("Quantidade inválida");
    }
  }

  public int getQuantidade() {
    return quantidade;
  }

  public Produto getProduto() {
    return produto;
  }
}