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
		if(nome != null && !nome.isBlank()) {
			this.nome = nome;
		}else {
			System.out.printf("Informe um Nome Válido: ");
			setNome(Principal.scan.nextLine());
		}	
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if(nome != null && !nome.isBlank()) {
			this.cargo = cargo;	
		}else {
			System.out.printf("Informe um Cargo Válido: ");
			setCargo(Principal.scan.nextLine());
		}	
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario > 0) {
		this.salario = salario;
		}else {
			System.out.printf("Informe um Salário Válido: ");
			setSalario(Principal.scan.nextDouble());
		}	
	}
	
	public void consultarFuncionarios() {
		System.out.printf("Nome Funcionario: %s,  Cargo: %s,  Salario: %s)\n", nome, cargo, salario);
	}
}
