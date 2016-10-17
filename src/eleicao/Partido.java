package eleicao;
import java.util.LinkedList;

public class Partido {
	private String nome;
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	
	public Partido (String nome){
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object o){
		return this.nome.equals(((Partido)o).nome);
	}
}

