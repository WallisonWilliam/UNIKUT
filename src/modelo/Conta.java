package modelo;

import static visualizacao.Cores.*;

import controle.ListaUnikut;

public class Conta {
	   private String email;
	   private String senha;
	   private String nome;
	   private int idade = 0;
	   private String genero = "Sem informacao";
	   private int dia = 0;
	   private int mes = 0;
	   private int ano = 0;
	   private String estadCiv = "Sem informacao";
	   private String descric = "Sem informacao";
	   private String statAmiz;
	   public String recadAmiz = "Sem mensagens enviadas";
	   private final ListaUnikut listaAmigo = new ListaUnikut();

	   public Conta(String email, String senha) {
	       this.email = email;
	       this.senha = senha;
	   }

	   public Conta(String email) {
	       this.email = email;
	   }

	   public String getEmail() {
	       return this.email;
	   }

	   public String getSenha() {
	       return this.senha;
	   }

	   public String getNome() {
	       return this.nome;
	   }

	   public String getStatAmiz() {
	       return this.statAmiz;
	   }

	   public String getRecadAmiz() {
	       return this.recadAmiz;
	   }

	   public ListaUnikut getListaAmigo() {
	       return this.listaAmigo;
	   }

	   public void setSenha(String senha) {
	       this.senha = senha;
	   }

	   public void setNome(String nome) {
	       this.nome = nome;
	   }

	   public void setIdade(int idade) {
	       this.idade = idade;
	   }

	   public void setGenero(String genero) {
	       this.genero = genero;
	   }

	   public void setDia(int dia) {
	       this.dia = dia;
	   }

	   public void setMes(int mes) {
	       this.mes = mes;
	   }

	   public void setAno(int ano) {
	       this.ano = ano;
	   }

	   public void setEstadCiv(String estadCiv) {
	       this.estadCiv = estadCiv;
	   }

	   public void setDescric(String descric) {
	       this.descric = descric;
	   }

	   public void setStatAmiz(String statAmiz) {
	       this.statAmiz = statAmiz;
	   }

	   public void setRecadAmiz(String recadAmiz) {
	       this.recadAmiz = recadAmiz;
	   }

	   public int compareTo(Conta bcCont) {
	       int compara;
	       compara = this.email.compareToIgnoreCase(bcCont.getEmail());
	       return compara;
	   }

	   public String toString() {
	       return ANSI_GREEN + "Email: " + this.email + "\n" + "Nome: " + this.nome + "\n" + "Genero: " + this.genero + "\n"
	               + "Idade: " + this.idade + "\n"+ "Data de aniversario: " + this.dia + "/" + this.mes + "/" + this.ano + "\n"
	               + "Estado civil: " + this.estadCiv + "\n" + "Descricao do perfil: " + this.descric + ANSI_RESET;
	   }
}