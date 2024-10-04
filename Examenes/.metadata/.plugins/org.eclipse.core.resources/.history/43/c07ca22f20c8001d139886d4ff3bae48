package universidad;

public class CentroSubvencionado extends Centro{
	private double umbralNota;
	
	public CentroSubvencionado(double umbral) {
		super();
		umbralNota = umbral;
	}
	public void addEstudiante(String i, int c, int cr, double n, boolean t) {
		if(n > umbralNota) {
			EstudianteConBeca e1 = new EstudianteConBeca(i, c, cr, n, t, umbralNota);
			addEstudiante(e1);
		}else {
			Estudiante e2 = new Estudiante(i, c, cr, n, t);
			addEstudiante(e2);
		}
	}
	public String toString() {
		return ("Nota mínima para beca: " + this.umbralNota + "\n" + super.toString());
	}
}
