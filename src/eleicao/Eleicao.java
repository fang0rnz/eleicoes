package eleicao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Eleicao {
	private HashMap<String, Partido> hashPartidos; //como vamos mandar o hashmap direto pra referencia a classe, os metodos podem cuidar do new
	private HashMap<String, Coligacao> hashColigacoes;
	private LinkedList<Partido> partidos; //como vamos mandar o hashmap direto pra referencia a classe, os metodos podem cuidar do new
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	private LinkedList<Coligacao> coligacoes; //assim como foi feito aqui, checar metodo addcoligacoes
	boolean partidosOrdenados = false;
	boolean candidatosOrdenados = false;
	boolean coligacoesOrdenadas = false;
	private int vagas;

	public void addPartidos(HashMap<String, Partido> partidos){ //manda o hashmap direto pra lista
		this.hashPartidos = partidos;
		this.partidos = new LinkedList<Partido>(partidos.values());
	}
	
	public void addColigacoes(HashMap<String, Coligacao> coligacoes){ //manda o hashmap direto pra lista
		this.hashColigacoes = coligacoes;
		this.coligacoes = new LinkedList<Coligacao>(coligacoes.values());
	}
	
	/*Adiciona os partidos certos dentro de cada coligação verificando a string nome da coligação e usando um scanner com delimitador oportuno.*/
	public void amarraColigacoes(){
		Scanner s;
		String nomepartido;
		Partido partido;
		for (Coligacao colig : coligacoes) {
			s = new Scanner(colig.getId());
			s.useDelimiter(" / |\\n");
			while (s.hasNext()){
				nomepartido = s.next();
				if (hashPartidos.containsKey(nomepartido)){
					partido = this.hashPartidos.get(nomepartido);
					colig.addPartido(partido);
				}
			}
			s.close();
		}
	}
	
	public void addCandidato(Candidato c){
		candidatos.add(c);
		if(c.isEleito())
			vagas++;
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

	public LinkedList<Coligacao> getColigacoes() {
		return coligacoes;
	}

	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

}
