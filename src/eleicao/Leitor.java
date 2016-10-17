package eleicao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;

public class Leitor {
	Scanner sc = null;
	File file = null;
	
	public Leitor (String path) {
		file = new File(path);
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
			e.printStackTrace();
		}
	}
	
	
	//COMOFAS
	//Delimitador tem que mudar pra pegar apenas o partido,
	//mas quando nao existe coligacao o caracter
	//" - " nao esta presente, checar arquivo .csv
	public HashMap<String, Partido> lePartido(){
		sc.nextLine();
		sc.useDelimiter(";|\\n");
		String partido = null;
		HashMap<String, Partido> setPartidos = new HashMap<String, Partido>();
		int indice;
		while (sc.hasNext()){
			sc.next(); sc.next(); sc.next();
			partido = sc.next();
			
			if (partido.contains("-")){ // Partido sem coligação 
				indice = partido.indexOf("-") - 1; //acha o indice do caracter que separa coligação
				//teste
				partido = partido.substring(0, indice); //retorna a substring do início até o índice
			}
			
			//System.out.println(partido);
			setPartidos.put(partido , new Partido(partido));
			sc.next(); sc.next();
		}
		System.out.println(setPartidos);
		
		
		return setPartidos;
	}
	

}
