package eleicao;
import java.util.HashMap;

public class Coligacao implements Comparable<Coligacao> {
	//uma ligação entre esta classe e a classe partido.
	private String id;
	private HashMap<String, Partido> partidos = new HashMap<String, Partido>();
	private int tVotos;
	private boolean flagVoto = false;

	public Coligacao(String id) {
		this.id = id;
	}
	
	public HashMap<String, Partido> getPartidos(){
		return partidos;
	}

	public void addPartido(Partido p){ // ??? 
		partidos.put(p.getNome(), p);
	}

	public String getId(){
		return id;
	}

	public int getVotos() {
		if(flagVoto)
			return tVotos;
		else
		{
			tVotos = 0;
			for(Partido p : partidos.values())
				tVotos+=p.getVotos();
			flagVoto = true;
			return tVotos;
		}
	}

	public boolean partidoPresente(String partido){
		if(partidos.get(partido)!=null)
			return true;
		return false;
	}

	@Override
	public String toString(){
		return id;
	}

	public int compareTo(Coligacao c) {
		if(this.tVotos < c.getVotos())
			return -1;
		else if(this.tVotos > c.getVotos())
			return 1;
		
		return 0;
	}
}