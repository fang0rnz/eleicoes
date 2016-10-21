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

	public void addPartido(Partido p){
		if(partidos.putIfAbsent(p.getNome(), p) == null)	//Adiciona um partido na hash de partidos se ele ainda não estiver dentro dela
			flagVoto = false;                               //retornando null caso o partido tenha sido adicionado. A linha de dentro do if
															//garante que a flag de votos, usada para saber se a soma de votos já foi computada,
															//seja false caso um novo partido seja adicionado.
	}

	public String getId(){
		return id;
	}

	public int getVotos() {
		if(flagVoto) //Caso a flag seja true, retornar o numero de votos salvos
			return tVotos;
		else //Caso contrário, recalcular os votos da coligação
		{
			tVotos = 0;
			for(Partido p : partidos.values())
				tVotos+=p.getVotos();
			flagVoto = true; //Coloca a flag como true depois que o cálculo foi salvo
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
