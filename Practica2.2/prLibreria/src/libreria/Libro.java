package libreria;

public class Libro {
	private static double porcIVA = 10.0;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro (String a, String t, double pb) {
		autor = a;
		titulo = t;
		precioBase = pb;
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
		return (this.getBaseImponible() + this.getBaseImponible()* porcIVA / 100);
	}
	public String toString() {
		return "( " + this.getAutor() + " ; " + this.getTitulo() + " ; " + this.getPrecioBase()+ 
				" ; " + porcIVA + "% ; " + this.getPrecioFinal() + " )";
		
	}
	public static double getIVA() {
		return porcIVA;
	}
	public static void setIVA(double IVA) {
		porcIVA = IVA;
	}
	
}
