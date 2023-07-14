package entity;

import java.util.ArrayList;

public class Grupo {
	private ArrayList<Item> lista;
	private double espessura;
	private Material material;
	
	Grupo(Material material, double espessura){
		this.material = material;
		this.espessura = espessura;
		lista = new ArrayList<>();
	}
	
	Grupo (Item item){
		this.espessura = item.getChapa().getEsp();
		this.material = item.getChapa().getMaterial();
		lista = new ArrayList<>();
	}
	
	public void addItem(Item item) {
		if (item.getChapa().getMaterial() == this.material && item.getChapa().getEsp() == this.espessura) {
			lista.add(item);
		}
	}
	
	public void removeItem(int id) {
		lista.remove(id);
	}
	
	public void removeItem(Item item) {
		lista.remove(item);
	}
	
	public ArrayList<Item> getLista(){
		return this.lista;
	}
	
	public double getPesoTotal() {
		double sum = 0;
		for (Item a : lista) {
			sum = sum + a.getPeso();
		}
		return sum;
	}

}
