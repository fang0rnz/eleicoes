package eleicao;

import java.util.HashMap;

public class Eleicao {
	private HashMap<String, Partido> partidos = new HashMap<String, Partido>();
	private HashMap<String, Candidato> candidatos = new HashMap<String, Candidato>();
	//Mapeamento da Coligação pode ser feito através da String
	//obtida pelo arquivo. Exemplo: "- PPS / PROS"
	private HashMap<String, Coligacao> coligacoes = new HashMap<String, Coligacao>();

	public void addPartido(Partido p){
		partidos.put(p.getNome(),p);
	}

	public void addCandidato(Candidato c){
		candidatos.put(c.getNome(),c);
	}

	public void addColigacao(Coligacao c){
		coligacoes.put(c.getId(),c);
	}
}
