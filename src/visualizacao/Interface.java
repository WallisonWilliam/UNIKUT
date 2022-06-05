
package visualizacao;

import java.util.Scanner;

import controle.ListaUnikut;
import modelo.Conta;

import static visualizacao.Cores.*;
import static visualizacao.Menu.*;

public class Interface {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		char opPerf, opCont;
		boolean validCont;
		String email, senha;
		Conta cont;
		ListaUnikut listCont = new ListaUnikut();
		Perfil perf = new Perfil();
		AmigoUnikut opAmg = new AmigoUnikut();
		RecadoUnikut opRec = new RecadoUnikut();
		System.out.println();
		System.out.println(ANSI_WHITE + "Bem-vindo a rede social Unikut." + ANSI_RESET);
		do {
			System.out.println();
			System.out.println(ANSI_BLUE + "Deseja cadastrar uma conta? Se sim, digite 1.");
			System.out.println("Se voce ja e cadastrado aqui, digite 2 para logar.");
			System.out.println("Digite 0 para fechar a pagina da rede social." + ANSI_RESET);
			System.out.print(ANSI_YELLOW + "Digite aqui: " + ANSI_RESET);
			opCont = in.next().charAt(0);
			switch (opCont) {
			case '1':
				System.out.print(ANSI_YELLOW + "Digite as informaçoes necessarias para a verificacao de conta ");
				System.out.println("(Voce nao podera trocar o email depois de ter logado!).");
				System.out.print("Email: ");
				email = input.nextLine();
				System.out.print("Senha: " + ANSI_RESET);
				senha = input.nextLine();
				cont = new Conta(email, senha);
				menuCadastrar(cont, listCont);
				break;
			case '2':
				System.out.print(ANSI_YELLOW + "Digite as informaçoes necessarias para a verificacao de conta ");
				System.out.println("(Voce nao podera trocar o email depois de ter logado!).");
				System.out.print("Email: " + ANSI_RESET);
				email = input.nextLine();
				System.out.print("Senha: " + ANSI_RESET);
				senha = input.nextLine();
				cont = new Conta(email, senha);
				validCont = perf.entrarPerf(listCont, cont);
				if (validCont == true) {
					menuUnikut();
					do {
						System.out.println(ANSI_RESET);
						System.out.println(ANSI_BLUE + "Menu do perfil." + ANSI_RESET);
						System.out.println(ANSI_YELLOW + "Digite 5 para ver o menu novamente.");
						System.out.print("Informe a sua opcao desejada: " + ANSI_RESET);
						opPerf = in.next().charAt(0);
						if (opPerf == '1') {
							listCont.vizlPerf(cont);
						} else if (opPerf == '2') {
							perf.alterPerf(listCont, cont);
						} else if (opPerf == '3') {
							opAmg.opAmigo(listCont, cont);
						} else if (opPerf == '4') {
							opRec.opRecados(listCont, cont);
						} else if (opPerf == '5') {
							menuUnikut();
						} else if (opPerf == '0') {
							System.out.println(ANSI_WHITE + "Esperamos te ver de novo por aqui." + ANSI_RESET);
						} else {
							System.out.println(ANSI_RED + "Opcao invalida.");
						}
					} while (opPerf != '0');

				} else if (opCont == '3') {
					listCont.exibCont();
				} else if (opCont == '0') {
					System.out.println(ANSI_WHITE + "Volte sempre aqui." + ANSI_RESET);
				} else {
					System.out.println(ANSI_RED + "Opcao invalida." + ANSI_RESET);
				}
				break;
			default:
				System.out.println(ANSI_RED + "Opção invalida" + ANSI_RESET);
			}
		} while (opCont != '0');
	}
}
