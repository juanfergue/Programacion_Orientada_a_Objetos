package libreria;
import java.util.ArrayList;

public class Libreria {
	private ArrayList<Libro> libs;
	
	public Libreria() {
		libs = new ArrayList<>();
		
	}
	
	public void addLibro(String a, String t, double pb) {
		anyadirLibro(new Libro(a, t, pb));
	}
	public void remLibro(String a, String t) {
		int i = buscarLibro(a, t);
		if(i < 0) {
			throw new RuntimeException("Libro no encontrado (" + a + ", " + t + ")");
		}else {
			libs.remove(i);
		}
	}
	public double getPrecioFinal(String a, String t) {
		int i = buscarLibro(a, t);
		if(i < 0) {
			throw new RuntimeException("Libro no encontrado (" + a + ", " + t + ")");
		}
			return libs.get(i).getPrecioFinal();
	}
	public String toString() {
		return libs.toString();
	}
	protected void anyadirLibro(Libro lb) {
		int i = buscarLibro(lb.getAutor(), lb.getTitulo());
		if(i < 0) {
			libs.add(lb);
		}else {
			libs.set(i, lb);
		}
		
	}
	private int buscarLibro(String a, String t) {
		int encontrado = -1;
		int i = 0;
		while((encontrado == -1) && (i < libs.size())){
			if(libs.get(i).getAutor().equalsIgnoreCase(a) && libs.get(i).getTitulo().equalsIgnoreCase(t)) {
				encontrado = i;
			}
			i++;
		}
		return encontrado;
	}
}
