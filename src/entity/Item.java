package entity;

import java.util.Objects;

public class Item {
	//private int index;
	private double quantidade;
	private Chapa chapa;
	
	/*public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int i) {
		this.index = i;
	}*/
	
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public Chapa getChapa() {
		return chapa;
	}
	public void setChapa(Chapa chapa) {
		this.chapa = chapa;
	}
	public Item(double quantidade, Chapa chapa) {
		this.quantidade = quantidade;
		this.chapa = chapa;
	}
	
	public double getPeso() {
		return this.quantidade * this.chapa.getPesoKg();
	}
	
	public Item() {
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(chapa, quantidade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(chapa, other.chapa)
				&& Double.doubleToLongBits(quantidade) == Double.doubleToLongBits(other.quantidade);
	}
	
	
	
}
