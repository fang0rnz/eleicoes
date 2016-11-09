package eleicao;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;




public class Leitor {
	File file = null;
	private HashMap<String, Partido> partidos;

	public Leitor (String path) {
		file = new File(path);
	}

	private Scanner getScanner(){
		Scanner sc = null;

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sc;
	}

	public LinkedList<Candidato> leCandidatos() {
		Scanner sc = getScanner();
		sc.nextLine();
		sc.useDelimiter(";|\\n");
		NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("pt-br"));
		String temp;
		Candidato candidato;
		boolean eleito = false;
		int seq;
		int numero;
		int nVotos = 0;
		String nome;
		String nomepartido;
		Partido partido;
		LinkedList<Candidato> setCandidatos = new LinkedList<Candidato>();

		while (sc.hasNext()){
			temp = sc.next();
			if ((temp.charAt(0) == '*') || (temp.charAt(0) == '#')){
				if (temp.charAt(0) == '*')
					eleito = true;
				seq = Integer.parseInt(temp.substring(1));
			}
			else{
				seq = Integer.parseInt(temp);
				eleito = false;
			}

			numero = Integer.parseInt(sc.next());
			nome = sc.next();
			temp = sc.next();
			if (temp.contains("-")){ // Partido com coligação 
				int indice = temp.indexOf("-") - 1; //acha o indice do caracter que separa coligação
				nomepartido = temp.substring(0, indice); //retorna a substring do início até o índice
			}
			else
				nomepartido = temp;
			partido = partidos.get(nomepartido);
			temp = sc.next();
			try {
				nVotos = (nf.parse(temp)).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			sc.next();
			candidato = new Candidato(eleito, seq, numero, nome, nVotos, partido);
			partido.addCandidato(candidato);
			setCandidatos.add(candidato);

			//System.out.println(eleito + " " + seq + " " + numero + " " + nome + " "
			//	+ partido + " " + nVotos);
		}
		//System.out.println(setPartidos);
		sc.close();
		return setCandidatos;
	}





	//COMOFAS
	//Delimitador tem que mudar pra pegar apenas o partido,
	//mas quando nao existe coligacao o caracter
	//" - " nao esta presente, checar arquivo .csv
	public HashMap<String, Partido> lePartidos() {
		Scanner sc = getScanner();
		sc.nextLine();
		sc.useDelimiter(";|\\n");
		String partido = null;
		HashMap<String, Partido> setPartidos = new HashMap<String, Partido>();
		int indice;
		while (sc.hasNext()){
			sc.next(); sc.next(); sc.next();
			partido = sc.next();

			if (partido.contains("-")){ // Partido com coligação 
				indice = partido.indexOf("-") - 1; //acha o indice do caracter que separa coligação
				//teste
				partido = partido.substring(0, indice); //retorna a substring do início até o índice
			}

			//System.out.println(partido);
			if (!setPartidos.containsKey(partido))
				setPartidos.put(partido , new Partido(partido));
			sc.next(); sc.next();
		}
		//System.out.println(setPartidos);
		sc.close();

		this.partidos = setPartidos;
		return setPartidos;
	}

	public HashMap<String, Coligacao> leColigacoes() throws FileNotFoundException{
		Scanner sc = getScanner();
		sc.nextLine();
		sc.useDelimiter(";|\\n");
		String coligacao = null;
		HashMap<String, Coligacao> setColigacoes= new HashMap<String, Coligacao>();
		int indice;
		while (sc.hasNext()){
			sc.next(); sc.next(); sc.next();
			coligacao = sc.next();

			if (coligacao.contains("-")){ // Partido sem coligação 
				indice = coligacao.indexOf("-")+2; //acha o indice do caracter que separa coligação
				coligacao = coligacao.substring(indice); //retorna a substring do início até o índice
			}


			if (!setColigacoes.containsKey(coligacao))
				setColigacoes.put(coligacao , new Coligacao(coligacao));
			sc.next(); sc.next();
		}
		//System.out.println(setColigacoes);
		sc.close();
		return setColigacoes;
	}
}
