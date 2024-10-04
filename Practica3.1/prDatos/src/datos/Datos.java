package datos;
import java.util.ArrayList;
import java.util.List;

public class Datos {

	private List<Double>datos;
	private List<String>errores;
	private double min;
	private double max;
	
	public Datos(String[] dat, double min, double max) {
		this.min = min;
		this.max = max;
		datos = new ArrayList<>();
		errores = new ArrayList<>();
		for(String d : dat) {
			try {
				datos.add(Double.parseDouble(d));
			}catch(NumberFormatException e) {
				errores.add(d);
			}
		}
	}
	public double calcMedia() {
		double suma = 0;
		int contador = 0;
		for (double x : datos) {
			if (min <= x && x <= max) {
			suma += x;
			++contador;
			}
		}
		if(contador==0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		return suma/contador;
	}
	
	public double calcDesvTipica() {
		double media = this.calcMedia();
		int contador = 0;
		double suma = 0;
		for(double i : datos) {
			if(i <= max && i >= min) {
				suma += Math.pow(i - media,2);
				contador++;
			}
		}
		return Math.sqrt(suma/contador);
	}
	
	public void setRango(String rango) {
		// Actualizar valores de max y min
		
		try {
			 int i = rango.indexOf(";");
			 min = Double.parseDouble(rango.substring(0, i)); // First value
			 max = Double.parseDouble(rango.substring(i+1)); // Second value
		}catch (IndexOutOfBoundsException e) {
			throw new DatosException("Error en los datos al establecer el rango");
		} catch (NumberFormatException e) {
			throw new DatosException("Error en los datos al establecer el rango");
		} catch (Exception e) {
			throw new DatosException("Error en los datos al establecer el rango");
		}

		}
	
	
	public List<Double> getDatos() {
		return datos;
	}
	
	public List<String> getErrores(){
		return errores;
	}
	
	@Override
	public String toString() {
		String str = "Min: "+min+", Max: "+max+",\n";
		str += "\n";
		str += datos.toString();
		str += ",";
		str += errores.toString();
		str +=",";
		
		try {
			str += "Media: " + calcMedia();
		}catch(Exception e) {
			str += "Media: " + "ERROR ,";
		}
		
		try {
			str+= "DesvTipica: " + calcDesvTipica();
		}catch(Exception e) {
			str+= "DesvTipica: " + "ERROR";
		}
		return str;
	}
}


