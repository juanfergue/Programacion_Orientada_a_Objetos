package pruebasmetodos;
import java.util.*;
import java.util.Arrays;

public class main {
	
	public static void main(String[] args) {
		/* Metodo join()
		String[] datos = {"Juan", "Andrea", "Pepe", "Jose"};
		String s1 = String.join(" ; ", datos);
		List<String> datos2 = new ArrayList<>(Arrays.asList(datos));
		
		System.out.println(s1.toString());
		System.out.println(datos2.toString());
		 ----------------------------------
		 Metodo StringJoiner
		String[] datos = {"Coche" , "Casa" , "Perro" , "Pelota"};
		StringJoiner sj = new StringJoiner(" ; ", "[ " , " ]");
		
		for(String x : datos) {
			sj.add(x);
		}
		System.out.println(sj.toString());
		------------------------
		 Metodo StringBuilder
		String[] datos = {"ordenador" , "portatil" , "pantalla" , "movil"};
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		if(datos.length > 0) {
			sb.append(datos[0]);
			for(int i = 1; i < datos.length; i++) {
				sb.append(" ; ");
				sb.append(datos[i]);
			}
		}
		sb.append(" ]");
		System.out.println(sb.toString());
		-----------------
		final String frase = "ANTES tenia un ordenador";
		final String antes = "ordenador";
		final String ahora = "portatil";
		StringBuilder sb = new StringBuilder(frase);
		int cont = 0;
		while(cont + antes.length() <= sb.length() ) {
			if(antes.equalsIgnoreCase(frase.substring(cont, cont + antes.length()))) {
				sb.replace(cont, cont + antes.length(), ahora);
				cont += ahora.length();
			}else {
				cont++;
			}
		}
		sb.append(" mejor que el que antes");
		
		System.out.println(sb);
		----------------------
		Metotodo Random
		Random rnd = new Random();
		List<Double> nRandom = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			nRandom.add(i, rnd.nextDouble(100));
		}
		System.out.println(nRandom.toString());
		Random rnd1 = new Random();
		List<Integer> nRandom1 = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			nRandom1.add(i, rnd1.nextInt(100));
		}
		System.out.println(nRandom1.toString());
		---------------------------------
		List<String> texto = new ArrayList<>();
		int cont = 0;
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Introduzca una frase acabada en . : ");	
			while(cont < 10) {
				texto.add(cont, sc.next());
				cont++;
			}
		}catch(NoSuchElementException e) {
			System.out.println("Error en la lectura");
		}
		StringBuilder sb = new StringBuilder();
		if(texto.size() > 0) {
			
			sb.append(texto.get(0));
			for(int i = 1 ; i < texto.size(); i++) {
				sb.append(" ");

				sb.append(texto.get(i));
			}
			sb.append(" FIN");
		}
		System.out.println(sb.toString());*/
	
	}
	

}
