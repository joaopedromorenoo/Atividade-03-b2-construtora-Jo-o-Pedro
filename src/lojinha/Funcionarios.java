package lojinha;

public class Funcionarios {

	private String nome;
	private String cargo;
	private double salario;
	
	public Funcionarios() {
	}
	
	public Funcionarios(String nome, String cargo, double salario) {
		setNome(nome);
		setCargo(cargo);
		setSalario(salario);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null && !nome.isBlank())
			this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if(nome != null && !nome.isBlank()) {
			this.cargo = cargo;	
		}
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario > 0)
		this.salario = salario;
	}
	public void consultarFuncionarios() {
		System.out.printf("Nome Funcionario: %s,  Cargo: %s,  Salario: %s)\n", nome, cargo, salario);
	}
}
