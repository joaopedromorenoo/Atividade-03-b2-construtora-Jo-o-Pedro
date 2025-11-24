package lojinha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static Scanner scan = new Scanner(System.in);
	static List<Funcionarios> listaFuncionarios = new ArrayList<>();
	static List<Construcao> listaConstrucao = new ArrayList<>();
	
	public static void main(String[] args) {
		funcionariosProntos();
		construcaoProntos();
		VerMenu();

	}

	//predefinindo funcionarios
	private static void funcionariosProntos() { 
		Funcionarios funcionarioum = new Funcionarios("João", "Pedreiro", 2000);
		Funcionarios funcionariodois = new Funcionarios("Carlos", "Eletricista", 2100);
		Funcionarios funcionariotres = new Funcionarios("Matheus", "Encanador", 2200);
		Funcionarios funcionarioquatro = new Funcionarios("Maria", "Mestre-de-Obra", 3000);
		Funcionarios funcionariocinco = new Funcionarios("Claudia", "Pintora", 2500);
		listaFuncionarios.add(funcionarioum);
		listaFuncionarios.add(funcionariodois);
		listaFuncionarios.add(funcionariotres);
		listaFuncionarios.add(funcionarioquatro);
		listaFuncionarios.add(funcionariocinco);
	}
	
	//predefinindo construções
	private static void construcaoProntos() {
		Construcao construcaoum = new Construcao("Edicio São Carlos","Rua madrid, n°54", "24/06");
		Construcao construcaodois = new Construcao("Edificio Beira Mar","Rua Carlos Almeida, n°541", "19/11");
		Construcao construcaotres = new Construcao("Edificio Bento da Silva","Rua Santos Dumont, n°1595", "19/03");
		Construcao construcaoquatro = new Construcao("Casa","Rua Lucio Joaquim, n°282", "25/12");
		Construcao construcaocinco = new Construcao("Galpão", "Avenida Parigo, n°77", "04/02");
		listaConstrucao.add(construcaoum);
		listaConstrucao.add(construcaodois);
		listaConstrucao.add(construcaotres);
		listaConstrucao.add(construcaoquatro);
		listaConstrucao.add(construcaocinco);
	}

	private static void VerMenu() {
		int escolha = 0;

		do {
			System.out.println("\n\n___________________________________");
			System.out.println("|--------------Menu---------------|");
			System.out.println("|1- Cadastro de Funcionario       |");
			System.out.println("|2- Vincular Funcionario as obras |");
			System.out.println("|3- Mostrar Funcionarios          |");
			System.out.println("|4- Mostrar Construções           |");
			System.out.println("|5- Mostrar Equipes               |");
			System.out.println("|6- Excluir Funcionarios          |");
			System.out.println("|7- Excluir Construções           |");
			System.out.println("|8- Sair                          |");
			System.out.println("|Escolha uma opção:               |");
			System.out.printf("|_________________________________|\n");
			escolha = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolha);
		} while (escolha != 8);
	}

	private static void validarEscolha(int escolha) {
		switch (escolha) {
		case 1: {
			cadastroFuncionarios();
			break;
		}
		case 2: {
			adicionarFuncEquipes();
			break;
		}
		case 3: {
			mostrarFuncionarios();
			break;
		}
		case 4: {
			mostrarConstrucoes();
			break;
		}
		case 5: {
			mostrarEquipes();
			break;
		}
		case 6: {
			excluirFuncionarios();
			break;
		}
		case 7: {
			excluirConstrucao();
			break;
		}
		case 8: {
			System.out.printf("Você saiu do sistema! Obrigado, volte sempre!");
			return;
		}
		default:
			System.out.printf("Opção incorreta, tente novamente!");
		}
	}
	
	private static void cadastroFuncionarios() {
		Funcionarios funcionarios = new Funcionarios();
		System.out.println("Informe o nome do Funcionairo: ");
		funcionarios.setNome(scan.nextLine());
		System.out.println("Informe o Cargo: ");
		funcionarios.setCargo(scan.nextLine());
		System.out.println("Informe o Salario: ");
		funcionarios.setSalario(scan.nextInt());
		scan.nextLine();
		listaFuncionarios.add(funcionarios);
		System.out.println("Funcionario adicionado com sucesso!");
	}
	
	private static void adicionarFuncEquipes() {//não consegui fazer sozinho
		// Escolher funcionário
	    System.out.println("Qual funcionario deseja vincular?");
	    mostrarFuncionarios();
	    int indiceFuncionario = scan.nextInt();
	    scan.nextLine();

	    if (indiceFuncionario < 1 || indiceFuncionario > listaFuncionarios.size()) {
	        System.out.println("Funcionário inválido!");
	        return;
	    }

	    Funcionarios funcionarioSelecionado = listaFuncionarios.get(indiceFuncionario - 1);

	    // Escolher obra
	    System.out.println("A qual construção deseja vincular?");
	    mostrarConstrucoes();
	    int indiceConstrucao = scan.nextInt();
	    scan.nextLine();

	    if (indiceConstrucao < 1 || indiceConstrucao > listaConstrucao.size()) {
	        System.out.println("Construção inválida!");
	        return;
	    }

	    Construcao construcaoSelecionada = listaConstrucao.get(indiceConstrucao - 1);

	    // Adicionar funcionário na equipe da construção
	    construcaoSelecionada.getEquipe().add(funcionarioSelecionado);

	    System.out.println("Funcionário vinculado com sucesso!");
	}
	
	private static void mostrarFuncionarios() {
		System.out.println("\n-------Lista de Funcionarios-------");
		for (Funcionarios funcionarios : listaFuncionarios) {
			System.out.printf("%d - ", listaFuncionarios.indexOf(funcionarios) + 1);
			funcionarios.consultarFuncionarios();
		}
	}
	
	private static void mostrarConstrucoes() {
		System.out.println("\n-------Lista de Construções-------");
		for (Construcao construcao : listaConstrucao) {
			System.out.printf("%d - ", listaConstrucao.indexOf(construcao) + 1);
			construcao.consultarConstrucao();
		}
	}
	
	private static void mostrarEquipes() {//não fiz sozinho

	    System.out.println("Escolha a construção para ver a equipe:");
	    mostrarConstrucoes();

	    int escolha = scan.nextInt();
	    scan.nextLine();

	    if (escolha < 1 || escolha > listaConstrucao.size()) {
	        System.out.println("Construção inválida!");
	        return;
	    }

	    Construcao obra = listaConstrucao.get(escolha - 1);
	    obra.mostrarEquipe();
	}

	private static void excluirFuncionarios() {
		mostrarFuncionarios();
		System.out.println("Qual funcionario você quer remover?(Posição dele)");
		int escolha = scan.nextInt();
		scan.nextLine();
		if(escolha>listaFuncionarios.size()) {
			System.out.println("Esse funcionario não foi encontrado!");
			excluirFuncionarios();
		}
		listaFuncionarios.remove(escolha - 1);
		System.out.println("Essa funcionario foi excluido");
	}

	private static void excluirConstrucao() {
		mostrarConstrucoes();
		System.out.println("Qual construção você quer remover?(Posição dela)");
		int escolha = scan.nextInt();
		scan.nextLine();
		if(escolha>listaConstrucao.size()) {
			System.out.println("Esse construção não foi encontrada!");
			excluirConstrucao();
		}
		listaConstrucao.remove(escolha - 1);
		System.out.println("Essa construção foi excluida");
	}
}