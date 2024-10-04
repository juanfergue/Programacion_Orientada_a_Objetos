package rank;

public class Link {
	private String origin;
	private String linked;
	
	public Link(String o, String l) {
		this.linked = l;
		this.origin = o;
	}

	public String getOrigin() {
		return origin;
	}

	public String getLinked() {
		return linked;
	}
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Link) {
			Link other = (Link) o;
			ok = this.linked.equalsIgnoreCase(other.linked) && this.origin.equalsIgnoreCase(other.origin);
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return this.linked.toUpperCase().hashCode() + this.origin.toUpperCase().hashCode();
	}
	public String toString () {
		return (this.origin + "->" + this.linked);
	}
}
