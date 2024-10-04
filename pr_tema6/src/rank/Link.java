package rank;

public class Link {
	private String origin;
	private String linked;
	
	public Link(String o, String l) {
		this.origin = o;
		this.linked = l;
	}

	public String getOrigin() {
		return origin;
	}

	public String getLinked() {
		return linked;
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Link) {
			Link other = (Link) o;
			ok = (this.linked.equalsIgnoreCase(other.linked))
		}
		
		return ok;
	}
	
	//public int hashCode() {
		
	//}
	//public String toString() {
		
	//}
}
