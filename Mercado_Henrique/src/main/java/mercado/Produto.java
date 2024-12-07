package mercado;

public class Produto {
  private Nomes nome;
  private double preco;
  private int quantidadeEst;

  // construtor
  public Produto(Nomes nome, double preco, int quantidadeEst) {
    this.nome = nome;
    this.preco = preco;
    this.quantidadeEst = quantidadeEst;
  }
  //construtor padrao
  public Produto(){
    nome = nome.refrigerante;
    preco = 0;
    quantidadeEst = 100;
  }
    
  public String getNome() {
      return nome.name(); // Retorna a string do enum
  }

  public double getPreco() {
    return preco;
  }

  public int getQuantidadeEst() {
    return quantidadeEst;
  }

  public void compra(int quantidade) {
      if (quantidade <= this.quantidadeEst) {
          this.quantidadeEst -= quantidade;
      } else {
          System.out.println("Quantidade em estoque insuficiente.");
      }
  }

}