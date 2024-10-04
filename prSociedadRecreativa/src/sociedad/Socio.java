package sociedad;

import java.util.Set;
import java.util.HashSet;

 

public class Socio {
	private String name;
	private Set<String> interests;
	private int ident;
	
	public Socio(String n, Set<String> i, int id) {
		if(n == null || n.equals("") || id <= 0) {
			throw new SociedadException("Error: valores de Socio introducidos no validos");
		}
		name = n;
		ident = id;
		interests = new HashSet<>();
		for(String it : i) {
			interests.add(it.toLowerCase());
		}
	}

	public String getName() {
		return name;
	}

	public Set<String> getInterests() {
		return interests;
	}

	public int getIdent() {
		return ident;
	}
	public String toString() {
		return ("[" + name + ", " + interests.toString() + ", " + this.ident + "]");
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Socio) {
			Socio other = (Socio) o;
			ok = this.name.equalsIgnoreCase(other.name) && this.ident == other.ident;
		}
		return ok;
	}
	public int hashCode() {
		return this.name.toUpperCase().hashCode() + Integer.hashCode(ident);
	}
	public int compareTo(Socio other) {
		int res = this.name.compareToIgnoreCase(other.name);
		if(res == 0) {
			Integer.compare(ident, other.ident);
		}
		return res;
	}
}
