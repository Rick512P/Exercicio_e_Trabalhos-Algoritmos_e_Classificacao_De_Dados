package market;

import java.util.Scanner;

public class MarketApp {

  public static void main(String[] args) {
    //Definição de variáveis
    Produto p1 = new Produto(10, 5, Descricao.ARROZ);
    Produto p2 = new Produto(20, 5, Descricao.FEIJAO);
    Produto p3 = new Produto(30, 5, Descricao.LEITE);
    Produto p4 = new Produto(40, 5, Descricao.FARINHA);
    Produto p5 = new Produto(50, 5, Descricao.OVOS);

    int contador = 0;

    TipoPagamento tp = TipoPagamento.NENHUM;

    Cliente cliente = new Cliente();
    Pedido Pe = new Pedido();

    //Definição de Scanner
    Scanner inputop = new Scanner(System.in);
    Scanner inputlistaop = new Scanner(System.in);
    Scanner inputName = new Scanner(System.in);
    Scanner inputCPF = new Scanner(System.in);
    Scanner inputTipoPagamento = new Scanner(System.in);
    Scanner inputQuantidade = new Scanner(System.in);
    Scanner inputProduto = new Scanner(System.in);

    int opcao, listaop;
    //loop do menu
    do {
      System.out.println("Menu:");
      System.out.println("(1): Novo Pedido");
      System.out.println("(2): Realizar Pagamento");
      System.out.println("(0): Sair");
      opcao = inputop.nextInt();
      switch (opcao) {
        case 1:
          if (contador == 0) {
            System.out.println("\nDigite o nome do cliente: ");
            String nome = inputName.nextLine();
            System.out.println("\nDigite o CPF do cliente: ");
            String CPF = inputCPF.nextLine();
            cliente = new Cliente(nome, CPF);
            System.out.println("\nDigite o tipo de pagamento: ");
            String tipoPagamento = inputTipoPagamento.nextLine().toUpperCase();
            try {
              tp = TipoPagamento.valueOf(tipoPagamento);
              //loop de criação de lista de compras
              do {
                System.out.println("\n-----------------------------------------");
                System.out.println("\nP/ Continuar, digite 1; p/ Sair, digite 0");
                listaop = inputlistaop.nextInt();

                switch (listaop) {
                  case 1:
                    System.out.println("\n------------------------------------------");
                    System.out.println("\nDigite o produto: ");
                    String produto = inputProduto.nextLine();
                    System.out.println("\n------------------------------------------");
                    System.out.println("\nDigite a quantidade do produto: ");
                    int quantidade = inputQuantidade.nextInt();
                    if (produto.equalsIgnoreCase(p1.getdescricao().name())) {
                      Pe.addItem(new Item(quantidade, p1), contador);
                    } else if (produto.equalsIgnoreCase(p2.getdescricao().name())) {
                      Pe.addItem(new Item(quantidade, p2), contador);
                    } else if (produto.equalsIgnoreCase(p3.getdescricao().name())) {
                      Pe.addItem(new Item(quantidade, p3), contador);
                    } else if (produto.equalsIgnoreCase(p4.getdescricao().name())) {
                      Pe.addItem(new Item(quantidade, p4), contador);
                    } else if (produto.equalsIgnoreCase(p5.getdescricao().name())) {
                      Pe.addItem(new Item(quantidade, p5), contador);
                    } else {
                      System.out.println("Produto Não Encontrado");
                      System.out.println("\n-----------------------------------\n\n");
                      contador--;
                    }
                    contador++;
                    break;
                  case 0:
                    break;
                }
                System.out.println("\n-----------------------------------\n\n");
              } while (listaop != 0);
            } catch (IllegalArgumentException e) {
              System.out.println("Tipo de pagamento inválido. Por favor, escolha entre DINHEIRO, CARTAO ou CHEQUE.");
              System.out.println("\n-----------------------------------\n\n");
            }
          } else {
            System.out.println("Outra compra está em andamento! Realize o Pagamento!");
            System.out.println("\n-----------------------------------\n\n");
          }
          break;

        case 2:
          // venda/finalização da compra
          if (tp != TipoPagamento.NENHUM) {
            System.out.println("\n---------------------------------------------------------------------\n");
            System.out.println(Pe.toString(tp, cliente));
            System.out.println("\n---------------------------------------------------------------------\n\n");
            
            Pe.ClearListaVenda();
            contador = 0;
            tp = TipoPagamento.NENHUM;
          } else {
            System.out.println("Não há nenhuma compra em andamento!");
            System.out.println("\n-----------------------------------\n\n");
          }
          break;

        case 0:
          break;
        default:
          System.out.println("Opcao Invalida");
          System.out.println("\n-----------------------------------\n\n");
          break;
      }
    } while (opcao != 0);
  
    inputop.close();
    inputlistaop.close();
    inputName.close();
    inputCPF.close();
    inputTipoPagamento.close();
    inputQuantidade.close();
    inputProduto.close();
  
  }
}