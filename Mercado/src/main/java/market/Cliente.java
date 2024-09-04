package market;

public class Cliente {
  private String nome; // declaração de variável
  private String CPF; // declaração de variável

  public Cliente(String nome, String CPF) // construtor variavel
  {
    this.nome = nome;
    this.CPF = CPF;
  }

  public Cliente() // construtor padrão
  {
    this("CLIENTE", "000.000.000-00");
  }

  public String getNome() // retorna nome do cliente
  {
    return nome;
  }

  public String getCPF() // retorna CPF do cliente
  {
    return CPF;
  }

  // main padrão de testes
  public static void main(String[] args) {
    Cliente c = new Cliente("Fulano", "000.000.000-00");
    System.out.println(c.getNome());
    System.out.println(c.getCPF());
  }
}