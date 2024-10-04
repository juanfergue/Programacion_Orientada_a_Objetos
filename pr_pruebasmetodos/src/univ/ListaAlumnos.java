package univ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.StringJoiner;

public class ListaAlumnos {
	
	private SortedSet<Alumno>alumnos;
	
	public ListaAlumnos() {
		alumnos = new TreeSet<Alumno>();
	}
	public ListaAlumnos(Comparator<Alumno> comp) {
		alumnos = new TreeSet<Alumno>(comp);
	}
	public void anyadirAlumno(Alumno a) {
		eliminarAlumno(a);
		alumnos.add(a);
	}
	public Alumno buscarAlumno(String nom, String dni){
		return buscarAlumno(new Alumno(nom, dni, 0));
	}
	public void eliminarAlumno(String nom, String dni) {
		eliminarAlumno(new Alumno(nom, dni, 0));
	}
	public Set<Alumno> listaAprobados(){
		Set<Alumno> aprobados = new TreeSet<Alumno>(alumnos.comparator());
		for(Alumno a : alumnos) {
			if(a.getNota() >= 5.0) {
				aprobados.add(a);
			}
		}
		return aprobados;
	}
	public Set<Alumno> seleccionar(SelectorAlumno sa){
		Set<Alumno> selec = new TreeSet<Alumno>(alumnos.comparator());
			for(Alumno a : alumnos) {
				if( sa.esSeleccionable(a)) {
					selec.add(a);
				}
			}
			return selec;
	}
	public String toString() {
		StringJoiner sj = new StringJoiner("; " , "[" , "]");
		for(Alumno a : alumnos) {
			sj.add(a.toString());
		}
		return sj.toString();
	}
	//-----------------
	private void eliminarAlumno(Alumno alum) {
		Alumno antiguo = null;
		boolean ok = false;
		Iterator<Alumno> it = alumnos.iterator();
		while( !ok && it.hasNext()) {
			antiguo = it.next();
			ok = antiguo.equals(alum);
		}
		if(ok == true) {
			it.remove();
		}
	}
	private void eliminarAlumnoAlternativo(Alumno alum) {
		Alumno antiguo = buscarAlumno(alum);
		if(antiguo != null) {
			alumnos.remove(antiguo);
		}
	}
	private Alumno buscarAlumno(Alumno alum) {
		Alumno a = null;
		boolean ok = false;
		Iterator<Alumno> it = alumnos.iterator();
		while( !ok && it.hasNext()) {
			a = it.next();
			ok = a.equals(alum);
		}
		return ok ? a : null; //si ok == true devuelve a, si es false devuelve null
	}
}