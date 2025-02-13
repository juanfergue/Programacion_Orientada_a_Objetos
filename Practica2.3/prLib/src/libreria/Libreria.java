package libreria;
import java.util.ArrayList;
public class Libreria {
	private ArrayList<Libro> libs;
	
	public Libreria() {
		libs = new ArrayList<>();
	}
	public void addLibro(String a, String t, double pb){
		Libro lib1 = new Libro(a, t, pb);
		anyadirLibro(lib1);
	}
	public void remLibro(String a, String t) {
		int encontrado = buscarLibro(a, t);
		if(encontrado < 0) {
			throw new RuntimeException("Libro no encontrado ("+a+ ", "+ t +")");
		}else {
			libs.remove(encontrado);
		}
	}
	public double getPrecioFinal(String a, String t) {
		int encontrado = buscarLibro(a, t);
		if(encontrado < 0) {
			throw new RuntimeException("Libro no encontrado");
		}else {
			return libs.get(encontrado).getPrecioFinal();
		}
	}
	public String toString() {
		return libs.toString();
	}
	protected void anyadirLibro(Libro lib1){
		int encontrado = buscarLibro(lib1.getAutor(), lib1.getTitulo());
		if(encontrado < 0) {
			libs.add(lib1);
		}else {
			libs.set(encontrado, lib1);
		}
	}
	private int buscarLibro(String a, String t) {
		int i = 0;
		while(i < libs.size() && ! libs.get(i).getAutor().equalsIgnoreCase(a) && 
				! libs.get(i).getTitulo().equalsIgnoreCase(t)) {
			i++;
		}
		return (i < libs.size()) ? i : -1;
	}
}
