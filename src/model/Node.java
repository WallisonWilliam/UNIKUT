package model;

public class Node {
	private Conta info;
	private Node ante;
	private Node prox;

	public Node(Conta nvCont) {
		this.info = nvCont;
	}

	public Conta getInfo() {
		return this.info;
	}

	public Node getAnte() {
		return this.ante;
	}

	public Node getProx() {
		return this.prox;
	}

	public void setInfo(Conta nvInfo) {
		this.info = nvInfo;
	}

	public void setAnte(Node nvAnte) {
		this.ante = nvAnte;
	}

	public void setProx(Node nvProx) {
		this.prox = nvProx;
	}
}
