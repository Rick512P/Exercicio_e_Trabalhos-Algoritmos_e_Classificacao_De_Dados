package mercado;

public class Clientes {
  private String nome;
  private String CPF;

  public Clientes(String nome, String CPF) // construtor variavel
    {
      this.nome = nome;
      this.CPF = CPF;
    }
  
  //padrao
  public Clientes() {
    nome = "Jorge da Silva";
    CPF = "000.000.000-00";
    //this("CLIENTE", "000.000.000-00");
  }

  public String getNome() {
    return nome;
  }

  public String getCPF() {
    return CPF;
  }

}