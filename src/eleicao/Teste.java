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
		if (pos.contains("*")){
			System.out.println("Candidato Eleito.");
			pos = pos.substring(1);
			posic = Integer.parseInt(pos);
		}
		System.out.println(posic);
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		NumberFormat nf = NumberFormat.getNumberInstance(); 
		nf.setGroupingUsed(true);
		String teste = sc.next();
		Number teste1 = (nf.parse(teste));
		int teste2 = teste1.intValue();
		System.out.println(teste);
		System.out.println(teste2);
		
		System.out.println(sc.next());
		
		

	}

}
