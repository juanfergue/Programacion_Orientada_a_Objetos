package datos2;
import java.util.ArrayList;
import java.util.List;
public class Datos2 {
	private List<Double> datos;
	private List<String> errores;
	private double min;
	private double max;
	
	public Datos2(String[] dat, double mi, double ma) {
		datos = new ArrayList<>();
		errores = new ArrayList<>();
		this.min = mi;
		this.max = ma;
		for(String i : dat) {
			try {
				datos.add(Double.parseDouble(i));
			}catch(NumberFormatException e) {
				errores.add(i);
			}
		}
	}
	
	public double calcMedia() {
		double sum = 0;
		int cont = 0;
		for(Double i : datos) {
			if(min < i && i < max) {
				sum += i;
				cont++;
			}			
		}
		if(cont == 0) {
			throw new DatosException("No ha datos en el rango especificado");
		}
		return sum/datos.size();
	}
	public double calcDesvTipica() {
		double sum = 0;
		double media = calcMedia();
		for(Double i : datos) {
			if(min < i && i < max) {
				sum = Math.pow(i + media, 2);
			}
		}
		
		return Math.sqrt(sum/datos.size());
	}
	public void setRango(String rango) {
		try {
			int idx = rango.indexOf(";");//indexOf te busca en el arreglo ; si lo encunetra te devuelve la posición de este si no esta devuelve -1
			if(idx == -1) {
				throw new RuntimeException("Error en los datos al establecer el rango");
			}
			min = Double.parseDouble(rango.substring(0, idx));//substring divide el string en dos para analizar su contenido
			max = Double.parseDouble(rango.substring(idx + 1));
		}catch(NumberFormatException e) {
			throw new DatosException("Error en los datos al establecer el rango");
		}
		
		
	}
}
