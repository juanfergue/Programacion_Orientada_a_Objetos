package elecciones;

public class Candidata {
	private String nombre;
	private String DNI;
	private String partido;
	private Sexo sexo;
	
	public Candidata(String n, String d, Sexo s, String p) {
		nombre = n;
		DNI = d;
		sexo = s;
		partido = p;
	}
	public Candidata(String n, String d, Sexo s) {
		nombre = n;
		DNI = n;
		sexo = s;
		partido = null;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getPartido() {
		return partido;
	}
	
	public String getDNI() {
		return DNI;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public boolean esIndependiente() {
		return partido == null;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void cambiarSexo() {
		if(sexo == Sexo.F) {
			this.sexo = Sexo.M;
		}else {
			this.sexo = Sexo.F;
		}
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	@Override
	public String toString() {
		String salida;
		if(esIndependiente()) {
			salida = ( "Candidata [nombre=" + nombre + ", DNI=" + DNI + 
					",partido: (independiente)" + ", sexo=" + sexo + "]");
		}else {
			salida =( "Candidata [nombre=" + nombre + ", DNI=" + DNI + 
				", partido=" + partido + ", sexo=" + sexo + "]");
		}
		return salida;
	}
	
}
