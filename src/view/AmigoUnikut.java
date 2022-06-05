package view;

import java.util.Scanner;

import control.ListaUnikut;
import model.Conta;
import model.Node;

import static view.Menu.*;
import static view.Cores.*;

public class AmigoUnikut {
	Scanner in = new Scanner(System.in);
	Scanner input = new Scanner(System.in);

	public void opAmigo(ListaUnikut listUnikut, Conta cont) {
		ListaUnikut listEnvio, listReceb;
		Node auxList, aux;
		Conta contaEnvio, contaReceb;
		char opAmg;
		String emailAmg, nome;
		auxList = listUnikut.buscaList(cont);
		contaEnvio = auxList.getInfo();
		nome = contaEnvio.getNome();
		if (nome.compareTo("Convidado") == 0) {
			System.out.print(ANSI_RED + "A sua conta esta como ananimo.");
			System.out.print(" e necessario que voce adicione um nome para o seu perfil,");
			System.out.println(" para assim voce utilizar o menu de amizade.");
			System.out.println("Voltando para o menu do perfil.");
			return;
		}
		listEnvio = contaEnvio.getListaAmigo();
		MenuAmg();
		do {
			System.out.println(ANSI_RESET);
			System.out.println(ANSI_GREEN + "Menu de amizade." + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "Digite 4 para ver o menu novamente.");
			System.out.print("Digite aqui: " + ANSI_RESET);
			opAmg = in.next().charAt(0);
			if (opAmg == '1' || opAmg == '2') {
				System.out.print(ANSI_YELLOW + "Informe o email do usuario desejado: " + ANSI_RESET);
				emailAmg = input.nextLine();
				contaReceb = new Conta(emailAmg);
				aux = listUnikut.buscaList(contaReceb);
				if (aux == null) {
					System.out.println(ANSI_RED + "Essa conta nao faz parte da Unikut.");
				} else {
					contaReceb = aux.getInfo();
					listReceb = contaReceb.getListaAmigo();
					nome = contaReceb.getNome();
					if (contaReceb.compareTo(contaEnvio) == 0) {
						System.out.println(
								ANSI_RED + "Nao e possivel mandar ou aceitar solicitacao de amizade para si mesmo.");
					} else if (nome.compareTo("Convidado") == 0) {
						System.out.println(ANSI_RED + "Essa conta esta cadastrada como anonimo.");
					} else if (opAmg == '1') {
						amigoLista(listEnvio, listReceb, contaEnvio, contaReceb);
					} else {
						aceitaAmizade(listEnvio, contaEnvio, contaReceb);
					}
				}
			} else if (opAmg == '3') {
				listEnvio.vizlAmg(contaEnvio);
			} else if (opAmg == '4') {
				MenuAmg();
			} else if (opAmg == '0') {
				System.out.println(ANSI_WHITE + "Voltando para o menu do perfil." + ANSI_RESET);
			} else {
				System.out.println(ANSI_RED + "Opcao invalida.");
			}
		} while (opAmg != '0');
	}

	public void amigoLista(ListaUnikut listaEnvio, ListaUnikut listReceb, Conta contaEnvio, Conta contaReceb) {
		boolean validSolic, validReceb, nome;
		nome = false;
		validSolic = listaEnvio.inserirConta(contaReceb, nome);
		if (validSolic == true) {
			validReceb = listReceb.inserirConta(contaEnvio, nome);
			if (validReceb == true) {
				contaEnvio.setStatAmiz("Solicitacao enviada");
				contaReceb.setStatAmiz("Pendente");
				System.out.println(ANSI_WHITE
						+ "Solicitacao enviada. O status de amizade ficara como pendente para esse usuario.");
			}
		} else {
			System.out.println(ANSI_RED + "Essa conta ja esta na sua lista de solicitacoes ou de amizade.");
		}
	}

	public void aceitaAmizade(ListaUnikut listaUsuar, Conta contaEnvio, Conta contaAmig) {
		Node aux;
		aux = listaUsuar.buscaList(contaAmig);
		if (aux == null) {
			System.out.println(ANSI_RED + "Essa conta nao faz parte da sua lista de amizade.");
		} else if (contaAmig.getStatAmiz().compareTo("Amigos") == 0) {
			System.out.println(ANSI_RED + "Essa conta ja e seu amigo na Unikut.");
		} else if (contaEnvio.getStatAmiz().compareTo("Solicitacao enviada") == 0) {
			System.out.println(ANSI_RED + "Nao e possivel formar amizade com uma solicitacao enviadada por voce.");
		} else if (contaEnvio.getStatAmiz().compareTo("Pendente") == 0) {
			contaAmig.setStatAmiz("Amigos");
			contaEnvio.setStatAmiz("Amigos");
			System.out.println(ANSI_WHITE + "Solicitacao aceita.");
		}
	}
}
