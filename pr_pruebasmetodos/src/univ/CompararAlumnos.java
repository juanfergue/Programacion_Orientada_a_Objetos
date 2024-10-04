package univ;

import java.util.Comparator;

public class CompararAlumnos implements Comparator<Alumno>{
	public int compare(Alumno a1, Alumno a2) {
		int r = Double.compare(a2.getNota(), a1.getNota());//descendente por eso prim va a2
		if( r == 0) {
			r = a1.getNombre().compareToIgnoreCase(a2.getNombre());
			if(r == 0) {
				r = a1.getDni().compareToIgnoreCase(a2.getDni());
			}
		}
		return r;

	}
}
