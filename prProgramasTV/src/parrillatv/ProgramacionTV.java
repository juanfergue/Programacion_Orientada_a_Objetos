package parrillatv;

import java.util.Map;
import java.util.SortedSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;


public class ProgramacionTV {
	protected Map<String, SortedSet<ProgramaTV>> cadenas;
	
	public ProgramacionTV() {
		cadenas = new HashMap<>();
	}
	public void agregar(String cadenaTV, ProgramaTV prog) {
		SortedSet<ProgramaTV> programas = cadenas.get(cadenaTV);
		if(programas == null) {
			programas = new TreeSet<>();
			cadenas.put(cadenaTV, programas);
		}
		programas.add(prog);
	}
	public boolean esConsistente(String cadenaTV) {
		boolean consistente = true;
		SortedSet<ProgramaTV> programas = cadenas.get(cadenaTV);
		if (programas == null) throw new ProgramacionTVException("La cadena de TV indicada no aparece en la parrilla");
		Iterator<ProgramaTV> it = programas.iterator();
		// if (!it.hasNext()) throw new ProgramacionTVException("No hay programas asociados a la cadena" + cadenaTV);
		ProgramaTV prog = it.next();
		while (it.hasNext() && consistente) {
			ProgramaTV progSiguiente = it.next();
			consistente = prog.getHoraFin().compareTo(progSiguiente.getHoraInicio()) <= 0;
			prog = progSiguiente;
		}
		return consistente;
	}
	public void leerProgramas(String nomFich) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(nomFich))){
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				try(Scanner sclinea = new Scanner(linea)){
					while(sclinea.hasNext()) {
						sclinea.useDelimiter("[>@:-]+");
						String cadena = sclinea.next();
						String programa = sclinea.next();
						int hora = Integer.parseInt(sclinea.next());
						int min = Integer.parseInt(sclinea.next());
						int duracion = Integer.parseInt(sclinea.next());
						Hora h = new Hora(hora, min);
						ProgramaTV p = new ProgramaTV(programa, h, duracion);
						this.agregar(cadena, p);
					}
				}
			}
		}catch(FileNotFoundException | ProgramacionTVException e) {
			
		}
	}
	public void mostrarProgramas(String fichero) throws FileNotFoundException {
		try(PrintWriter pwfichero = new PrintWriter(fichero)) {
			mostrarProgramas(pwfichero);
		}
	}
	public void mostrarProgramas(PrintWriter pw) {
		for(String cadenaTV : cadenas.keySet()) {
			pw.println(cadenaTV);
			for(ProgramaTV programa : cadenas.get(cadenaTV)) {
				pw.println("\t" + programa);
			}
		}
	}
	public SortedSet<ProgramaTV> sugerencias(SugerenciasTV seleccion){
		Collection<ProgramaTV> programas = new HashSet<>();
		for(Collection<ProgramaTV> prog : cadenas.values()) {
			programas.addAll(prog);
		}
		return seleccion.sugerencias(programas);
	}

}
