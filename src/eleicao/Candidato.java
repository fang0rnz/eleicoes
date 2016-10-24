package eleicao;

public class Candidato implements Comparable<Candidato>{
	private String nome;
	private int seq;
	private int numero;
	private int nvotos = 0;
	private boolean eleito = false;
	private Partido partido;

	//construtor
	//problema: como receber uma String com o nome do partido e settar o partido com o tipo correto
	//por que não receber o objeto partido correspondente? A classe eleição pode cuidar disso.
	public Candidato(boolean eleito, int seq, int numero,String nome, int nvotos, Partido partido) {
		this.seq = seq;
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

	public Partido getPartido() {
		return partido;
	}

	//Por padrão é false, então é só chamar pra settar true
	public void setEleito() {
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

	public void incrementVotos(){
		nvotos++;
	}

	public void incrementVotos(int votos){
		nvotos+=votos;
	}

	@Override
	public int compareTo(Candidato c){
		if(this.nvotos < c.getNvotos())
			return 1;
		else if(this.nvotos > c.getNvotos())
			return -1;
		return 0;
	}

	/*alterei aqui pra imprimir os candidatos de 
	forma correta. alterar o tostring de partido e coligacao pros casos especificos maybe?*/
	@Override
	public String toString(){
		if (partido.temColigacao())
			return (" - " + nome + " ("+partido.getNome()+", " + nvotos + " votos) - Coligação: " + partido.getColigacao().getId());
		return (" - " + nome + " ("+partido.getNome()+", " + nvotos + " votos)"); 
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
}
