package eleicao;

import java.util.HashMap;

public class Teste {

	public static void main(String[] args){
		
		Eleicao e = new Eleicao();
		Leitor leitor = new Leitor("vitoria2016.csv");
		HashMap <String, Coligacao> coligs = leitor.leColigacoes();
		
		e.addColigacoes(coligs);
		System.out.println(e.getColigacoes());
		//leitor.lePartido();
		Candidato cand1 = new Candidato("Adalberto", 0, 0, false, null); //teste de override
		Candidato cand2 = new Candidato("Adalberto", 0, 0, false, null); //teste de override
		System.out.println(cand1.equals(cand2));
		//File file = new File("/home/lucas/workspace/trabalhoprog3/src/eleicao/vitoria2016.csv");
		//Scanner sc = new Scanner(file);
		//sc.useDelimiter(";|\\n");
		//String atual = sc.nextLine();
		//String pos = sc.next();
		//if (pos.contains("*")||pos.contains("#")){
		//	if (pos.charAt(0) == '*')
		//		System.out.println("Candidato eleito.");
		//	else
		//		System.out.println("Candidato desclassificado");
		//	pos = pos.substring(1);
		//}
		//int posic = Integer.parseInt(pos);
		//System.out.println(posic);
		//int numerocand = Integer.parseInt(sc.next());
		//System.out.println(numerocand);
		//String nome = sc.next();
		//System.out.println(nome);
		//sc.useDelimiter(" - |;");
		//String partido = sc.next();
		//System.out.println(partido);
		//sc.useDelimiter(";|\\n");
		//String partidocolig = sc.next().substring(3);
		//System.out.println(partidocolig);
		//NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("pt-br")); 
		//String votosString = sc.next();
		//int votos = (nf.parse(votosString)).intValue(); //inteiro do valor de votos do candidato
		//System.out.println(votos);
		//double pVotosValidos = (nf.parse(sc.next()).doubleValue());
		//System.out.println(pVotosValidos);
		//System.out.println(sc.next());
		
		

	}

}
