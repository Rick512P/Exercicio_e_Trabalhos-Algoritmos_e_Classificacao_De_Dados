package market;

public class Item {
  private int quantidadeItem;

  public Item(int quantidadeItem) {
    this.quantidadeItem = quantidadeItem;
  }

  public Item() {
    this.quantidadeItem = 0;
  }

  public void setQuantidadeItem(int quantidadeItem) {
    this.quantidadeItem = quantidadeItem;
  }

  public int getQuantidadeItem() {
    return quantidadeItem;
  }

  public static void main(String[] args) {
    Item i = new Item(5);
    System.out.println(i.getQuantidadeItem());
  }
}