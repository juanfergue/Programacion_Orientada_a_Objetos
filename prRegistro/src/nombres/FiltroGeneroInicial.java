package nombres;

public class FiltroGeneroInicial implements Filtro{
	private char genero;
	private char inicial;
	public FiltroGeneroInicial(char g, char i) {
		this.genero = g;
		this.inicial = i;
	}
	public boolean criterio(Nombre n) {
		return n.getGenero() == this.genero && n.getNombre().charAt(0) == inicial;
	}
}
