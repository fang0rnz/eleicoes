package eleicao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/2014100667/workspace1/trabalhoprog3/src/eleicao/vitoria2016.csv");
		Scanner sc = new Scanner(file);
		sc.useDelimiter(";");
		sc.nextLine();
		String pos = sc.next();
		int posic = 0;
		if (pos.contains("*")){
			System.out.println("Candidato Eleito.");
			pos = pos.substring(1);
			posic = Integer.parseInt(pos);
		}
		System.out.println(posic);
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		
		
		

	}

}
