package cuentapalabras;


public class PalabraEnTexto {
	private String palabra;
	private int veces;
	
	public PalabraEnTexto(String pal) {
		this.palabra = pal.toUpperCase();
		this.veces = 1;
	}
	public void incrementa() {
		this.veces ++;
	}
	public String toString() {
		return (this.palabra + ": " + this.veces);
	}
	public boolean equals(Object o) {
		boolean iguales = false;
		if(o instanceof PalabraEnTexto) {
			PalabraEnTexto otro = (PalabraEnTexto) o;
			iguales = this.palabra.equals(otro.palabra);
		}
	
		return iguales;
	}
	public int hashCode() {
		return java.util.Objects.hash( this.palabra);
	}
}
