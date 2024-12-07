package mercado;

import java.util.ArrayList;

public class Pedido {
  private Item item;

  ArrayList<Item> compras = new ArrayList<Item>();

  public void addItem(Item item, int posicao) // adiciona produto na lista de compras
    {
      if (item.produto.getQuantidadeEst() != 0 && item.getQuantidade() >= 0) // verifica se o produto está em estoque e se a quantidade em estoque é válida
      {
        if (item.getQuantidade() >= item.produto.getQuantidadeEst()) {
          item.setQuantidade(item.produto.getQuantidadeEst());
        }
        compras.add(posicao, item);
        Venda(item.produto);
      }
    }

  public void Venda(Produto p) // verifica se o produto da lista de compras é o mesmo de p (presente no 'BD') e realiza a compra de acordo com a quantidade desejada
    {
      for (Item c : compras) {
        if (c.produto.getNome() == p.getNome()) {
          p.compra(c.getQuantidade());
        }
      }
    }

   public String toString(Pagamentos tipoPagamento, Clientes cliente) // Cria Nota Fiscal
    {
      double Total = 0;
      int Total_itens = 0;
      StringBuilder ret = new StringBuilder("");
      ret.append("Cliente: " + cliente.getNome() + " CPF: ");
      ret.append(cliente.getCPF());
      ret.append("\nProdutos\n  ");
      for (Item i : compras) {
        Total += (i.produto.getPreco() * i.getQuantidade());
        Total_itens += i.getQuantidade();

        ret.append(i.produto.getNome());
        ret.append(": Quant.");
        ret.append(i.getQuantidade());
        ret.append("x");
        ret.append(" Valor uni.: R$");
        ret.append(i.produto.getPreco());
        ret.append(" Valor Total: R$");
        ret.append(i.produto.getPreco() * i.getQuantidade());
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
}