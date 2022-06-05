package view;

import model.Conta;

import static view.Cores.*;

import control.ListaUnikut;

public class Menu {
	public static void menuCadastrar(Conta cont, ListaUnikut listCont) {
		boolean valido, nome = true;
		valido = listCont.inserirConta(cont, nome);
		if (valido == true) {
			System.out.println(ANSI_WHITE + "Conta cadastrada.");
			System.out.print("Os seus outros dados no perfil aparecerao como sem informacao. ");
			System.out.print("Caso queira exibir os seus dados,");
			System.out.println(" clique em editar perfil quando estiver logado na Unikut." + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "Email cadastrado anteriormente. Tente outro email." + ANSI_RESET);
		}
	}

	public static void menuUnikut() {
		System.out.println(ANSI_BLUE + "Opcoes da rede social Unikut:");
		System.out.println("1 - Visualizar perfil.");
		System.out.println("2 - Editar perfil.");
		System.out.println("3 - Opcoes para a lista de amigos.");
		System.out.println("4 - Opcoes de recados para lista de amigos.");
		System.out.println("0 - Desconectar da sua conta.");
	}

	public static void menuAlter() {
		System.out.println(ANSI_GREEN + "Opcoes do menu de alteracao:");
		System.out.println("1 - Senha.");
		System.out.println("2 - Nome.");
		System.out.println("3 - Genero.");
		System.out.println("4 - Estado civil.");
		System.out.println("5 - Descricao do seu perfil.");
		System.out.println("6 - Idade.");
		System.out.println("7 - Aniversario.");
		System.out.println("0 - Voltar para o menu inicial.");
	}

	public static void MenuAmg() {
		System.out.println(ANSI_GREEN + "Opcoes do menu de amigos:");
		System.out.println("1 - Enviar uma solicitacao de amizade.");
		System.out.println("2 - Aceitar solicitacoes de amizade.");
		System.out.println("3 - Visualizar lista de amizade.");
		System.out.println("0 - Voltar para o menu inicial.");
	}

	public static void menuRec() {
		System.out.println(ANSI_GREEN + "Opcoes do menu de recados:");
		System.out.println("1 - Mandar recados para algum amigo.");
		System.out.println("2 - Exibir todos os recados.");
		System.out.println("0 - sair do menu de recados.");
	}
}
