package entity;

public enum Material {
	ALUMINIO(0.0027),
	CARBONO(0.00787),
	INOX(0.008);
	
	public double densidade;
	
	public double getDensidade() {
		return this.densidade;
	}
	
	Material(double d) {
		this.densidade = d;
	}
}
