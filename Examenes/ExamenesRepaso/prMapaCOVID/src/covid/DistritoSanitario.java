package covid;

public class DistritoSanitario implements Comparable<DistritoSanitario>{
	private String distrito;
	private int poblacion;
	private int casosCOVID14dias;
	
	public DistritoSanitario(String d, int p, int c14) {
		if(p <= 0) {
			throw new COVIDException("ERROR valor de poblacion no es válido");
		}
		if(c14 < 0) {
			throw new COVIDException("ERROR valor de casos COVID no es válido");
		}
		this.distrito = d;
		this.poblacion = p;
		this.casosCOVID14dias = c14;
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

	public void setCasosCOVID14dias(int c14) {
		if(c14 < 0) {
			throw new COVIDException("ERROR valor de casos COVID no es válido");
		}
		this.casosCOVID14dias = c14;
	}
	public int incidenciaAcumulada() {
		int res = (this.casosCOVID14dias * 100000)/this.poblacion;
		return res;
	}
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if(o instanceof DistritoSanitario) {
			DistritoSanitario other = (DistritoSanitario) o;
			ok = this.distrito.equals(other.distrito);
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return this.distrito.hashCode();
	}
	@Override
	public int compareTo(DistritoSanitario other) {
		int res = this.distrito.compareToIgnoreCase(other.distrito);
		return res;
	}
	public String toString() {
		return ("Distrito" + "(" + this.distrito + "," + this.casosCOVID14dias + ")");
	}
}
