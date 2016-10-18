package eleicao;
import java.util.LinkedList;

public class Partido implements Comparable<Partido>{
	private String nome;
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	
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
		Candidato c = null;
		for (Candidato ca : candidatos) {
			if (ca.getNome().equals(candidato)){
				c = ca;
				break;
			}
		}
		return c;
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
	}

	@Override
	public int compareTo(Partido o) {
		if(this.nome.equals(o.nome))
			return 1;

		return 0;
	}
}
