package nombres;

public class FiltroGeneroInicial implements Filtro{
	private char genero;
	private char inicial;
	
	public FiltroGeneroInicial(char g, char i) {
		this.genero = g;
		this.inicial = i;
	}
	public boolean criterio(Nombre nombre) {
		return nombre.getGenero()==genero && nombre.getNombre().charAt(0)==inicial;
	}
}
