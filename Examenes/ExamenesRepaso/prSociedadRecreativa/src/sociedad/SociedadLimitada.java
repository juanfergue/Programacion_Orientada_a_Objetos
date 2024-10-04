package sociedad;

import java.util.Set;

public class SociedadLimitada extends Sociedad{
	private int positionsLimit;
	
	public SociedadLimitada(int numeroDePlazas) {
		super();
		if(numeroDePlazas <= 0) {
			throw new SociedadException("ERROR el numero de plazas no puede ser negativo");
		}
		this.positionsLimit = numeroDePlazas;
	}
	@Override
	public void inscribir(String nombre, int identificacion, String actividad) {
		Set<Socio> sActividad = this.inscritos(actividad);
		if(sActividad != null && sActividad.size() >= this.positionsLimit) {
			throw new SociedadException("ERROR NO hay plazas disponibles");
		}
		super.inscribir(nombre, identificacion, actividad);
	}
}
