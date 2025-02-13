package libreria;

public class Libro {
	private static double porcIVA;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro(String a, String t, double pb) {
		this.autor = a;
		this.titulo = t;
		this.precioBase = pb;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getPrecioBase() {
		return precioBase;
	}
	protected double getBaseImponible() {
		return precioBase;
	}
	public double getPrecioFinal() {
		return ((this.getBaseImponible() + this.getBaseImponible())* porcIVA /100);
	}
	
	@Override
	public String toString() {
		return "(" + autor + ", titulo=" + titulo + ", precioBase=" + precioBase + ", getPrecioFInal()="
				+ porcIVA + "%; "+ getPrecioFinal() + ")";
	}

	public static double getIVA() {
		return porcIVA;
	}

	public static void setPorcIVA(double porcIVA) {
		Libro.porcIVA = porcIVA;
	}

	
	
}
