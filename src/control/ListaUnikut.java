package control;

import static view.Cores.*;

import model.Conta;
import model.Node;
import view.Perfil;

public class ListaUnikut {
	private Node primer;
	private Node ultim;
	private int qnt;

	public boolean inserirConta(Conta cont, boolean nome) {
		Node nvCont = new Node(cont);
		Node aux;
		Perfil perf = new Perfil();
		int compara;
		if (this.isEmpty() == true) {
			this.primer = nvCont;
			this.ultim = nvCont;
		} else {
			if (this.primer.getInfo().compareTo(cont) > 0) {
				nvCont.setProx(this.primer);
				this.primer.setAnte(nvCont);
				this.primer = nvCont;
			} else if (this.ultim.getInfo().compareTo(cont) < 0) {
				nvCont.setAnte(this.ultim);
				this.ultim.setProx(nvCont);
				this.ultim = nvCont;
			} else {
				aux = this.primer;
				while (aux != null) {
					compara = aux.getInfo().compareTo(cont);
					if (compara == 0) {
						return false;
					} else if (compara > 0) {
						aux.getAnte().setProx(nvCont);
						nvCont.setAnte(aux.getAnte());
						aux.setAnte(nvCont);
						nvCont.setProx(aux);
						break;
					}
					aux = aux.getProx();
				}
			}
		}
		this.qnt++;
		if (nome == true) {
			perf.editarNome(nvCont);
		}
		return true;
	}

	public void exibCont() {
		Node aux;
		int i;
		if (this.isEmpty() == true) {
			System.out.println(ANSI_RED + "Nenhuma conta foi cadastrada na Unikut." + ANSI_RESET);
		} else {
			aux = this.primer;
			for (i = 0; i <= this.qnt - 1; i++) {
				System.out.println(ANSI_GREEN + (i + 1) + " Conta:" + ANSI_RESET);
				System.out.println(aux.getInfo());
				aux = aux.getProx();
				if (i != this.qnt - 1) {
					System.out.println();
				}
			}
		}
	}

	public void vizlPerf(Conta cont) {
		Node aux;
		aux = this.buscaList(cont);
		System.out.println(aux.getInfo());
	}

	public void vizlAmg(Conta contaEnvio) {
		Node aux;
		Conta amizade;
		int qntAmg;
		if (this.isEmpty() == true) {
			System.out.println("Lista de amigos vazia.");
		} else {
			aux = this.primer;
			for (qntAmg = 0; qntAmg <= this.qnt - 1; qntAmg++) {
				amizade = aux.getInfo();
				System.out.println(ANSI_GREEN + (qntAmg + 1) + " Amigo:" + ANSI_RESET);
				System.out.println(ANSI_GREEN + "Conta: " + amizade.getEmail() + "\n" + "Nome: " + amizade.getNome()
						+ "\n" + "Status: " + contaEnvio.getStatAmiz() + ANSI_RESET);
				if (qntAmg != this.qnt - 1) {
					System.out.println();
				}
				aux = aux.getProx();
			}
		}
	}

	public void vizRec(Conta contaCadastr) {
		Node aux;
		Conta recado;
		int qntRec;
		aux = this.primer;
		for (qntRec = 0; qntRec <= this.qnt - 1; qntRec++) {
			recado = aux.getInfo();
			System.out.println(ANSI_GREEN + (qntRec + 1) + " Recado:" + ANSI_RESET);
			System.out.println(ANSI_GREEN + "Usuario: " + recado.getEmail() + "\n" + "Nome: " + recado.getNome() + "\n"
					+ "Recado enviado pelo usuario: " + recado.getRecadAmiz() + "\n" + "Recado enviado por voce: "
					+ contaCadastr.getRecadAmiz() + ANSI_RESET);
			if (qntRec != this.qnt - 1) {
				System.out.println();
			}
			aux = aux.getProx();
		}
	}

	public boolean isEmpty() {
		if (this.primer == null && this.ultim == null && this.qnt == 0) {
			return true;
		}
		return false;
	}

	public Node buscaList(Conta bcCont) {
		Node aux;
		int compara;
		aux = this.primer;
		while (aux != null) {
			compara = aux.getInfo().compareTo(bcCont);
			if (compara == 0) {
				return aux;
			} else if (compara > 0) {
				return null;
			}
			aux = aux.getProx();
		}
		return null;
	}
}
