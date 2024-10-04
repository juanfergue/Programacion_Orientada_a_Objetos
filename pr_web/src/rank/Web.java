package rank;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class Web {
	private static final double THRESHOLD = 1E-5;
	private static Random alea = new Random(1);
	private Set<Link> links;
	protected Set<Site> sites;
	
	public Web() {
		Set<Link> links = new HashSet<>();
		Set<Site> sites = new HashSet<>();
	}
	protected void addSite(Site site) {
		sites.add(site);
	}
	protected void addSiteWithName(String name) {
		Site nSite = new Site(name);
		sites.add(nSite);
	}
	public void addLink(String dataLink) {
		try{
			String[] datos = dataLink.split("\\s*->\\s*");
			this.addSiteWithName(datos[0]);
			this.addSiteWithName(datos[1]);
			links.add(new Link(datos[0], datos[1]));
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Bad line"+ dataLink);
		}
	}
	public void addLink_AlternativoConScanner(String dataLink) {
		try(Scanner sc = new Scanner(dataLink)){
			sc.useDelimiter("\\s*->\\s*");
			String site1 = sc.next();
			String site2 = sc.next();
			this.addSiteWithName(site1);
			this.addSiteWithName(site2);
			links.add(new Link (site1,site2));
		}
	}
	public Site getSite(String name) {
		boolean ok = false;
		Site a = null;
		Iterator<Site> it = sites.iterator();
		while(!ok && it.hasNext()) {
			a = it.next();
			ok = name.equalsIgnoreCase(a.getName());
		}
		if(!ok) {
			throw new NoSuchElementException("No such site " + name);
		}
		return a;
	}
	
}
