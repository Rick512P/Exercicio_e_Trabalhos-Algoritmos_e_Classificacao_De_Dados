package market;

public class Item {
  private int quantidadeItem; // declara variavel

  public Item(int quantidadeItem) // construtor variavel
  {
    this.quantidadeItem = quantidadeItem;
  }

  public Item() // construtor padrão
  {
    this.quantidadeItem = 0;
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
    Item i = new Item(5);
    System.out.println(i.getQuantidadeItem());
  }
}