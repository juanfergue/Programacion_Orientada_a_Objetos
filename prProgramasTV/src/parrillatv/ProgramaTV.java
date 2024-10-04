package parrillatv;

import java.util.Objects;

public class ProgramaTV implements Comparable<ProgramaTV>{
	private String nombre;
	private int duracion;
	private Hora horaInicio;
	
	public ProgramaTV(String n, Hora hi, int d) {
		if( d < 0) {
			throw new ProgramacionTVException("Error: la duracion no puede ser negativa");
		}
		horaInicio = hi;
		nombre = n;
		duracion = d;	
	}

	public String getNombre() {
		return nombre;
	}

	public int getDuracion() {
		return duracion;
	}
	public Hora getHoraInicio() {
		return this.horaInicio;
	}
	public Hora getHoraFin() {
		int mm = horaInicio.getMinuto() + duracion;
		int hh = horaInicio.getHora();
		return new Hora(mm, hh);
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof ProgramaTV) {
			ProgramaTV other = (ProgramaTV) o;
			ok = this.getNombre().equalsIgnoreCase(other.getNombre()) && this.getHoraInicio().equals(other.getHoraInicio())
					&& (this.getDuracion() == other.getDuracion());
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return Objects.hash( this.nombre.toUpperCase(), this.getHoraInicio(), this.duracion);
	}
	public  int compareTo(ProgramaTV other) {
		int res = this.getHoraInicio().compareTo(other.getHoraInicio());
		if(res == 0) {
			res = Integer.compare(duracion, other.duracion);
			if(res == 0) {
				res = this.getNombre().compareToIgnoreCase(other.getNombre());
			}
		}
		return res;
	}
	public String toString() {
		return ( nombre.toUpperCase() + "@" + horaInicio + "-" + duracion);
	}
}
