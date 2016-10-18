package eleicao;
import java.util.HashMap;

public class Coligacao {
	//Utilizando um HashMap de partidos para coligação para manter
	//uma ligação entre esta classe e a classe partido.
	
	private String nome;
	private HashMap<String ,Partido> partidos = new HashMap<String, Partido>();
	
	
	public Coligacao (String nome){
		this.nome = nome;
	}
	
	
	
}
