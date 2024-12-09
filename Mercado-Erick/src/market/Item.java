package market;

public class Item {
  private int quantidadeItem; // declara variavel
  public Produto produto; // declara variavel

  public Item(int quantidadeItem, Produto produto) // construtor variavel
  {
    this.quantidadeItem = quantidadeItem;
    this.produto = produto;
  }

  public Item() // construtor padrão
  {
    this.quantidadeItem = 0;
    this.produto = new Produto();
  }

  public void setQuantidadeItem(int quantidadeItem) // seta quantidade desejada
  {
    this.quantidadeItem = quantidadeItem;
  }

  public int getQuantidadeItem() // retorna quantidade desejada
  {
    return quantidadeItem;
  }

  //main padrão de testes
  public static void main(String[] args) {
    Item i = new Item(5, new Produto(10, 5, Descricao.ARROZ));
    System.out.println(i.getQuantidadeItem());
  }
}