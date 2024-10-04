package covid;

import java.util.Set;
import java.util.TreeSet;

public class InfoPoblacion implements InfoCOVID{
	private int min;
	private int max;
	
	public InfoPoblacion(int min, int max) {
		if(min > max) {
			throw new COVIDException("El limite de población debe ser positivo");
		}
		this.max = max;
		this.min = min;
	}
	public Set<String> obtenerInfo(MapaCOVID m) {
		Set<String> validos = new TreeSet<>();
		for(DistritoSanitario distrito : m.getDistritos()) {
			int poblacion = distrito.getPoblacion();
			if( min <= poblacion && poblacion <= max) {
				validos.add(distrito.getDistrito());
			}
		}
		return validos;
	}
}
