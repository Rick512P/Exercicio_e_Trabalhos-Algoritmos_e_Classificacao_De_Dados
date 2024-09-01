package market;

import java.util.Scanner;

public class MarketApp {

  public static void main(String[] args) {
    Produto p1 = new Produto(10, 5, Descricao.ARROZ);
    Produto p2 = new Produto(20, 5, Descricao.FEIJAO);
    Produto p3 = new Produto(30, 5, Descricao.LEITE);
    Produto p4 = new Produto(40, 5, Descricao.FARINHA);
    Produto p5 = new Produto(50, 5, Descricao.OVOS);

    int contador = 0;

    TipoPagamento tp = TipoPagamento.NENHUM;

    Cliente cliente = new Cliente();
    Market mk = new Market();

    Scanner inputop = new Scanner(System.in);
    Scanner inputlistaop = new Scanner(System.in);
    Scanner inputName = new Scanner(System.in);
    Scanner inputCPF = new Scanner(System.in);
    Scanner inputTipoPagamento = new Scanner(System.in);
    Scanner inputQuantidade = new Scanner(System.in);
    Scanner inputProduto = new Scanner(System.in);

    int opcao, listaop;
    do {
      System.out.println("Menu:");
      System.out.println("(1): Novo Pedido");
      System.out.println("(2): Realizar Pagamento");
      System.out.println("(0): Sair");
      opcao = inputop.nextInt();
      switch (opcao) {
        case 1:
          System.out.println("Digite o nome do cliente: ");
          String nome = inputName.nextLine();
          System.out.println("Digite o CPF do cliente: ");
          String CPF = inputCPF.nextLine();
          cliente = new Cliente(nome, CPF);
          System.out.println("Digite o tipo de pagamento: ");
          String tipoPagamento = inputTipoPagamento.nextLine().toUpperCase();
          try {
            tp = TipoPagamento.valueOf(tipoPagamento);
            do {
              System.out.println("P/ Continuar, digite 1; p/ Sair, digite 0");
              listaop = inputlistaop.nextInt();

              switch (listaop) {
                case 1:
                  System.out.println("Digite o produto: ");
                  String produto = inputProduto.nextLine();
                  System.out.println("Digite a quantidade do produto: ");
                  int quantidade = inputQuantidade.nextInt();
                  if (produto.equalsIgnoreCase(p1.getdescricao().name())) {
                    mk.addProduto(p1, new Item(quantidade), contador);
                  } else if (produto.equalsIgnoreCase(p2.getdescricao().name())) {
                    mk.addProduto(p2, new Item(quantidade), contador);
                  } else if (produto.equalsIgnoreCase(p3.getdescricao().name())) {
                    mk.addProduto(p3, new Item(quantidade), contador);
                  } else if (produto.equalsIgnoreCase(p4.getdescricao().name())) {
                    mk.addProduto(p4, new Item(quantidade), contador);
                  } else if (produto.equalsIgnoreCase(p5.getdescricao().name())) {
                    mk.addProduto(p5, new Item(quantidade), contador);
                  } else {
                    System.out.println("Produto Não Encontrado");
                    contador--;
                  }
                  contador++;
                  break;
                case 0:
                  break;
              }
            } while (listaop != 0);
          } catch (IllegalArgumentException e) {
            System.out.println("Tipo de pagamento inválido. Por favor, escolha entre DINHEIRO, CARTAO ou CHEQUE.");
          }
          break;

        case 2:
          if (tp != TipoPagamento.NENHUM) {
            System.out.println(mk.toString(tp, cliente));
            for (Produto i : mk.compras) {
              mk.Venda(i);
            }
            mk.ClearListaVenda();
            tp = TipoPagamento.NENHUM;
          } else {
            System.out.println("Nenhum tipo de pagamento foi selecionado");
          }
          break;

        case 0:
          break;
        default:
          System.out.println("Opcao Invalida");
          break;
      }
    } while (opcao != 0);
  }
}