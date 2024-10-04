package hospital;

import java.util.Objects;

public class Paciente {
	private String nombre;
	private String apellidos;
	private String nuss;
	private int anoDeNacimiento;
	
	public Paciente(String n, String a, String nuss, int nacimiento) throws HospitalException {
		if( n == null || n.isEmpty()) {
			throw new HospitalException("El nombre no puede ser ni nulo, ni vacío");
		}
		if( a == null || a.isEmpty()) {
			throw new HospitalException("El apellido no puede ser ni nulo, ni vacío");
		}
		if( nuss == null || nuss.isEmpty()|| (Integer.parseInt(nuss.substring(0,8)) % 97 == Integer.parseInt(nuss.substring(8, 10)))) {
			throw new HospitalException("El nuss no puede ser ni nulo, ni vacío");
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNuss() {
		return nuss;
	}

	public int getAnoDeNacimiento() {
		return anoDeNacimiento;
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof Paciente) {
			Paciente other = (Paciente) o;
			ok = this.getNombre().equalsIgnoreCase(other.getNombre()) && this.getApellidos().equalsIgnoreCase(other.apellidos)
					&& this.getNuss().equals(other.getNuss()) && (this.getAnoDeNacimiento() == other.getAnoDeNacimiento());
		}
		return ok;
	}
	public int hashCode() {
		return Objects.hash(nombre, apellidos, nuss, anoDeNacimiento);
	}
	public int compareTo(Paciente other) {
		int res = Integer.compare(anoDeNacimiento, other.anoDeNacimiento);
		if(res == 0) {
			res = this.nuss.compareTo(other.nuss);
			if(res == 0) {
				res= this.apellidos.compareToIgnoreCase(other.apellidos);
				if(res == 0) {
					res = this.nombre.compareToIgnoreCase(other.nombre);
				}
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellidos=" + apellidos + ", nuss=" + nuss + ", anoDeNacimiento="
				+ anoDeNacimiento + "]";
	}
}
