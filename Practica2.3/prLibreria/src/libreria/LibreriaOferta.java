package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria{
	private double porcDescuento;
	private String[] autoresOferta;
	
	public LibreriaOferta(double pd, String[] a ) {
		super();
		porcDescuento = pd;
		autoresOferta = a;
	}
	public void setOferta(double pd, String[] a) {
		porcDescuento = pd;
		autoresOferta = a;
	}
	public String[] getOferta() {
		return autoresOferta;
	}
	public double getDescuento() {
		return porcDescuento;
	}
	public void addLibro(String a, String t, double pb){
		int encontrado = buscarAutoresOferta(a);
		if(encontrado < 0) {
			Libro L1libro = new Libro(a, t, pb);
			super.anyadirLibro(L1libro);
		}else {
			LibroOferta nuevLibro = new LibroOferta(a, t, pb, getDescuento());
			super.anyadirLibro(nuevLibro);
		}
		
		
	}
	private int buscarAutoresOferta(String a) {
		int i = 0;
		while(i < autoresOferta.length && ! autoresOferta[i].equalsIgnoreCase(a) ){
			i++;
		}
		return (i < autoresOferta.length) ? i : -1;
	}
	public String toString() {
		return (getDescuento() + "%" + Arrays.toString(autoresOferta) + "\n" + super.toString());
	}
}
