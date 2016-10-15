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
	

}
