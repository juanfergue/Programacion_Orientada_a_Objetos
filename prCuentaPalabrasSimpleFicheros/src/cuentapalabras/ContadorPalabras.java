package cuentapalabras;
import java.util.List;
import java.util.ArrayList;
public class ContadorPalabras {
	private List<PalabraEnTexto> palabras;
	
	public ContadorPalabras(){
		palabras = new ArrayList<>();
	}
	private int esta(String pal) {
		int i = 0;
		PalabraEnTexto aux = new PalabraEnTexto(pal);
		while( i < palabras.size() && palabras.get(i).equals(aux)) {
			i++;
		}
		return (i < palabras.size()) ? i : -1;
	}
	protected void incluye(String pal) {
		if(!pal.equals(null)){
			if(this.esta(pal) != -1) {
					palabras.get(esta(pal)).incrementa();
			}else {
					PalabraEnTexto aux = new PalabraEnTexto(pal);
					palabras.add(aux);
			}
		}
	}
	private void incluyeTodas( String linea, String del) {
		String[] datos = linea.split(del);
		for( String x : datos) {
		 this.incluye(x);
		}
	}
	public void incluyeTodas(String[] texto, String del) {
		for(String x : texto) {
			this.incluyeTodas(x, del);
		}
	}
	
}
