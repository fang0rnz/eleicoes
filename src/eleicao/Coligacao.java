package eleicao;
import java.util.HashMap;

public class Coligacao {
	//uma ligação entre esta classe e a classe partido.
	private String id;
	private HashMap<String, Partido> partidos = new HashMap<String, Partido>();
	private int tVotos;

	public Coligacao(String id) {
		this.id = id;
	}

	public void addPartido(Partido p){
		partidos.putIfAbsent(p.getNome(),p); //Adiciona partido à hash de partidos
		tVotos+=p.getTVotos(); //Adiciona votos totais do partido aos votos totais da coligação
	}

	public String getId(){
		return id;
	}

	public int getTVotos() {
		return tVotos;
	}

	public boolean partidoPresente(String partido){
		if(partidos.get(partido)!=null)
			return true;
		return false;
	}
}
