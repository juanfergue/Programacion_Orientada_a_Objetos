package univ;
import java.util.Objects;

public class Alumno {

	private String nombre;
	private String dni;
	private double nota;

	public Alumno(String n, String d, double nt) {
	if ((n == null || n.length() == 0)||(d == null || d.length() == 0)||(nt < 0)) {
		throw new RuntimeException("Agumentos erróneos");
	}
	nombre = n;
	dni = d;
	nota = nt;
	}
public String getNombre() {
return nombre;
}
public String getDni() {
return dni;
}
public double getNota() {
return nota;
}
@Override
public String toString() {
return "("+getNombre()+", "+getDni()+", "+getNota()+")";
}
@Override
public boolean equals(Object o) {
	boolean ok = false;
	if (o instanceof Alumno) {
		Alumno x = (Alumno)o;
		ok = this.nombre.equalsIgnoreCase(x.nombre)
			&& this.dni.equalsIgnoreCase(x.dni);
	}
	return ok;
}
@Override
public int hashCode() {
	return Objects.hash(nombre.toLowerCase() + dni.toLowerCase().hashCode());
}
public int compareTo(Alumno o) {
	int r = this.nombre.compareToIgnoreCase(o.nombre);
	if(r == 0) {
		r = this.dni.compareToIgnoreCase(o.dni);
	}
	return r;
}
public boolean equalsAnterior(Object o) {
	boolean ok = false;
	if(o instanceof Alumno) {
		Alumno other = (Alumno) o;
		ok = this.dni.equals(other.dni) 
			&& this.nombre.equals(other.nombre) 
			&& (this.nota == other.nota);
	}
	return ok;
}
public int hashCodeAnterior() {
	return nombre.hashCode() + dni.hashCode() + Double.hashCode(nota);
}
public int compareToAnterior(Alumno o) {
	int r = this.nombre.compareTo(o.nombre);
	if( r == 0) {
		r = this.dni.compareTo(o.dni);
		if(r == 0) {
			r = Double.compare(this.nota, o.nota);
		}
	}
	return r;

}

}