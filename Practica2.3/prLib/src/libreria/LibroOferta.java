package libreria;

public class LibroOferta extends Libro{
	private double porcDescuento;
	
	public LibroOferta(String a, String t, double pb, double pd) {
		super(a, t, pb);
		porcDescuento = pd;
	}
	public double getDescuento() {
		return porcDescuento;
	}
	protected double getBaseImponible() {
		return (super.getBaseImponible() + super.getBaseImponible()) * porcDescuento/100;
	}
	public String toString() {
	return ("(" + super.getAutor() + "; " + super.getTitulo() + "; " + super.getPrecioBase() +
			"; " + getDescuento() + "%; " + getBaseImponible() + "; " + super.getIVA() + 
			"%; " + super.getPrecioFinal() + ")");
	}
}
