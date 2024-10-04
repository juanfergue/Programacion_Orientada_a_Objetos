package nombres;

public class FiltroLongitud implements Filtro{
	private int longitud;
	public FiltroLongitud(int l) {
		this.longitud = l;
	}
	public boolean criterio(Nombre n) {
		return n.getNombre().length() == this.longitud;
	}
}
