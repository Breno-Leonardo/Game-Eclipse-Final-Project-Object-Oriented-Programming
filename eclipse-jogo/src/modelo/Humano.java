package modelo;
/**
 * Classe que serve de base para Classes Guerreiro, Arqueiro e Mago
 * 
 * @author Breno 
 * @version 1.0
 */

public abstract class Humano {// classe abstrata
	private Integer vida, forca, agilidade, poderMagico;
	private String nome, nomeAtaque1, nomeAtaque2;
	private static Integer tentativas=1;

	
	/**
	 * Ataque 1
	 * @throws excecao de morte caso ataque e morra
	 * @return dano do ataque
	 * @param Um parametro=Ataque 1
	 */
	public abstract int ataque(int parametro);// metodo abstrato
	
	/**
	 * Ataque 2, mais forte que o ataque 1
	 * @throws excecao de morte caso ataque e morra
	 * @return dano do ataque
	 * @param Dois parametros=Ataque 2
	 */
	public abstract int ataque(int parametro, int parametro2);// metodo abstrato
	
	public Humano(String nome) {
		this.vida = 100;
		this.forca = 10;
		this.agilidade = 10;
		this.poderMagico = 10;
		this.nome = nome;
		
	}
	
	/**
	 * Upgrade Fixo
	 * Aumenta as caracteristicas do heroi 
	 * baseado com qual caracteristica a classe dele mais se beneficia
	 */
	public void upgrade() {// instanceof
		if (this instanceof Guerreiro) {
			this.setForca(this.getForca() + 7);
		} else if (this instanceof Arqueiro) {
			this.setAgilidade(this.getAgilidade() + 7);
		} else if (this instanceof Mago) {
			this.setPoderMagico(this.getPoderMagico() + 7);
		}
	}
	
	/**
	 * Upgrade Dinamico
	 * Aumenta as caracteristicas do heroi 
	 * baseado com qual caracteristica a classe dele mais se beneficia
	 * @param x Quantidade de Pontos
	 */
	public void upgrade(int x) {// sobrecarga
		if (this instanceof Guerreiro) {
			this.setForca(this.getForca() + x);
		} else if (this instanceof Arqueiro) {
			this.setAgilidade(this.getAgilidade() + x);
		} else if (this instanceof Mago) {
			this.setPoderMagico(this.getPoderMagico() + x);
		}
	}
	/**
	 * Reduz a vida do player baseado na classe
	 * @param x quantidade de dano a ser calculado
	 */
	public void tomarDano(Integer x) {
		this.setVida(this.getVida() - x);
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}

	public Integer getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(Integer agilidade) {
		this.agilidade = agilidade;
	}

	public Integer getPoderMagico() {
		return poderMagico;
	}

	public void setPoderMagico(Integer poderMagico) {
		this.poderMagico = poderMagico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeX) {
		nome = nomeX;
	}

	public String getNomeAtaque1() {
		return nomeAtaque1;
	}

	public void setNomeAtaque1(String nomeAtaque1) {
		this.nomeAtaque1 = nomeAtaque1;
	}

	public String getNomeAtaque2() {
		return nomeAtaque2;
	}

	public void setNomeAtaque2(String nomeAtaque2) {
		this.nomeAtaque2 = nomeAtaque2;
	}
	
    public String getNomeItem() {//ligacao dinamica
    	return "Sem item";
    }

	public static Integer getTentativas() {
		return tentativas;
	}

	public static void setTentativas(Integer tentativas) {
		Humano.tentativas = tentativas;
	}
    
}
