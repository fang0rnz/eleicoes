package eleicao;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Locale;
public class Teste {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		File file = new File("/home/2014100667/workspace1/trabalhoprog3/src/eleicao/vitoria2016.csv");
		Scanner sc = new Scanner(file);
		sc.useDelimiter(";|\\n");
		sc.nextLine();
		String pos = sc.next();
		int posic = 0;
		if (pos.contains("*")||pos.contains("#")){
			if (pos.charAt(0) == '*')
				System.out.println("Candidato eleito.");
			else
				System.out.println("Candidato desclassificado");
			pos = pos.substring(1);
		}
			posic = Integer.parseInt(pos);
		System.out.println(posic);
		int numerocand = Integer.parseInt(sc.next());
		System.out.println(numerocand);
		String nome = sc.next();
		System.out.println(nome);
		String partidocolig = sc.next();
		System.out.println(partidocolig);
		NumberFormat nf = NumberFormat.getNumberInstance(); 
		nf.setGroupingUsed(true);
		String teste = sc.next();
		int teste1 = (nf.parse(teste)).intValue(); //inteiro do valor de votos do candidato
		System.out.println(teste);
		System.out.println(teste1);
		
		System.out.println(sc.next());
		
		

	}

}
