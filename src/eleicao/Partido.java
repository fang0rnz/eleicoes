package eleicao;
import java.util.LinkedList;

public class Partido implements Comparable<Partido>{
	private String nome;
	private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();
	private Coligacao coligacao = null;

	public Partido (String nome){
		this.nome = nome;
	}

	@Override
	public String toString(){
		return this.nome;
	}
	@Override
	public boolean equals(Object o){
		return this.nome.equals(((Partido)o).nome);
	}

	//getter
	public Candidato getCandidato(String candidato){ //pega candidato pela string
		for (Candidato ca : candidatos) {
			if (ca.getNome().equals(candidato))
				return ca;
		}
		return null;
	}

	//Getter de nome do partido
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public LinkedList<Candidato> getCandidatos() {
		return candidatos;
	}

	public boolean temColigacao() {
		return coligacao!=null;
	}

	public void setColigacao(Coligacao c) {
		this.coligacao = c;
	}

	public Coligacao getColigacao(){
		return coligacao;
	}

    /**
     * Adiciona o(s) canditato(s) à lista de candidatos.
     * O método aceita um número indefinido de candidatos como argumento.
     * @param canditatos Canditatos a serem inseridos.
     */
	public void addCandidato(Candidato ... canditatos){
		for (Candidato c : canditatos) {
            if (!getCandidatos().contains(c)) //adiciona candidato na lista do partido
                getCandidatos().add(c);
		}
	}

    /**
     * Percorre a lista de canditatos calculando a soma dos votos.
     * @return A soma dos votos dos candidatos do partido.
     */
	public int getVotos() {
        int sum = 0;
        for ( Candidato c : candidatos) {
            sum += c.getNvotos();
        }

        return sum;
    }

	@Override
	public int compareTo(Partido o) {
		int votos = getVotos();
		int comp = o.getVotos();

		if(votos < comp)
			return -1;
		if(votos > comp)
			return 1;

		return 0;
	}
}
