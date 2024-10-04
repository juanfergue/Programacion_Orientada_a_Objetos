package rank;

import java.util.Locale;

public class Site implements Comparable<Site>{
	private String name;
	private double rank;
	
	public Site(String n) {
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
		this.rank = this.rank + r;
	}
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Site) {
			Site other = (Site) o;
			ok = this.name.equalsIgnoreCase(other.name);
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return this.name.toUpperCase().hashCode();
	}
	@Override
	public int compareTo(Site other) {
		int res = this.name.compareToIgnoreCase(other.name);
		return res;
	}
	@Override
	public String toString() {
	return String.format(Locale.UK, "%s(%.5f)", name, rank);
	}
	/*
	public String toString() {
		return String.format("%s(.5%d)",this.name, this.rank);
	}*/
}
