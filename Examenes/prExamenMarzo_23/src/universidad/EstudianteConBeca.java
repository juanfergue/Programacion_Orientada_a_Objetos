package universidad;

public class EstudianteConBeca extends Estudiante{
	private double umbralNota;
	
	public EstudianteConBeca(String i, int c, int cr, double n , boolean t, double umbral) {
		super(i, c, cr, n, t);
		umbralNota = umbral;
	}
	private double subvencion() {
		double constante = (10-umbralNota)/3;
		double bonificacion = 0;
		double nota = super.getNotaMedia();
		if((umbralNota) < nota && nota < (umbralNota + constante)) {
			 bonificacion = 75;
		}else if((umbralNota+ constante) < nota && nota < (umbralNota + constante*2)) {
			bonificacion = 125;
		}else if((umbralNota+ constante*2) < nota && nota < (umbralNota + constante*3)) {
			bonificacion = 150;
		}
		return bonificacion;
	}
	protected double getMatricula() {
		return super.getMatricula()- subvencion();
	}
	
	public String toString() {
		return ("{" + super.getId() + "(media: " + super.getNotaMedia() + ", umbral: " + this.umbralNota +
				"); " + super.getCurso() + "; " + super.getCreditos() + " cr�ditos; " + getMatricula() + " euros)");
	}
	
}
