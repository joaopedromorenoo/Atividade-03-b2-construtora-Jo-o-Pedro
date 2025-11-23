package lojinha;

import java.util.List;//não fiz sozinho
import java.util.ArrayList;//não fiz sozinho

public class Construcao {
	
	private List<Funcionarios> equipe = new ArrayList<>();//não fiz sozinho
	
	private String funcao;//pra nao mudar vou deixar assim, mas aqui é o nome da construção
	private String endereco;
	private String dataInicio;

	public List<Funcionarios> getEquipe() {//não fiz sozinho
	    return equipe;
	}
	
	
	public Construcao() {
	}
	
	public Construcao(String funcao, String endereco, String dataInicio) {
		
		setFuncao(funcao);
		setEndereco(endereco);
		setDataInicio(dataInicio);
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		if(funcao != null && !funcao.isBlank()) {
			this.funcao = funcao;
		}
	}	

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if(endereco != null && !endereco.isBlank()) {
			this.endereco = endereco;
		}
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void consultarConstrucao() {
		System.out.printf("Nome Construção: %s,  Local: %s,  Dada de Inicio: %s\n", funcao, endereco, dataInicio);
	}
	
	public void mostrarEquipe() {//não fiz sozinho
	    System.out.println("\n--- Equipe da Construção: " + funcao + " ---");

	    if (equipe.isEmpty()) {
	        System.out.printf("Nenhum funcionário vinculado ainda.");
	        return;
	    }

	    for (Funcionarios f : equipe) {
	        System.out.printf("- " + f.getNome() + " (" + f.getCargo() + ")");
	    }
	}
	
}
