package modelo;
/**
 * Classe Guerreiro
 * 
 * @author Breno 
 * @version 1.0
 */
public class Guerreiro extends Humano implements EquiparItem {// heranca e interface

	private Item espadaDivina = new Item(20, 5, 5);//composicao

	public Guerreiro(String nome) {
		super(nome);
		this.setForca(30);
		this.getPoderItem();
		this.setNomeAtaque1("ESPADADA");
		this.setNomeAtaque2("ESPADA FLAMEJANTE");
	}

	public void tomarDano(Integer x) {// polimorfismo/ligacao dinamica
		this.setVida(this.getVida() - (x / 2));
	}

	//sobreposicao
	@Override
	public int ataque(int parametro) {// ataque1, sobreposicao
		return getForca();
	}

	@Override
	public int ataque(int parametro, int parametro2) {// ataque2
		return (getForca() + getForca() / 2);
	}

	
	@Override
	public void getPoderItem() {
		this.setForca(this.getForca()+ espadaDivina.getForca() + (espadaDivina.getPoderMagico() + espadaDivina.getAgilidade()) / 5);

	}

	@Override
	public String getNomeItem() {
		return "Espada Divina";
	}

}
