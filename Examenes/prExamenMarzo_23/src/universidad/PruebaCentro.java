package universidad;

public class PruebaCentro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Centro c = new Centro();

		//c.addEstudiante("785-36-6518", 1, 24, 6.6, false); // ERROR: número de créditos no alcanza el mínimo.
		c.addEstudiante("388-77-5692", 4, 70, 6.7, true);
		c.addEstudiante("718-15-9116", 2, 63, 6.5, true);
		c.addEstudiante("820-94-1888", 3, 28, 5.5, true);
		c.addEstudiante("366-35-7779", 1, 66, 8.9, false);
		c.addEstudiante("355-76-3086", 2, 50, 6.0, false);
		c.addEstudiante("591-96-2640", 3, 52, 9.9, true);
		c.addEstudiante("626-40-6133", 1, 66, 5.1, false);
		//c.addEstudiante("463-61-7332", 5, 52, 7.1, false); // ERROR 463-61-7332 :curso incorrecto.
		c.addEstudiante("466-12-6029", 1, 70, 7.2, true);
		c.addEstudiante("123-18-2748", 3, 53, 4.2, false);
		c.addEstudiante("608-60-9964", 2, 43, 7.5, true);
		c.addEstudiante("652-92-2849", 3, 53, 7.2, false);
		c.addEstudiante("701-73-6031", 4, 48, 9.3, false);
		c.addEstudiante("269-58-1651", 1, 60, 4.5, false);
		
		System.out.println(c);
		
		Centro cs = new CentroSubvencionado(8.5);

		cs.addEstudiante("388-77-5692", 4, 70, 6.7, true);
		cs.addEstudiante("718-15-9116", 2, 63, 6.5, true);
		cs.addEstudiante("820-94-1888", 3, 28, 5.5, true);
		cs.addEstudiante("366-35-7779", 1, 66, 8.9, false);
		cs.addEstudiante("355-76-3086", 2, 50, 6.0, false);
		cs.addEstudiante("591-96-2640", 3, 52, 9.9, true);
		cs.addEstudiante("626-40-6133", 1, 66, 5.1, false);
		cs.addEstudiante("466-12-6029", 1, 70, 7.2, true);
		cs.addEstudiante("123-18-2748", 3, 53, 4.2, false);
		cs.addEstudiante("608-60-9964", 2, 43, 7.5, true);
		cs.addEstudiante("652-92-2849", 3, 53, 7.2, false);
		cs.addEstudiante("701-73-6031", 4, 48, 9.3, false);
		cs.addEstudiante("269-58-1651", 1, 60, 4.5, false);
		
		System.out.println(cs);
	}

}
