package eleicao;

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
	private int vagas; //Número de vagas da eleição. Contada a partir dos candidatos eleitos

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
		for (Coligacao colig : hashColigacoes.values()) {
			s = new Scanner(colig.getId());
			s.useDelimiter(" / |\\n");
			while (s.hasNext()){
				nomepartido = s.next();
				if (hashPartidos.containsKey(nomepartido)){
					partido = this.hashPartidos.get(nomepartido);
					partido.setColigacao(colig);
					colig.addPartido(partido);
				}
				else {
					partido = new Partido(nomepartido);
					hashPartidos.put(nomepartido, partido);
					partidos.add(partido);
					partido.setColigacao(colig);
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

	private void ordenarCandidatos(){
		if(!candidatosOrdenados)
		{
			Collections.sort(candidatos);
			candidatosOrdenados = true;
		}
	}

	private String gerarSaida(Candidato c, int posicao){
		String saida;

		saida = posicao + " - " + c.getNome() + " (" + c.getPartido().getNome() + ", " + c.getNvotos() + " votos)";
		if(c.getPartido().temColigacao())
			saida += " - Coligação: " + c.getPartido().getColigacao().getId(); 
		
		return saida;
	}

	public void listarEleitos(){
		int contador = 1;

		ordenarCandidatos();

		System.out.println("Vereadores eleitos:");

		for(Candidato c : candidatos){
			if(c.isEleito()){
				System.out.println(gerarSaida(c,contador));		
				contador++;
			}
		}
	}

	public void listarMaisVotados(){
		int contador = 1;

		ordenarCandidatos();

		System.out.println("Candidatos mais votados (em ordem decrescente de votação e respeitando o número de vagas):");
		for (Candidato c : candidatos){
			if(contador<=vagas){
				System.out.println(gerarSaida(c,contador));		
				contador++;
			}
			else
				break;
		}
	}

	public void listarNaoEleitosMaisVotados(){
		int contador = 1;

		ordenarCandidatos();

		System.out.println("Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:");
		System.out.println("com sua posição no ranking de mais votados)");
		for(Candidato c : candidatos){
			if(contador<=vagas && !c.isEleito())
				System.out.println(gerarSaida(c,contador));
			contador++;
		}
	}

	public void listarEleitosBeneficiados(){
		int contador = 1;

		ordenarCandidatos();

		System.out.println("Eleitos, que se beneficiaram do sistema proporcional:");
		System.out.println("com sua posição no ranking de mais votados)");
		for(Candidato c : candidatos){
			if(contador>vagas && c.isEleito())
				System.out.println(gerarSaida(c,contador));
			contador++;
		}
	}

	//Faltando listar Votações nominais de partidos e coligações.

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
