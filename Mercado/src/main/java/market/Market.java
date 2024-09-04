package market;

import java.util.ArrayList;

public class Market {

  private Produto produto;//cria produto padrão
  ArrayList<Produto> compras = new ArrayList<Produto>();//cria lista de compras

  public void addProduto(Produto produto, Item item, int posicao) //adiciona produto na lista de compras
  {
    if (produto.getquantidadeEstoque() != 0 && item.getQuantidadeItem() >= 0) //verifica se o produto está em estoque e se a quantidade desejada é maior que a quantidade em estoque
    {
      if (item.getQuantidadeItem() >= produto.getquantidadeEstoque()) {
        this.produto = new Produto(produto.getpreco(), produto.getquantidadeEstoque(), produto.getdescricao());
      } else {
        this.produto = new Produto(produto.getpreco(), item.getQuantidadeItem(), produto.getdescricao());
      }

      compras.add(posicao, this.produto);
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

  public void ClearListaVenda() //limpa lista de compras
  {
    compras.clear();
  }

  public void Venda(Produto p) //verifica se o produto da lista de compras é o mesmo de p (presente no 'BD') e realiza a compra de acordo com a quantidade desejada
  {
    for (Produto c : compras) {
      if (c.getdescricao() == p.getdescricao()) {
        p.compra(c.getquantidadeEstoque());
      }
    }
  }


  //main padrão de testes
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