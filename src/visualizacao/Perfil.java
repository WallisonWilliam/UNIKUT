package visualizacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import controle.ListaUnikut;
import modelo.Conta;
import modelo.Node;

import static visualizacao.Menu.*;
import static visualizacao.Cores.*;

public class Perfil {
	Scanner in = new Scanner(System.in);
	Scanner input = new Scanner(System.in);

	public void editarNome(Node aux) {
		char opNome;
		String nome;
		Conta editaNome;
		editaNome = aux.getInfo();
		System.out.print(ANSI_BLUE + "Deseja registrar ou alterar o seu nome? Se sim, digite s.");
		System.out.println(" Se nao, digite n (o perfil ficara como anonimo)." + ANSI_RESET);
		System.out.print(ANSI_YELLOW + "Digite aqui: " + ANSI_RESET);
		opNome = in.next().charAt(0);
		opNome = Character.toLowerCase(opNome);
		while (opNome != 's' && opNome != 'n') {
			System.out.print(ANSI_RED + "Opçao invalida. Informe novamente: " + ANSI_RESET);
			opNome = in.next().charAt(0);
			opNome = Character.toLowerCase(opNome);
		}
		if (opNome == 's') {
			System.out.print(ANSI_YELLOW + "Informe aqui o seu nome: " + ANSI_RESET);
			nome = input.nextLine();
			editaNome.setNome(nome);
			System.out.println();
			System.out.println(ANSI_WHITE + "Nome cadastrado no perfil." + ANSI_RESET);
		} else {
			editaNome.setNome("Convidado");
			System.out.println();
			System.out.println(ANSI_WHITE + "O seu nome no perfil aparecera como convidado." + ANSI_RESET);
		}
	}

	public boolean entrarPerf(ListaUnikut listCont, Conta cont) {
		Node aux;
		aux = listCont.buscaList(cont);
		if (listCont.isEmpty() == true) {
			System.out.println(ANSI_RED + "Nenhuma conta foi cadastrada na Unikut." + ANSI_RESET);
		} else {
			if (aux == null) {
				System.out.println(ANSI_RED + "Conta informada nao esta listada." + ANSI_RESET);
			} else if (aux.getInfo().getSenha().compareTo(cont.getSenha()) != 0) {
				System.out.println(ANSI_RED + "Senha incorreta." + ANSI_RESET);
			} else {
				System.out.println(ANSI_WHITE + "Seja bem-vindo." + ANSI_RESET);
				System.out.println();
				return true;
			}
		}
		return false;
	}

	public void alterPerf(ListaUnikut listCont, Conta cont) {
		Node aux;
		char opAlt;
		String altera;
		Conta contaEdita;
		aux = listCont.buscaList(cont);
		contaEdita = aux.getInfo();
		menuAlter();
		do {
			System.out.println(ANSI_RESET);
			System.out.println(ANSI_GREEN + "Menu de alteracao." + ANSI_GREEN);
			System.out.println(ANSI_YELLOW + "Digite 8 para exibir o menu de alteracoes novamente.");
			System.out.print("Digite aqui: " + ANSI_RESET);
			opAlt = in.next().charAt(0);
			if (opAlt >= '1' && opAlt <= '5') {
				if (opAlt == '1') {
					System.out.print(ANSI_YELLOW + "Informe a sua nova senha: ");
					altera = input.nextLine();
					contaEdita.setSenha(altera);
				} else if (opAlt == '2') {
					editarNome(aux);
				} else if (opAlt == '3') {
					System.out.print(ANSI_YELLOW + "Informe o seu genero: ");
					altera = input.nextLine();
					contaEdita.setGenero(altera);
				} else if (opAlt == '4') {
					System.out.print(ANSI_YELLOW + "Informe o seu estado civil: ");
					altera = input.nextLine();
					contaEdita.setEstadCiv(altera);
				} else {
					System.out.print(ANSI_YELLOW + "Informe uma descricao para o seu perfil: ");
					altera = input.nextLine();
					contaEdita.setDescric(altera);
				}
				System.out.println(ANSI_WHITE + "Alteracao realizada.");
			} else if (opAlt == '6') {
				editaIdade(aux);
			} else if (opAlt == '7') {
				editaData(aux);
			} else if (opAlt == '8') {
				menuAlter();
			} else if (opAlt == '0') {
				System.out.println(ANSI_GREEN + "Voltando para o menu do perfil.");
			} else {
				System.out.println(ANSI_RED + "Opcao invalida.");
			}
		} while (opAlt != '0');
	}

	public void editaIdade(Node aux) {
		int idade;
		Conta editaIdade;
		editaIdade = aux.getInfo();
		try {
			System.out.print(ANSI_YELLOW + "Informe a sua idade: ");
			idade = in.nextInt();
			while (idade < 1) {
				System.out.println(ANSI_RED + "Idade inválida.");
				System.out.print(ANSI_YELLOW + "Informe novamente: ");
				idade = in.nextInt();
			}
		} catch (InputMismatchException erroInt) {
			in.next();
			System.out.println(ANSI_RED + "Informacao invalida. E necessario informar um numero inteiro nao nulo.");
			return;
		}
		editaIdade.setIdade(idade);
		System.out.println(ANSI_WHITE + "Alteracao realizada.");
	}

	public void editaData(Node aux) {
		int dia, mes, ano;
		char charData;
		String data;
		Conta editaData;
		editaData = aux.getInfo();
		try {
			System.out.print(ANSI_YELLOW + "Informe o seu dia de nascimento: ");
			dia = in.nextInt();
			while (dia < 1 || dia > 31) {
				System.out.println(ANSI_RED + "Dia invalido.");
				System.out.print(ANSI_YELLOW + "Informe novamente: ");
				dia = in.nextInt();
			}
			System.out.print(ANSI_YELLOW + "Informe o seu mes de nascimento: ");
			mes = in.nextInt();
			while (mes < 1 || mes > 12) {
				System.out.println(ANSI_RED + "Mes invalido.");
				System.out.print(ANSI_YELLOW + "Informe novamente: ");
				mes = in.nextInt();
			}
			System.out.print(ANSI_YELLOW + "Informe o seu ano de nascimento: ");
			ano = in.nextInt();
			while (ano < 1990 || ano > 2022) {
				System.out.println(ANSI_RED + "Ano invalido.");
				System.out.print(ANSI_YELLOW + "Informe novamente: ");
				ano = in.nextInt();
			}
			if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31) {
				System.out.println(ANSI_RED + "Data inválida.");
				return;
			} else if ((ano % 4 == 0) && mes == 2 && dia > 29) {
				System.out.println(ANSI_RED + "Data inválida.");
				return;
			} else if ((ano % 4 != 0) && mes == 2 && dia > 28) {
				System.out.println(ANSI_RED + "Data inválida.");
				return;
			}
		} catch (InputMismatchException erroInt) {
			in.next();
			System.out.println(ANSI_RED + "Informacao invalida. E necessario informar um numero inteiro nao nulo.");
			return;
		}
		editaData.setDia(dia);
		editaData.setMes(mes);
		editaData.setAno(ano);
		System.out.println(ANSI_WHITE + "Alteracao realizada.");
	}
}

