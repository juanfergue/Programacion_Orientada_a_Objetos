package rank;

import java.util.Objects;
import java.util.StringJoiner;
public class Link {
	private String origin;
	private String linked;
	
	public Link(String org, String lnk) {
		this.origin = org;
		this.linked = lnk;
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
			ok = this.linked.equalsIgnoreCase(other.linked)
					&& this.origin.equalsIgnoreCase(other.origin);
		}
		return ok;
	}
	public int hashCode() {
		return Objects.hash(origin.toLowerCase(), linked.toLowerCase());
	}
	public String toString() {
		return (origin + "->" + linked);
	}
	
}
