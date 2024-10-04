package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria{
	private double porcDescuento;
	private String[] autoresOferta;
	
	public LibreriaOferta(double pd, String[] aOfer) {
		super();
		this.porcDescuento = pd;
		this.autoresOferta = aOfer;
	}

	public String[] getOferta() {
		return autoresOferta;
	}

	public void setOferta(Double pd, String[] autoresOferta) {
		this.porcDescuento = pd;
		this.autoresOferta = autoresOferta;
	}

	public double getDescuento() {
		return porcDescuento;
	}
	private int buscarAutoresOferta(String a) {
		int i = 0;
		while( i < autoresOferta.length && ! autoresOferta[i].equalsIgnoreCase(a)) {
			i++;
		}
		return ( i < autoresOferta.length) ? i : -1;
	}
	public void addLibro(String a, String t, double pb) {
		int encontrado = buscarAutoresOferta(a);
		if(encontrado >= 0) {
			LibroOferta lib1 = new LibroOferta(a, t, pb, this.getDescuento());
			super.anyadirLibro(lib1);
		}else {
			Libro lib2 = new Libro(a, t, pb);
			super.anyadirLibro(lib2);
		}
	}
	public String toString() {
		return getDescuento() + "%" + Arrays.toString(autoresOferta) + "\n" + super.toString();
	}
	
}
