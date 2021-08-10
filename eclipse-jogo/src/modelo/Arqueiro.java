package modelo;
/**
 * Classe Arqueiro
 * 
 * @author Breno 
 * @version 1.0
 */
public class Arqueiro extends Humano implements EquiparItem {
	private Item arcoVeloz= new Item(3, 20, 3);

	public Arqueiro(String nome) {
		super(nome);
		this.setAgilidade(30);
		this.getPoderItem();
		this.setNomeAtaque1("FLECHADA");
		this.setNomeAtaque2("CHUVA DE FLECHAS");
	}
	public void tomarDano(Integer x) {
		this.setVida(this.getVida()-(3*x/2));
	}
	
	@Override
	public int ataque(int parametro) {//ataque1
		return getAgilidade();
	}

	@Override
	public int ataque(int parametro, int parametro2) {///ataque2
		return (getAgilidade()*2);
	}

	@Override
	public void getPoderItem() {
		this.setAgilidade(this.getAgilidade()+ arcoVeloz.getAgilidade()+(arcoVeloz.getForca()+arcoVeloz.getPoderMagico())/5);
	}

	@Override
	public String getNomeItem() {
		return "Arco Veloz";
	}
	

	

}
