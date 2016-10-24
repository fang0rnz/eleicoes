package eleicao;
import java.util.HashMap;

public class Coligacao implements Comparable<Coligacao> {
	//uma ligação entre esta classe e a classe partido.
	private String id;
	private HashMap<String, Partido> partidos = new HashMap<String, Partido>();

	public Coligacao(String id) {
		this.id = id;
	}

	public HashMap<String, Partido> getPartidos(){
		return partidos;
	}

	public void addPartido(Partido p){
		partidos.putIfAbsent(p.getNome(), p);
	}

	public String getId(){
		return id;
	}

	public int getVotos() {
		int contador = 0;

		for(Partido p : partidos.values())
			contador += p.getVotos();
		return contador;
	}

	public int getEleitos(){
		int contador = 0;

		for(Partido p : partidos.values())
			contador += p.getEleitos();

		return contador;
	}

	public boolean partidoPresente(String partido){
		if(partidos.get(partido)!=null)
			return true;
		return false;
	}

	@Override
	public String toString(){
		return (" - Coligação: " + id + ", " + getVotos() + " votos, " + getEleitos() + " candidatos eleitos");
	}

	public int compareTo(Coligacao c) {
		int votos = getVotos();
		int comp = c.getVotos();
		if(votos < comp)
			return 1;
		else if(votos > comp)
			return -1;
		else{
			int eleitos = getEleitos();
			int compE = c.getEleitos();
			if(eleitos > compE)
				return -1;
			else if(eleitos < compE)
				return 1;
		}
		return 0;
	}
}
