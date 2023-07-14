package entity;

import java.util.Objects;

public class Chapa {
	private double x;
	private double y;
	private double esp;
	private Material material;
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getEsp() {
		return esp;
	}
	public Material getMaterial() {
		return material;
	}
	
	public double getPesoKg() {
		return this.esp * this.x * this.y * this.material.getDensidade() / 1000;
	}
	
	public Chapa(double x, double y, double esp, Material material) {
		this.x = x;
		this.y = y;
		this.esp = esp;
		this.material = material;
	}
	public Chapa() {}
	@Override
	public int hashCode() {
		return Objects.hash(esp, material, x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapa other = (Chapa) obj;
		return Double.doubleToLongBits(esp) == Double.doubleToLongBits(other.esp) && material == other.material
				&& Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	
	
}
