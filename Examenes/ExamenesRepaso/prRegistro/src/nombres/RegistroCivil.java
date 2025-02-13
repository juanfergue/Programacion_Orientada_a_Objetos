package nombres;


import java.util.*;
import java.io.File;

public class RegistroCivil {
	private String estado;
	private SortedMap<Nombre, SortedMap<Integer,Integer>> registro;
	
	public RegistroCivil(String cod, String fichero) {
		if(cod.length() == 0 || cod.isEmpty()) {
			throw new RegistroCivilException("ERROR, codigo de estado vacio");
		}
		estado = cod;
		registro = new TreeMap<>();
		leerFichero(fichero);
	}
	private void leerFichero(String fichero) {
		try (Scanner sc = new Scanner(new File(fichero))){
			while(sc.hasNext()) {
				String linea = sc.next();
				procesar(linea);
			}
		}catch(Exception e) {
			
		}
	}
	private void procesar(String linea) {
		try(Scanner scLinea = new Scanner(linea)){
			scLinea.useDelimiter("[;]");
			String estado = scLinea.next(); // no sirve para nada
			char genero = scLinea.next().charAt(0);
			int ano = Integer.parseInt(scLinea.next());
			String nombre = scLinea.next();
			int rep = Integer.parseInt(scLinea.next());
			Nombre n = new Nombre(nombre, genero);
			agregar(n,ano, rep);
			
		}catch(Exception e) {
			//Ignorar
			System.err.println(linea);
		}
	}
	private void agregar (Nombre n, int ano, int rep) {
		SortedMap<Integer,Integer> map = registro.get(n);
		if( map == null) {
			map = new TreeMap<>();
			registro.put(n, map);
		}
		map.put(ano, rep);
	}
	public String getEstado() {
		return estado;
	}
	public Set<Nombre> getNombres(){
		return registro.keySet();
	}
	public SortedSet<String> selecciona(Filtro f){
		SortedSet<String> conjunto = new TreeSet<>();
		for(Nombre n : this.getNombres()) {
			if(f.criterio(n)) {
				conjunto.add(n.getNombre());
			}
		}
		return conjunto;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder(estado);
		sb.append("\n");
		Set<Nombre> nombres = registro.keySet();
		for(Nombre nombre : nombres) {
			sb.append(nombre);
			sb.append("\t");
			sb.append(registro.get(nombre));
			sb.append("\n");
		}
		return sb.toString();		
	}
}


