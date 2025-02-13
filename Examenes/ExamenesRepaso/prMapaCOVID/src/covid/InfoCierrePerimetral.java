package covid;
import java.util.*;
public class InfoCierrePerimetral implements InfoCOVID{
	private final static int CASOS_CIERRE = 500;
	public InfoCierrePerimetral() {
		
	}
	public Set<String> obtenerInfo(MapaCOVID mapa){
		Set<String> validos = new HashSet<>();
		for(String prov : mapa.getProvincias()) {
			if(mapa.incidenciaProvincia(prov) >= CASOS_CIERRE) {
				validos.add(prov);
			}
		}
		return validos;
	}
}
