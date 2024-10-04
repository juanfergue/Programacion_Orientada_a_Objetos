package covid;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.io.File;
public class MapaCOVID {
	private String nombre;
	private SortedMap<String,SortedSet<DistritoSanitario>> mapa;
	
	public MapaCOVID(String region, String nomFIch) {
		
	}
	public void leerDatos(String nomFichero) throws FileNotFoundException {
		try(Scanner scFichero = new Scanner(new File(nomFichero))) {
			leerDatos(scFichero);
		}
	}
	public void leerDatos(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			try(Scanner scLinea = new Scanner(linea)){
				scLinea.useDelimiter("[():]+");
				String distrito = scLinea.next();
				String provincia = scLinea.next();
				int poblacion = scLinea.nextInt();
				int casosCOVID = scLinea.nextInt();
				DistritoSanitario ds = new DistritoSanitario(distrito,poblacion,casosCOVID);
				agregarDistrito(provincia,ds);
			} catch (NoSuchElementException | COVIDException nsee) {
				// Se ignora la línea
			} 
		}
	}
	
	public void agregarDistrito(String prov, DistritoSanitario ds) {
		SortedSet<DistritoSanitario> distrito = mapa.get(prov);
		if(distrito == null) {
			distrito = new TreeSet<>();
			mapa.put(prov, distrito);
		}
		distrito.add(ds);
	}
	public String getNombre() {
		return nombre;
	}
	public Set<DistritoSanitario> getDistritos() {
		SortedSet<DistritoSanitario> distritos = new TreeSet<>();
        for (SortedSet<DistritoSanitario> distritosProvincia : mapa.values()) {
            distritos.addAll(distritosProvincia);
        }
        return distritos;
	}
	public Set<String> getProvincias(){
		return mapa.keySet();
	}
	public int incidenciaProvincia(String prov) {
		SortedSet<DistritoSanitario> distritos = mapa.getOrDefault(prov,new TreeSet<>());
		int poblacionProv = 0;
		int casosProv = 0;
		for (DistritoSanitario distrito : distritos) {
			poblacionProv += distrito.getPoblacion();
			casosProv += distrito.getCasosCOVID14dias();
		}
		return poblacionProv == 0 ? 0 : casosProv*100000 / poblacionProv;
	}
	public Set<String> obtenerInfoCOVID(InfoCOVID info) {
		return info.obtenerInfo(this);
	}
	
	public void mostrarMapa(String nomFichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(nomFichero)) {
			mostrarMapa(pw);
		}
	}
	public void mostrarMapa(PrintWriter pw) {
		pw.println(nombre.toUpperCase()+": ");
		for(Map.Entry<String,SortedSet<DistritoSanitario>> entrada : mapa.entrySet()) {
			pw.println(entrada.getKey());
			for(DistritoSanitario distrito : entrada.getValue())
				pw.println("\t" + distrito);
		}
	}
}
