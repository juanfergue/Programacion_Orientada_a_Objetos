package hospital;

public class Paciente {
	private String nombre;
	private String apellidos;
	private String nuss;
	private int anoDeNacimiento;
	
	public Paciente(String n, String a, String nuss, int ano) throws HospitalException {
		if(n.isEmpty() || a.isEmpty() || nuss.isEmpty() || Integer.parseInt(nuss) != 10) {
			throw new HospitalException("ERROR en los valores introducidos no pueden ser null");
		}
		int nus = Integer.parseInt(nuss);
		
		if(Integer.parseInt(nuss))
	}
}
