package market;

public class Cliente {
  private String nome;
  private String CPF;

  public Cliente(String nome, String CPF) {
    this.nome = nome;
    this.CPF = CPF;
  }

  public Cliente() {
    this("CLIENTE", "000.000.000-00");
  }

  public String getNome() {
    return nome;
  }

  public String getCPF() {
    return CPF;
  }

  public static void main(String[] args) {
    Cliente c = new Cliente("Fulano", "000.000.000-00");
    System.out.println(c.getNome());
    System.out.println(c.getCPF());
  }
}