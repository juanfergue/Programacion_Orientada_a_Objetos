package rank;

import java.util.Locale;

public class Site implements Comparable<Site>{
	private String name;
	private double rank;
	
	public Site (String n) {
		this.name = n;
		this.rank = 0;
	}

	public String getName() {
		return name;
	}

	public double getRank() {
		return rank;
	}
	public void addRank(double r) {
		this.rank = this.rank +r;
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Site) {
			Site other = (Site) o;
			ok = (this.name.equalsIgnoreCase(other.name));
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return java.util.Objects.hash(this.name.toLowerCase());
	}
	public int compareTo(Site other) {
		int resultado = this.name.compareToIgnoreCase(other.name);
		return resultado;
	}
	public String toString() {
		return String.format(Locale.US,"%s(%.5f)", this.name, this.rank);
	}
}
