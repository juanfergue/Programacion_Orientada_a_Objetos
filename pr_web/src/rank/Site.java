package rank;

import java.util.Locale;
import java.util.Objects;

public class Site {
	private String name;
	private double rank;
	
	public Site(String name) {
		this.name = name;
		this.rank = 0;
	}

	public String getName() {
		return name;
	}

	public double getRank() {
		return rank;
	}
	public void addRank(double r) {
		this.rank += r;
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Site) {
			Site other = (Site) o;
			ok = this.getName().equalsIgnoreCase(other.getName());
		}
		return ok;
	}
	public int hashCode() {
		return Objects.hash(name.toLowerCase());
	}
	public int compareTo(Site other) {
		return this.getName().compareToIgnoreCase(other.getName());
	}
	public String toString() {
		return String.format(Locale.UK, "%s(%.5f", name, rank);
	}
}
