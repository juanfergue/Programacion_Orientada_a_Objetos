package universidad;

public class PruebaEstudiante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Estudiante e1 = new Estudiante("785-36-6518", 1, 24, 6.6, false);
		//System.out.println(e1.toString());
		Estudiante e2 = new Estudiante("718-15-9116", 2, 24, 6.5, true);
		Estudiante e3 = new Estudiante("366-35-7779", 1, 66, 8.9, false);
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		EstudianteConBeca e4 = new EstudianteConBeca("366-35-7779", 1, 66, 8.9,  false, 8);
		System.out.println(e4.toString());
		
		
	}

}
