package mercado;

import java.util.Scanner;

public class AppMercado {
  public static void main(String[] args) {
    Produto p1 = new Produto(Nomes.arroz, 5.00, 100);
    Produto p2 = new Produto(Nomes.banana, 2.00, 100);
    Produto p3 = new Produto(Nomes.feijao, 8.00, 100);
    Produto p4 = new Produto(Nomes.macarrao, 3.00, 100);
    Produto p5 = new Produto(Nomes.sorvete, 6.00, 100);
    Produto p6 = new Produto(Nomes.refrigerante, 4.00, 100);
    Produto p7 = new Produto(Nomes.cafe, 3.00, 100);
    Produto p8 = new Produto(Nomes.leite, 3.00, 100);
    Produto p9 = new Produto(Nomes.leiteCondensado, 4.00, 100);

    int contador = 0;
    Pagamentos tp = Pagamentos.NENHUM;
    Clientes cliente = new Clientes();
    Pedido Pe = new Pedido();

    // Definição de Scanner
    Scanner inputop = new Scanner(System.in);
    Scanner inputlistaop = new Scanner(System.in);
    Scanner inputName = new Scanner(System.in);
    Scanner inputCPF = new Scanner(System.in);
    Scanner inputTipoPagamento = new Scanner(System.in);
    Scanner inputQuantidade = new Scanner(System.in);
    Scanner inputProduto = new Scanner(System.in);

    int opcao, listaop;

    // loop do menu
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
            cliente = new Clientes(nome, CPF);
            System.out
                .println("\nDigite o tipo de pagamento: Por favor, escolha entre dinheiro, cartao, cheque ou pix");
            String tipoPagamento = inputTipoPagamento.nextLine().toUpperCase();
            try {
              tp = Pagamentos.valueOf(tipoPagamento);
              // loop de criação de lista de compras
              do {
                System.out.println("\n-----------------------------------------");
                System.out.println("\n1 - CONTINUAR // 0 - SAIR");
                listaop = inputlistaop.nextInt();

                switch (listaop) {
                  case 1:
                    System.out.println("\n------------------------------------------");
                    System.out.println("\nDigite o produto: ");
                    String produto = inputProduto.nextLine();
                    System.out.println("\n------------------------------------------");
                    System.out.println("\nDigite a quantidade do produto: ");
                    int quantidade = inputQuantidade.nextInt();
                    if (produto.equalsIgnoreCase(p1.getNome())) {
                      Pe.addItem(new Item(p1, quantidade), contador);
                    } else if (produto.equalsIgnoreCase(p2.getNome())) {
                      Pe.addItem(new Item(p2, quantidade), contador);
                    } else if (produto.equalsIgnoreCase(p3.getNome())) {
                      Pe.addItem(new Item(p3, quantidade), contador);
                    } else if (produto.equalsIgnoreCase(p4.getNome())) {
                      Pe.addItem(new Item(p4, quantidade), contador);
                    } else if (produto.equalsIgnoreCase(p5.getNome())) {
                      Pe.addItem(new Item(p5, quantidade), contador);
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
              System.out
                  .println("Tipo de pagamento inválido. Por favor, escolha entre dinheiro, cartao, cheque ou pix.");
              System.out.println("\n-----------------------------------\n\n");
            }
          } else {
            System.out.println("Outra compra está em andamento! Realize o Pagamento!");
            System.out.println("\n-----------------------------------\n\n");
          }
          break;

        case 2:
          // venda/finalização da compra
          if (tp != Pagamentos.NENHUM) {
            System.out.println("\n---------------------------------------------------------------------\n");
            System.out.println(Pe.toString(tp, cliente));
            System.out.println("\n---------------------------------------------------------------------\n\n");

            Pe.ClearListaVenda();
            contador = 0;
            tp = Pagamentos.NENHUM;
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
  }
}