package covid;

public class DistritoSanitario {
	private String distrito;
	private int poblacion;
	private int casosCOVID14dias;
	
	public DistritoSanitario(String d, int p, int c) {
		if(p == 0 || p < 0) {
			throw new COVIDException("Error: La poblacion no puede ser ni cero, ni negativa");
		}
		if( c < 0) {
			throw new COVIDException("Error: Los casos no pueden ser negativos");
		}
		if(distrito == null || distrito.length() == 0) {
			throw new COVIDException("Error: El distrito no puede estar vacío");
		}
		this.distrito = d;
		this.poblacion = p;
		this.casosCOVID14dias = c;
	}

	public String getDistrito() {
		return distrito;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public int getCasosCOVID14dias() {
		return casosCOVID14dias;
	}

	public void setCasosCOVID14dias(int casosCOVID14dias) {
		if( casosCOVID14dias < 0) {
			throw new COVIDException("Error: Los casos no pueden ser negativos");
		}
		this.casosCOVID14dias = casosCOVID14dias;
	}
	public int incidenciaAcumulada() {
		int casos = 0;
		casos = (this.casosCOVID14dias * 100000) / this.poblacion;
		return casos;
	}
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof DistritoSanitario) {
			DistritoSanitario other = (DistritoSanitario) o;
			ok = this.distrito.equalsIgnoreCase(other.distrito);
		}
		return ok;
	}
	public int hashCode() {
		return this.getDistrito().toUpperCase().hashCode();
	}
	public int compareTO(DistritoSanitario other) {
		int res = this.distrito.compareToIgnoreCase(other.distrito);
		return res;
	}
	public String toString() {
		return ( "Distrito(" + this.distrito + "," + this.casosCOVID14dias + ")");
	}
	
}
