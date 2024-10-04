package notas;

public class Alumno {
	private String dni;
	private String nombre;
	private double nota;
	
	public Alumno(String d, String n) throws AlumnoException {
		this(d,n,0);
	}
	public Alumno(String d, String n, double no) throws AlumnoException {
		if(no < 0){
			throw new AlumnoException("Calificación negativa");
		}
		this.dni = d;
		this.nombre = n;
		this.nota = no;
		
	}
}
