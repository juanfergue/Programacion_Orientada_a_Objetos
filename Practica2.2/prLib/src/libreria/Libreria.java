package libreria;
import java.util.ArrayList;
public class Libreria {
	private ArrayList<Libro> libs;
	
	public Libreria(){
		libs = new ArrayList<>();
	}
	public void addLibro(String a, String t, double pb) {
		Libro l1Libro = new Libro(a, t , pb);
		anyadirLibro(l1Libro);
	}
	public void remLibro(String a, String t) {
		int encontrado = buscarLibro(a, t);
		if(encontrado < 0) {
			throw new RuntimeException("Libro no encontrado");
		}
		libs.remove(encontrado);
	}
	public double getPrecioFinal(String a, String t) {
		int encontrado = buscarLibro(a, t);
		if(encontrado < 0) {
			throw new RuntimeException("Libro no encontrado");
		}
		
		return libs.get(encontrado).getPrecioFinal();
	}
	public String toString() {
		return ( "[" + libs.toString() + "]");
	}
	protected void anyadirLibro(Libro Otrolib) {
		int encontrado = buscarLibro(Otrolib.getAutor(), Otrolib.getTitulo());
		if(encontrado == -1){
			libs.add(Otrolib);
		}else{
			libs.set(encontrado, Otrolib);
		}
	}
	private int buscarLibro(String a, String t) {
		int indice = -1;
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false) {
			if(libs.get(i).getAutor().equalsIgnoreCase(a)  == true &&
			 	libs.get(i).getTitulo().equalsIgnoreCase(t)== true){
				encontrado = true;
				indice = i;
			}
			i++;
		}
		
		return indice;
	}
}
