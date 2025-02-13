package ex2305;
	import java.util.*;
	import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
public class Laboratorios {
	private int maxLabs;
	private List<Solicitud> solicitudes;
	private SortedSet<Solicitud> erroresDeAsignacion;
	private SortedMap<Integer, SortedMap<Integer, List<Solicitud>>> asignaciones;
	
	public Laboratorios(int m) {
		if( m < 1 ) {
			throw new LabException("Argumentos erróneos");
		}
		this.maxLabs = m;
		solicitudes = new ArrayList<>();
		this.erroresDeAsignacion = new TreeSet<>();
		this.asignaciones = new TreeMap<>();
	}

	protected SortedSet<Solicitud> getErroresDeAsignacion() {
		return erroresDeAsignacion;
	}
	protected void addSolicitud(Solicitud s) {
		if(!solicitudes.contains(s)) {
			solicitudes.add(s);
		}
	}
	public void addSolicitud(String datos) {
		try(Scanner sc = new Scanner(datos)){
			sc.useDelimiter("\\s*[;]\\s*");
			String asignatura = sc.next();
			int diaSem = Integer.parseInt(sc.next());
			int franja = Integer.parseInt(sc.next());
			
			addSolicitud(new Solicitud(asignatura, diaSem, franja));
		}catch(Exception e) {
			throw new LabException("Argumentos erroneos");
		}
	}
	public void asignarLabs() {
		asignaciones.clear();
		this.erroresDeAsignacion.clear();
		
	}
	public void cargarSolicitudesDeFichero(String fichero) throws IOException {
		try(Scanner sc = new Scanner( new File(fichero))){
			while(sc.hasNext()) {
				this.addSolicitud(sc.nextLine());
			}
		}catch(Exception e) {
			throw new IOException("ERROR en el fichero: " + fichero);
		}
	}
	public void guardarAsignacionesEnFichero(String fichero) throws IOException {
		try(PrintWriter pw = new PrintWriter(fichero)){
			mostrarAsignaciones(pw);
		}
	}
	public void mostrarAsignaciones(PrintWriter pw) {
		for(Map.Entry<Integer, SortedMap<Integer, List<Solicitud>>> asig : asignaciones.entrySet()) {
			for(Map.Entry<Integer, List<Solicitud>> soli : asig.getValue().entrySet()) {
				pw.println("\nDiaSem: " + asig.getKey() + "; Franja: " + soli.getKey() );
				int idx = 0;
				for(Solicitud s : soli.getValue()) {
					pw.println("\nLab: " + idx + s);
					idx++;
				}
			}
		}
		if(!this.erroresDeAsignacion.isEmpty()) {
			pw.println("ErroresDeAsignacion: ");
			for(Solicitud s2 : this.erroresDeAsignacion) {
				pw.println("\n" + s2);
			}
		}
	}
	public String toString() {
		StringJoiner sj = new StringJoiner(", " , "(", ")");
		sj.add("Solicitudes: " + String.valueOf(solicitudes.toString()));
		sj.add("ErroresDeAsignacion: " + String.valueOf(this.erroresDeAsignacion));
		sj.add("Asignaciones: " + String.valueOf(asignaciones));
		return sj.toString();
	}
	
}
