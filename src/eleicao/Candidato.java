package eleicao;

public class Candidato {
	private String nome;
	private int numero;
	private int nvotos = 0;
	private boolean eleito = false;
	private Partido partido;
	
	//construtor
	//problema: como receber uma String com o nome do partido e settar o partido com o tipo correto
	//por que não receber o objeto partido correspondente? A classe eleição pode cuidar disso.
	public Candidato(String nome, int numero, int nvotos, boolean eleito, Partido partido) {
		this.nome = nome;
		this.numero = numero;
		this.nvotos = nvotos;
		this.eleito = eleito;
		this.partido = partido;
	}
	
	@Override
	public boolean equals(Object o){
		return this.nome.equals(((Candidato)o).nome);
	}
	
	//setters e getters
	public boolean isEleito() {
		return eleito;
	}
	//teste1
	//Modificado porque ou setEleito não recebe parâmetro nenhum, ou deve setar a variável eleito como o parâmetro recebido.
	public void setEleito(boolean eleito) {
		this.eleito = eleito;
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
	
	//Modificado porque não faz sentido receber um número de votos como parâmetro e somente somar um ao contador de votos
	//Uma sugestão melhor seria mudar o nome desse método para setNvotos(int nvotos) e criar outro método
	//com o nome addVoto() que faz simplesmente a operação this.nvotos++ caso isso seja útil para o programa
	public void addNvotos(int nvotos) {
		this.nvotos = nvotos;
	}
	
	
}
