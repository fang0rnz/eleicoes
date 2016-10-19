package eleicao;

import java.util.Collections;
import java.util.LinkedList;

public class Eleicao {
	private LinkedList<Partido> partidos = new LinkedList<Partido>();
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	private LinkedList<Coligacao> coligacoes = new LinkedList<Coligacao>();
	boolean partidosOrdenados = false;
	boolean candidatosOrdenados = false;
	boolean coligacoesOrdenadas = false;
	private int vagas;

	public void addPartido(Partido p){
		partidos.add(p);
	}

	public void addCandidato(Candidato c){
		candidatos.add(c);
		if(c.isEleito())
			vagas++;
	}

	public void addColigacao(Coligacao c){
		coligacoes.add(c);
	}

	public void listarEleitos(){
		int contador = 1;
		String saida = "";

		Collections.sort(candidatos);
		candidatosOrdenados = true;

		System.out.println("Vereadores eleitos:");

		for(Candidato c : candidatos){
			if(c.isEleito()){
				saida = contador + " - " + c.getNome() + " (" + c.getPartido().getNome() + ", " + c.getNvotos() + " votos)";
				if(c.getPartido().temColigacao())
					saida += " - Coligação: " + c.getPartido().getColigacao().getId(); //PROBLEMA: NA HORA DE IMPRIMIR AS COLIGACOES COM MAIS VOTOS  TENHO QUE CONTAR PARTIDOS SOZINHOS COMO COLIGACOES, ADICIONAR FLAG QUE CONTA QUANTIDADE DE CANDIDATOS ELEITOS DAQUELA COLIGACAO / PARTIDO
				System.out.println(saida);		
				contador++;
			}
		}
	}

	public int getVagas() {
		return vagas;
	}
}
