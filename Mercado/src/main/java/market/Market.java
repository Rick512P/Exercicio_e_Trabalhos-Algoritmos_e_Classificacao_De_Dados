package market;

import java.util.ArrayList;

public class Market {

  // private enum Resultado{ GANHOU, PERDEU};

  private Produto produto;
  ArrayList<Produto> compras = new ArrayList<Produto>();

  public void addProduto(Produto produto, Item item, int posicao) {
    if (produto.getquantidadeEstoque() != 0) {
      if (item.getQuantidadeItem() > produto.getquantidadeEstoque()) {
        item.setQuantidadeItem(produto.getquantidadeEstoque());
      } else {
        item.setQuantidadeItem(item.getQuantidadeItem());
      }

      this.produto = new Produto(produto.getpreco(), item.getQuantidadeItem(), produto.getdescricao());

      compras.add(posicao, produto);
    }
  }

  public String toString(TipoPagamento tipoPagamento, Cliente cliente) // Cria Nota Fiscal
  {
    double Total = 0;
    int Total_itens = 0;
    StringBuilder ret = new StringBuilder("");
    ret.append("Cliente: " + cliente.getNome());
    ret.append(cliente.getCPF());
    ret.append("\nProdutos\n  ");
    for (Produto i : compras) {
      Total += (i.getpreco() * i.getquantidadeEstoque());
      Total_itens += i.getquantidadeEstoque();

      ret.append(i.getdescricao());
      ret.append(": Quant.");
      ret.append(i.getquantidadeEstoque());
      ret.append("x");
      ret.append(" Valor uni.: R$");
      ret.append(i.getpreco());
      ret.append(" Valor Total: R$");
      ret.append(i.getpreco() * i.getquantidadeEstoque());
      ret.append("\n  ");
    }

    ret.append(String.format("\nTotal de Itens: " + Total_itens + "\n"));
    ret.append(String.format("Total: %.2f\n", Total));
    ret.append("Tipo de Pagamento: " + tipoPagamento + "\n");
    return ret.toString();
  }

  public void ClearListaVenda() {
    compras.clear();
  }

  public void Venda(Produto p) {
    for (Produto c : compras) {
      if (c.getdescricao() == p.getdescricao()) {
        p.compra(c.getquantidadeEstoque());
      }
    }
  }

  public static void main(String[] args) {
    Market mk = new Market();
    Produto p1 = new Produto(10, 5, Descricao.ARROZ);
    Produto p2 = new Produto(20, 5, Descricao.FARINHA);
    Produto p3 = new Produto(30, 5, Descricao.LEITE);
    Produto p4 = new Produto(40, 5, Descricao.FEIJAO);
    Produto p5 = new Produto(50, 5, Descricao.OVOS);
    Cliente c1 = new Cliente("Fulano", "000.000.000-00");

    TipoPagamento tp1 = TipoPagamento.DINHEIRO;

    mk.addProduto(p1, new Item(1), 0);
    mk.addProduto(p2, new Item(1), 1);
    mk.addProduto(p3, new Item(1), 2);
    mk.addProduto(p4, new Item(1), 3);
    mk.addProduto(p5, new Item(1), 4);
    System.out.println(mk.toString(tp1, c1));

    mk.Venda(p1);
    mk.Venda(p2);
    mk.Venda(p3);
    mk.Venda(p4);
    mk.Venda(p5);

  }
}