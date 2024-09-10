package market;

import java.util.ArrayList;

public class Pedido {

  private Item item;// cria produto padrão
  ArrayList<Item> compras = new ArrayList<Item>();// cria lista de compras

  public void addItem(Item item, int posicao) // adiciona produto na lista de compras
  {
    if (item.produto.getquantidadeEstoque() != 0 && item.getQuantidadeItem() >= 0) // verifica se o produto está em estoque e se a quantidade em estoque é válida
    {
      if (item.getQuantidadeItem() >= item.produto.getquantidadeEstoque()) {
        item.setQuantidadeItem(item.produto.getquantidadeEstoque());
      }
      compras.add(posicao, item);
      Venda(item.produto);
    }
  }

  public String toString(TipoPagamento tipoPagamento, Cliente cliente) // Cria Nota Fiscal
  {
    double Total = 0;
    int Total_itens = 0;
    StringBuilder ret = new StringBuilder("");
    ret.append("Cliente: " + cliente.getNome() + " CPF: ");
    ret.append(cliente.getCPF());
    ret.append("\nProdutos\n  ");
    for (Item i : compras) {
      Total += (i.produto.getpreco() * i.getQuantidadeItem());
      Total_itens += i.getQuantidadeItem();

      ret.append(i.produto.getdescricao());
      ret.append(": Quant.");
      ret.append(i.getQuantidadeItem());
      ret.append("x");
      ret.append(" Valor uni.: R$");
      ret.append(i.produto.getpreco());
      ret.append(" Valor Total: R$");
      ret.append(i.produto.getpreco() * i.getQuantidadeItem());
      ret.append("\n  ");
    }

    ret.append(String.format("\nTotal de Itens: " + Total_itens + "\n"));
    ret.append(String.format("Total: %.2f\n", Total));
    ret.append("Tipo de Pagamento: " + tipoPagamento + "\n");
    return ret.toString();
  }

  public void ClearListaVenda() // limpa lista de compras
  {
    compras.clear();
  }

  public void Venda(Produto p) // verifica se o produto da lista de compras é o mesmo de p (presente no 'BD') e realiza a compra de acordo com a quantidade desejada
  {
    for (Item c : compras) {
      if (c.produto.getdescricao() == p.getdescricao()) {
        p.compra(c.getQuantidadeItem());
      }
    }
  }

  // main padrão de testes
  public static void main(String[] args) {
    Pedido Pe = new Pedido();

    Produto p1 = new Produto(10, 5, Descricao.ARROZ);
    Produto p2 = new Produto(20, 5, Descricao.FARINHA);
    Produto p3 = new Produto(30, 5, Descricao.LEITE);
    Produto p4 = new Produto(40, 5, Descricao.FEIJAO);
    Produto p5 = new Produto(50, 5, Descricao.OVOS);
    
    Item i1 = new Item(4, p1);
    Item i2 = new Item(4, p2);
    Item i3 = new Item(4, p3);
    Item i4 = new Item(4, p4);
    Item i5 = new Item(4, p5);
    

    Cliente c1 = new Cliente("Fulano", "000.000.000-00");

    TipoPagamento tp1 = TipoPagamento.DINHEIRO;

    Pe.addItem(i1, 0);
    Pe.addItem(i2, 1);
    Pe.addItem(i3, 2);
    Pe.addItem(i4, 3);
    Pe.addItem(i5, 4);
    
    System.out.println(Pe.toString(tp1, c1));
  }
}