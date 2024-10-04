package covid;

import java.util.TreeSet;
import java.util.Set;

public class InfoCierrePerimetral implements InfoCOVID{
	static final int CASOS_CIERRE  = 500;
	public InfoCierrePerimetral() {
		
	}
	public Set<String> obtenerInfo(MapaCOVID m) {
		Set<String> supera = new TreeSet<>();
		for(String prov : m.getProvincias()) {
			int iAcumulada = m.incidenciaProvincia(prov);
			if(iAcumulada >= CASOS_CIERRE) {
				supera.add(prov);
			}
		}
		return supera;
	}
}
