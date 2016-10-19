package eleicao;

import java.util.LinkedList;

public class Eleicao {
	private LinkedList<Partido> partidos = new LinkedList<Partido>();
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	private LinkedList<Coligacao> coligacoes = new LinkedList<Coligacao>();

	public void addPartido(Partido p){
		partidos.add(p);
	}

	public void addCandidato(Candidato c){
		candidatos.add(c);
	}

	public void addColigacao(Coligacao c){
		coligacoes.add(c);
	}
}
