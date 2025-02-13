package parrillatv;


public class ProgramaTV implements Comparable<ProgramaTV>{
	private String nombre;
	private int duracion;
	private Hora horaInicio;
	
	public ProgramaTV (String n, Hora h, int d) {
		if(d < 0) {
			throw new ProgramacionTVException("ERROR, la duración no puede ser negativa");
		}
		this.nombre =n;
		this.duracion = d;
		this.horaInicio = h;
		
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getDuracion() {
		return this.duracion;
	}
	public Hora getHoraInicio() {
		return this.horaInicio;
	}
	public Hora getHoraFin() {
		int mm = horaInicio.getMinuto() + duracion;
		int hh = horaInicio.getHora();
		return new Hora(mm, hh);
	}
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof ProgramaTV) {
			ProgramaTV other = (ProgramaTV) o;
			ok = this.nombre.equalsIgnoreCase(other.nombre) && this.horaInicio.equals(other.horaInicio) && this.duracion == other.duracion;
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return this.nombre.toUpperCase().hashCode() + this.horaInicio.hashCode() + Integer.hashCode(duracion);
	}
	@Override
	public int compareTo(ProgramaTV other) {
		int res = this.horaInicio.compareTo(other.horaInicio);
		if(res == 0) {
			res = Integer.compare(duracion, other.duracion);
			if(res == 0) {
				this.nombre.compareToIgnoreCase(other.nombre);
			}
		}
		return res;
	}
	@Override
	public String toString() {
		return (this.nombre + "@" + this.horaInicio.toString() + "-" + this.duracion);
	}
	
	
}
