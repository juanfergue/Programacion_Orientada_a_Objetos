package indices;

import java.io.PrintWriter;

public interface Indice {
	public  void agregarFrase(String linea);
	
	public void resolver(String delimitadores);
		
	public void presentarIndice(PrintWriter pw);
	
	default void presentarIndiceConsola() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(System.out, true);	
			presentarIndice(pw);
		}
		finally {
			if(pw != null) {
				pw.flush();// flush fuerza el volcado de los datos a consola

			}
		}
	}
}
