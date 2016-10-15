package eleicao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	public Partido lePartido(){
		Partido part = null;
		sc.nextLine();
		sc.useDelimiter(";|\\n");
		while (sc.hasNext()){
			sc.next(); sc.next(); sc.next();
			sc.useDelimiter(";| - ");
			System.out.println(sc.next());
			sc.useDelimiter(";|\\n");
			sc.next(); sc.next(); sc.next();
	}
		
		
		return part;
	}
	

}
