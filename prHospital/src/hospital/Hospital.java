package hospital;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Hospital {
	protected Map<Paciente, Habitacion> habitaciones;
	protected SortedSet<Habitacion> libres;
	private int plantas;
	private String nombre;
	
	public Hospital(String nombre, int plantas, int habitaciones) throws HospitalException {
		if(nombre == null || nombre.isEmpty()) {
			throw new HospitalException("EL nombre no puede ser vacio, ni nulo");
		}
		if( plantas < 0 || habitaciones < 0) {
			throw new HospitalException("La planta y la habitación no pueden ser negativos");
		}
		this.nombre = nombre;
		this.habitaciones = new HashMap<>();
		libres = new TreeSet<>();
		for(int p = 0; p < plantas; p++) {
			for(int h = 0; h < habitaciones; h++) {
				libres.add(new Habitacion(p, h));
			}
		}
		this.plantas = plantas;
	}
	public void leePacientes(String nomFich) throws FileNotFoundException, HospitalException {
		try (Scanner sc = new Scanner(new File(nomFich))){
			leePacientes(sc);
		}
	}
	public void alta(Paciente p) throws HospitalException {
		if( p == null) {
			throw new HospitalException("Error: Paciente null");
		}
		if( libres.size() == 0) { //para ver si quedan habitaciones libres
			throw new HospitalException("Error: no hay habitaciones libres");
		}
		if( habitaciones.keySet().contains(p)) { //Para ver si ya esta el paciente almacenado
			throw new HospitalException("Error: el paciente ya tiene una habitacion");
		}
		Habitacion h = libres.first(); // h es la primera habitacion libre que hay
		libres.remove(h); // Elimina la habitacion h de libres
		habitaciones.put(p, h); // añade a habitacionas al paciente con su habitacion
	}
	public Paciente baja(String nuss) {
		Paciente baja = null;
		boolean encontrado = false;
		Iterator<Paciente> it = habitaciones.keySet().iterator();
		while( it.hasNext() && !encontrado) {
			baja = it.next();
			encontrado = baja.getNuss().equals(nuss);
		}
		if(encontrado) {
			libres.add(habitaciones.get(baja));
			habitaciones.remove(baja);
		}
		return baja;
	}
	private void leePacientes(Scanner sc) {
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			try(Scanner sclinea = new Scanner(linea)){
				sclinea.useDelimiter("[,]");
				String nombre = sclinea.next();
				String apellidos = sclinea.next();
				String nuss = sclinea.next();
				int nacimiento = Integer.parseInt(sclinea.next());
				Paciente p = new Paciente(nombre, apellidos, nuss, nacimiento);
				alta(p);
			}catch(HospitalException | NoSuchElementException | NumberFormatException | IndexOutOfBoundsException e) {
				
			}
		}
	}
}

