package modelo;
/**
 * Classe item 
 * 
 * @author Breno 
 * @version 1.0
 */
public class Item {
private int forca;
private int agilidade;
private int poderMagico;


public Item(int forca, int agilidade, int poderMagico) {
	super();
	this.forca = forca;
	this.agilidade = agilidade;
	this.poderMagico = poderMagico;
}
public int getForca() {
	return forca;
}
public void setForca(int forca) {
	this.forca = forca;
}
public int getAgilidade() {
	return agilidade;
}
public void setAgilidade(int agilidade) {
	this.agilidade = agilidade;
}
public int getPoderMagico() {
	return poderMagico;
}
public void setPoderMagico(int poderMagico) {
	this.poderMagico = poderMagico;
}


}
