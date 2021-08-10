package modelo;
/**
 * Classe mago
 * 
 * @author Breno 
 * @version 1.0
 */
public class Mago extends Humano implements EquiparItem{
	private Item cajadoMagico= new Item(3, 7, 20);

	public Mago(String nome) {
		super(nome);
		this.setPoderMagico(30);
		this.getPoderItem();
		this.setNomeAtaque1("BOLA DE FOGO");
		this.setNomeAtaque2("METEORO");
	}
	public void tomarDano(Integer x) {
		this.setVida(this.getVida()-(2*x/2));
	}
	@Override
	public int ataque(int parametro) {// ataque1
		return getPoderMagico();
	}

	@Override
	public int ataque(int parametro, int parametro2) {// ataque2
		return (getPoderMagico()*3);
	}
	
	@Override
	public void getPoderItem() {
		this.setPoderMagico(this.getPoderMagico()+ cajadoMagico.getPoderMagico()+(cajadoMagico.getForca()+cajadoMagico.getAgilidade())/7);		
	}
	@Override
	public String getNomeItem() {
		return"Cajado Magico";
	}
	
	

}
