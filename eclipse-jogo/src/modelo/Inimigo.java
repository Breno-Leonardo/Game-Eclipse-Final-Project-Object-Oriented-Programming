package modelo;
/**
 * Classe Inimigo
 * 
 * @author Breno 
 * @version 1.0
 */
public class Inimigo {
	private String nome;
	private int vida;
	private String nomeDoAtaque;
	
	public Inimigo(String nome, int vida, String nomeDoAtaque) {
		super();
		this.nome = nome;
		this.vida = vida;
		this.nomeDoAtaque = nomeDoAtaque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}


	public String getNomeDoAtaque() {
		return nomeDoAtaque;
	}

	public void setNomeDoAtaque(String nomeDoAtaque) {
		this.nomeDoAtaque = nomeDoAtaque;
	}
	
	
	
}
