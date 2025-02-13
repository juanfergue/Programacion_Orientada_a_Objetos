package sociedad;

import java.util.*;

public class Socio implements Comparable<Socio>{
	private String name;
	private Set<String> interests;
	private int ident;
	
	public Socio(String n, Set<String> inter, int i) {
		if(n.length() == 0 || n.isEmpty()) {
			throw new SociedadException("ERROR el nombre no puede ser null");
		}
		if(i <= 0) {
			throw new SociedadException("ERROR el identificador debe ser mayor que 0");
		}
		this.name = n;
		this.ident = i;
		interests = new HashSet<>();
		for(String interest : inter) {
			interests.add(interest.toLowerCase());
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
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Socio) {
			Socio other = (Socio) o;
			ok = this.name.equalsIgnoreCase(other.name) && (this.ident == other.ident);
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return this.name.hashCode() + Integer.hashCode(ident);
	}
	@Override
	public int compareTo(Socio other) {
		int res = this.name.compareToIgnoreCase(other.name);
		if(res == 0) {
			res = Integer.compare(ident, other.ident);
		}
		return res;
	}
	public String toString() {
		return ("[" + this.name + ", " + interests.toString() + ", " + this.ident + "]");
	}
}
