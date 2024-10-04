package hospital;

import java.util.Objects;

public class Habitacion {
	private int planta;
	private int numero;
	
	public Habitacion(int p, int n) {
		this.numero = n;
		this.planta = p;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Habitacion [planta=" + planta + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, planta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		return numero == other.numero && planta == other.planta;
	}
	public int compareTo(Habitacion other) {
		int res = Integer.compare(numero, other.numero);
		if(res == 0) {
			res = Integer.compare(planta, other.planta);
		}
		return res;
	}
	
}
