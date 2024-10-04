package parrillatv;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProgramacionTV {
	protected Map<String,SortedSet<ProgramaTV>> cadenas ;
	
	public ProgramacionTV() {
		cadenas = new HashMap<>();
	}
	public void agregar(String cadenaTV, ProgramaTV prog) {
		SortedSet<ProgramaTV> programas;
		if(!cadenas.containsKey(cadenaTV)) {
			programas = new TreeSet<>();
			cadenas.put(cadenaTV, programas);
		}else {
			programas = cadenas.get(cadenaTV);
		}
		programas.add(prog);
	}
	
	
	public void leerProgramas(String fichero) throws IOException {
		
		try(Scanner scFichero = new Scanner(Path.of(fichero))){
			leerProgramas(scFichero);
		}
		
		
		
	}

	/**
	 * Método auxiliar para incorporar a la correspondencia cadenas (Map) los programas que se proporcionan
	 * en una lista de líneas con el formato siguiente:
	 * 		Nombre de la cadena>Nombre del programa@hh:mm-minutos
	 * En caso de que el formato de una línea sea incorrecto, esta se obvia y se sigue con el resto de líneas.
	 * 
	 * @param lineas	Lista de líneas con información sobre cadenas y programas.
	 */
	private void leerProgramas(List<String> lineas) {
		for (String linea : lineas)
			leerLinea(linea);
	}
	
	/**
	 * Método auxiliar para incorporar a la correspondencia cadenas (Map) los programas que se leen del scanner sc
	 * El formato de las líneas del scanner ha de ser el siguiente:
	 * 		Nombre de la cadena>Nombre del programa@hh:mm-minutos
	 * En caso de que el formato de una línea sea incorrecto, esta se obvia y se sigue con el resto de líneas.
	 * 
	 * @param sc	 	Scanner con la información sobre cadenas y programas.
	 */
	private void leerProgramas(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			leerLinea(linea);
		}
	}

	/**
	 * Método auxiliar para incorporar a la corresondencia cadenas (Map) los programas que se lean de la
	 * línea que se pasa como parámetro. La línea debe tener el siguiente formato:
	 * 		Nombre de la cadena>Nombre del programa@hh:mm-minutos
	 * En caso de que el formato de la línea no sea el correcto, se obvia.
	 * @param linea		Línea incluyendo información sobre un programa de una cadena
	 */
	private void leerLinea(String linea) {
		try (Scanner scLinea = new Scanner(linea)) {
			scLinea.useDelimiter("[>@:-]+");
			String nombreCadena = scLinea.next();
			String nombrePrograma = scLinea.next();
			int hh = scLinea.nextInt();
			int mm = scLinea.nextInt();	
			int duracion = scLinea.nextInt();
			Hora horaInicio = new Hora(hh,mm);
			ProgramaTV prog = new ProgramaTV(nombrePrograma,horaInicio,duracion);
			agregar(nombreCadena,prog);
		} catch (NoSuchElementException | ProgramacionTVException excep) {
			// En caso de que exista un error de formato en la línea, 
			// este se obvia y se siguen procesando el resto de líneas.
		}
	}
	
	public void mostrarProgramas(String fichero) {
		try(PrintWriter pw = new PrintWriter(fichero)){
			mostrarProgramas(pw);
		}catch(Exception e) {
			throw new ProgramacionTVException("ERROR al guardar en fichero");
		}
	}
	public void mostrarProgramas(PrintWriter pw) {
		for(Map.Entry<String,SortedSet<ProgramaTV>> cadena : cadenas.entrySet()) {
			pw.println("\n" + cadena.getKey() + ":\t");
			for(ProgramaTV prog : cadena.getValue()) {
				pw.println("\n" + prog.toString());
			}
		}
		
	}

	
}
