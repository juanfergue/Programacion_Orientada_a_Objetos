package covid;
import java.util.*;
public class InfoPoblacion implements InfoCOVID{
	private int minPoblacion;
	private int maxPoblacion;
	
	public InfoPoblacion(int min, int max) {
		if(min < 0 || max < 0 || min > max) {
			throw new COVIDException("ERROR rango negativo no válido");
		}
		this.maxPoblacion = max;
		this.minPoblacion = min;
	}
	public Set<String> obtenerInfo(MapaCOVID mapa){
		Set<String> validos = new HashSet<>();
		for(DistritoSanitario distrito : mapa.getDistritos()) {
			if(distrito.getPoblacion() > this.minPoblacion && this.maxPoblacion > distrito.getPoblacion() ) {
				validos.add(distrito.getDistrito());
			}
		}
		return validos;
	}
}
