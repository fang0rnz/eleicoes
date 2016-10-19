package eleicao;
import java.util.LinkedList;

public class Partido implements Comparable<Partido>{
	private String nome;
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	private int tVotos;
	
	public Partido (String nome){
		this.nome = nome;
	}
	
	@Override
	public String toString(){
		return this.nome;
	}
	@Override
	public boolean equals(Object o){
		return this.nome.equals(((Partido)o).nome);
	}
	
	//getter
	public Candidato getCandidato(String candidato){ //pega candidato pela string
		for (Candidato ca : candidatos) {
			if (ca.getNome().equals(candidato))
				return ca;
		}
		return null;
	}
	
	//Getter de nome do partido
	public String getNome() {
		return nome;
	}

	public LinkedList<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public void addCandidato(Candidato c){ 
		this.candidatos.add(c); //adiciona candidato na lista do partido
		this.tVotos+=c.getNvotos(); //adiciona os votos do candidato ao total de votos do partido
	}

	@Override
	public int compareTo(Partido o) {
			return 1;
	}

	public int getTVotos(){
		return tVotos;
	}
}
