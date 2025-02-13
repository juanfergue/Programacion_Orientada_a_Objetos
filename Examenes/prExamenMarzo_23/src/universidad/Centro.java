package universidad;
import java.util.ArrayList;

public class Centro {
	private ArrayList<Estudiante> matriculados;
	
	public Centro() {
		matriculados = new ArrayList<>();
	}
	public void addEstudiante(String i, int c, int cr, double n, boolean t) {
		Estudiante e = new Estudiante(i, c, cr, n, t);
		addEstudiante(e);
		
	}
	protected void addEstudiante(Estudiante e) {
		int i = 0;
		boolean encontrado = false;
		while(i < matriculados.size()) {
			if( matriculados.get(i).getId().equalsIgnoreCase(e.getId()) == true) {
				encontrado = true;
			}
			i++;
		}
		if(encontrado == true) {
			matriculados.set(i, e);
		}else {
			matriculados.add(e);
		}
	}
	public ArrayList<Estudiante> getListaCurso(int c){
		int i = 0;
		ArrayList<Estudiante> e1 = new ArrayList<>();
		while(i < matriculados.size()) {
			if(matriculados.get(i).getCurso() == c){
				e1.add(matriculados.get(i));
			}
			i++;
		} 
		return e1;
	}
	@Override
	public String toString() {
		return "Centro [matriculados=" + matriculados + "]";
	}
}
