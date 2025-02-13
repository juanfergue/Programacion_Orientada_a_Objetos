package sociedad;

import java.util.*;
import java.io.File;
import java.io.PrintWriter;


public class Sociedad {
	private Map<String,Set<Socio>> membersInActivities;
	private Set<Socio> membersNotInActivities;
	
	public Sociedad() {
		membersInActivities = new HashMap<>();
		this.membersNotInActivities = new HashSet<>();
	}
	public void leerDeFichero(String fich) {
		try(Scanner sc = new Scanner(new File(fich))){
			leerDeFichero(sc);
		}catch(Exception e) {
			throw new SociedadException("ERRO al leer el fichero: " + fich);
		}
	}
	public void leerDeFichero(Scanner sc) {
		while(sc.hasNext()) {
			try(Scanner linea = new Scanner(sc.nextLine())){
				linea.useDelimiter("[%]");
				String name = linea.next();
				Set<String> interest = new HashSet<>();
				try(Scanner inter = new Scanner(linea.next())){
					inter.useDelimiter("[,]");
					while(inter.hasNext()) {
						interest.add(inter.next());
					}
				}
				int ident = Integer.parseInt(linea.next());
				nuevoSocio(new Socio(name, interest, ident));
			}catch(Exception e) {
				throw new SociedadException("ERRO al leer linea");
			}
		}
	}
	public void nuevoSocio(Socio m) {
		Set<String> actividades = this.membersInActivities.keySet();
		Iterator<String> itAct = actividades.iterator();
		boolean found = false;
		while(!found && itAct.hasNext()) {
			found = membersInActivities.get(itAct.next()).contains(m);
		}
		if( !found && !this.membersNotInActivities.contains(m)){
			this.membersNotInActivities.add(m);
		}
	}
	public Set<Socio> inscritos(String actividad){
		return this.membersInActivities.get(actividad.toLowerCase());
	}
	protected Socio buscarSocioEnConjunto(Socio m, Set<Socio> sm) {
		boolean found = false;
		Socio presentMember = null;
		if(sm != null) {
			Iterator<Socio> itMem = sm.iterator();
			while(!found && itMem.hasNext()) {
				presentMember = itMem.next();
				if(presentMember.equals(m)) {
					found = true;
				}
			}
		}
		return found?presentMember:null;
	}
	public void inscribir(String nombre, int identificador, String actividad) {
		Set<String> set = new HashSet<>();
		Set<Socio> socios; 
		Socio s = buscarSocioEnConjunto(new Socio(nombre, set, identificador), this.membersNotInActivities);
		if(s != null) {
			if(!this.membersInActivities.containsKey(actividad.toLowerCase())) {
				socios = new HashSet<>();
				this.membersInActivities.put(actividad.toLowerCase(), socios);
			}else {
				socios = this.membersInActivities.get(actividad.toLowerCase());
			}
			socios.add(s);
		}
	}
	
	public void guardarSocios(String fich) {
		try(PrintWriter pw = new PrintWriter(fich)){
			guardarSocios(pw);
		}catch(Exception e) {
			throw new SociedadException("ERROR al guardar en fichero");
		}
	}
	
	public void guardarSocios(PrintWriter pw) {
		for(Socio s : this.membersNotInActivities) {
			pw.println("\n" + s);
		}
		pw.flush();
	}
}
