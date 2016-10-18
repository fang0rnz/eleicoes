package eleicao;
import java.util.HashMap;

public class Coligacao {
	//uma ligação entre esta classe e a classe partido.
	private String id;
	private HashMap<String, Partido> partidos = new HashMap<String, Partido>();

	public void addPartido(Partido p){
		partidos.put(p.getNome(),p);
	}

	public String getId(){
		return id;
	}
}
