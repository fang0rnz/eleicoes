package eleicao;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		
		if(args.length != 1){
			System.out.println("É necessário informar (como ÚNICO parâmetro de execução) o nome do arquivo a ser analisado.");
			System.exit(1);
		}
			
		Eleicao e = new Eleicao();
		Leitor leitor = new Leitor(args[0]);
		HashMap <String, Coligacao> coligs = leitor.leColigacoes();
		HashMap <String, Partido> parts = leitor.lePartidos();
		LinkedList <Candidato> cands = leitor.leCandidatos();
		e.addPartidos(parts);
		e.addColigacoes(coligs);
		e.addCandidatos(cands);
		e.amarraColigacoes();
		e.mostrarNVagas();
		e.listarEleitos();
		e.listarMaisVotados();
		e.listarNaoEleitosMaisVotados();
		e.listarEleitosBeneficiados();
		e.listarResultadoColigacoes();
		e.listarResultadoPartidos();
		e.mostrarTotalVotos();
	}
}
