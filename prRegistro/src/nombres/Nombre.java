package nombres;

import java.util.Objects;

public class Nombre {
	private char genero;
	private String nombre;
	
	public Nombre(String n, char g) {
		
		if( !(g == 'F' || g =='M') ) {
			throw new RegistroCivilException("ERROR: genero es 'F' o 'M'");
		}
		if( n == null || n.length() ==0) {
			throw new RegistroCivilException("ERROR: El nombre no puede estar vacío");

		}
		this.genero = g;
		this.nombre = n;
	}

	public char getGenero() {
		return genero;
	}

	public String getNombre() {
		return nombre;
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Nombre) {
			Nombre other = (Nombre) o;
			ok = this.getNombre().equalsIgnoreCase(other.getNombre())
					&& (this.getGenero() == other.getGenero());
		}
		return ok;
	}
	public int hashCode() {
		return this.getNombre().toLowerCase().hashCode() + Character.hashCode(genero);
	}
	public String toString() {
		return String.format("(%s, %c)", nombre, genero);
	}
	public int compareTO(Nombre other) {
		int res = this.nombre.compareToIgnoreCase(other.nombre);
		if(res == 0) {
			res = Character.compare(this.genero, other.genero);
		}
		return res;
	}
}
