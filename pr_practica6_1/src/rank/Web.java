package rank;

import java.util.Random;
import java.util.Set;
import java.util.*;


public class Web {
	private static final double THRESHOLD = 1E-5;
	private static Random alea = new Random(1);
	private Set<Link> links;
	private Set<Site> sites;
	
	public Web() {
		links = new HashSet<>();
		sites = new HashSet<>();
	}
	protected void addSite(Site site) {
		sites.add(site);
	}
	protected void addSiteWithName(String name) {
		Site s = new Site(name);
		addSite(s);
	}
	public void addLink(String dataLink) {
		try(Scanner sc = new Scanner(dataLink)){
			sc.useDelimiter("\\s*->\\s*");
			String s1 = sc.next();
			String s2 = sc.next();
			this.addSiteWithName(s1);
			this.addSiteWithName(s2);
			Link l1 = new Link(s1,s2);
			links.add(l1);
			
		}catch(Exception e) {
			throw new IllegalArgumentException( dataLink + "Ha dado problema");
		}
	}
	public Site getSite(String name) {
		Site s = null;
		boolean ok = false;
		Iterator<Site> it = sites.iterator();
		while(!ok && it.hasNext()) {
			s = it.next();
			ok = name.equalsIgnoreCase(s.getName());
		}
		if(!ok) {
			throw new NoSuchElementException("No such site " + name);
		}
		return s;
	}
	public Set<String> getNames(){
		Set<String> paginas = new HashSet<>();
		for(Site s : sites) {
			paginas.add(s.getName());
		}
		return paginas;
	}
	
	
	private Set<Site> getSitesLinkedFrom(Site site){
		Set<Site> enlazadas = new HashSet<>();
		for(Link l : links) {
			Site org = this.getSite(l.getOrigin());
			if ( org.equals(site)) {
				enlazadas.add(this.getSite(l.getLinked()));
			}
		}
		
		return enlazadas;
	}
	protected void distribute(Site site, double prize) {
		if (prize >= THRESHOLD) {
			double halfPrize = prize/2;
			site.addRank(halfPrize);
			Set<Site> set = getSitesLinkedFrom(site);
			if (!set.isEmpty()) {
				double newPrize = halfPrize/set.size();
					for(Site s: set) {
						distribute(s, newPrize);
					}
			}
		}
	}

	public void click(String name) {
		try{
			Site s = this.getSite(name);
			distribute(s, 1);
		}catch(Exception e) {
			//Ignorar
		}
	}
	public void simulateClick(int numClick) {
		List<String> names = new ArrayList<>(this.getNames());
		int size = names.size();
		if(size > 0) {
			for(int i = 0; i < numClick; ++i) {
				int pos = alea.nextInt(size);
				this.click(names.get(pos));
			}
		}	
	}
	public SortedSet<Site> getSitesByName(){
		SortedSet<Site> set = new TreeSet<>(sites);
		return set;
	}
	public SortedSet<Site> getSitesByRank(){
		Comparator<Site> comp = new RankOrder().reversed().thenComparing(Comparator.naturalOrder());
		SortedSet<Site> set = new TreeSet<>(comp);
		set.addAll(sites);
		return set;
	}
	public String toString() {
		return String.format("Web(%s, %s)", sites,links);
	}


	
	
}
