package eleicao;

public class Candidato {
	private String nome;
	private int numero;
	private int nvotos = 0;
	private boolean eleito = false;
	private Partido partido;
	
	//construtor
	//problema: como receber uma String com o nome do partido e settar o partido com o tipo correto
	public Candidato(String nome, int numero, int nvotos, boolean eleito, String partido) {
		this.nome = nome;
		this.numero = numero;
		this.nvotos = nvotos;
		this.eleito = eleito;
		//partido??
	}
	
	//setters e getters
	public boolean isEleito() {
		return eleito;
	}

	public void setEleito(boolean eleito) {
		this.eleito = true;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNvotos() {
		return nvotos;
	}
	
	public void addNvotos(int nvotos) {
		this.nvotos++;
	}
	
	
}
