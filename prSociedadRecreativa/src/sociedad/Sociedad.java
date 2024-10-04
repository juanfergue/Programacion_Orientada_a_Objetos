package sociedad;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.*;
import java.io.PrintWriter;


public class Sociedad {
	private Map<String,Set<Socio>> membersInActivities;
	
	public Sociedad() {
		this.membersInActivities = new HashMap<>();
	}
	public void leerDeFichero(String fich) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(fich))){
			leerDeFichero(sc);
		}
	}
	private void leerDeFichero(Scanner sc) {
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			try(Scanner sclinea = new Scanner(linea)){
				while(sclinea.hasNext()) {
					sclinea.useDelimiter("%");
					String name = sclinea.next();
					Set<String> interest = new HashSet<>();
					try(Scanner scinterest = new Scanner(sclinea.next())){
						while(scinterest.hasNext()) {
							scinterest.useDelimiter(",");
							String i = scinterest.next();
							interest.add(i);
						}
					}
					int ident = Integer.parseInt(sclinea.next());
					nuevoSocio(new Socio(name, interest, ident));
				}
			}
		}
	}
	public void nuevoSocio(Socio m) {
		
	}
	public void guardarSocios(String fichero){
		try(PrintWriter pw = new PrintWriter(fichero)){
			guardarSocios(pw);
		}catch(SociedadException | FileNotFoundException e) {
			
		}
	}
	public void guardarSocios(PrintWriter pw) {
		
	}
}
