package notas;

public class Alumno {
	private String dni;
	private String nombre;
	private double nota;
	
	public Alumno(String d, String n) {
		this.dni = d;
		this.nombre = n;	
	}
	public Alumno(String d, String n, double not) {
		this.dni = d;
		this.nombre = n;
		this.nota = not;
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public double getCalificacion() {
		return nota;
	}
	public boolean equals(Object o) {
		boolean iguales = false;
		if(o instanceof Alumno) {
			Alumno otro = (Alumno) o;
			iguales = (this.dni == otro.dni) && this.nombre.equals(otro.nombre);
		}
		return iguales;
	}
}
