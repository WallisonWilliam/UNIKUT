package visualizacao;

import java.util.Scanner;

import controle.ListaUnikut;
import modelo.Conta;
import modelo.Node;

import static visualizacao.Cores.*;
import static visualizacao.Menu.*;

public class RecadoUnikut {
	   Scanner in = new Scanner(System.in);
	   Scanner input = new Scanner(System.in);

	   public void opRecados(ListaUnikut listUnikut, Conta cont) {
	       ListaUnikut listaAmizad;
	       Node auxList;
	       Conta contUsuar;
	       char opRec;
	       auxList = listUnikut.buscaList(cont);
	       contUsuar = auxList.getInfo();
	       listaAmizad = contUsuar.getListaAmigo();
	       if (listaAmizad.isEmpty() == true) {
	           System.out.println(ANSI_RED + "Voce nao tem nenhum amigo adicionado no seu perfil." + ANSI_RESET);
	           System.out.println(ANSI_WHITE + "Voltando para o menu do perfil.");
	           return;
	       }
	       menuRec();
	       do {
	           System.out.println(ANSI_RESET);
	           System.out.println(ANSI_GREEN + "Menu de recados." + ANSI_RESET);
	           System.out.println(ANSI_YELLOW + "Digite 3 para exibir as opcoes de recados novamente.");
	           System.out.print("Informe a sua opcao desejada: " + ANSI_RESET);
	           opRec = in.next().charAt(0);
	           if (opRec == '1') {
	               mandarRecado(listaAmizad, contUsuar);
	           } else if (opRec == '2') {
	               listaAmizad.vizRec(contUsuar);
	           } else if (opRec == '3') {
	               menuRec();
	           } else if (opRec == '0') {
	               System.out.println(ANSI_WHITE + "Voltando para o menu do perfil.");
	           } else {
	               System.out.println(ANSI_RED + "Opcao invalida.");
	           }
	       } while (opRec != '0');
	   }

	   public void mandarRecado(ListaUnikut listaAmizad, Conta contaEnvio) {
	       Node aux;
	       Conta valida, contaAmigo;
	       String emailRec, recado;
	       System.out.print(ANSI_WHITE + "Informe o email do amigo que deseja mandar uma mensagem: " + ANSI_RESET);
	       emailRec = input.nextLine();
	       valida = new Conta(emailRec);
	       aux = listaAmizad.buscaList(valida);
	       if (valida.compareTo(contaEnvio) == 0) {
	           System.out.println(ANSI_RED + "Nao e possivel mandar um recado para si mesmo.");
	       } else if (aux == null) {
	           System.out.println(ANSI_RED + "A conta informada nao esta na sua lista de amigos.");
	       } else {
	           contaAmigo = aux.getInfo();
	           if (contaAmigo.getStatAmiz().compareTo("Solicitacao enviada") == 0) {
	               System.out.println(ANSI_RED + "E necessario voce aceitar a solicitacao de amizade desta conta primeiro.");
	           } else if (contaAmigo.getStatAmiz().compareTo("Pendente") == 0) {
	               System.out.println(ANSI_RED + "A conta informada nao aceitou o seu convite de amizade");
	           } else {
	               System.out.print(ANSI_WHITE + "Informe o recado que deseja mandar para seu amigo: " + ANSI_RESET);
	               recado = input.nextLine();
	               contaEnvio.setRecadAmiz(recado);
	               System.out.println(ANSI_YELLOW + "Mensagem enviada.");
	           }
	       }
	   }
	}


