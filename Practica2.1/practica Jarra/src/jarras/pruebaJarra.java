package jarras;

public class pruebaJarra {

	public static void main(String[] args) {
		Jarra j1 = new Jarra(7);
		Jarra j2 = new Jarra(20);
		
		
		j1.llena();
		System.out.println(j1);
		
		j2.llenaDesde(j1);
		j1.llena();
		System.out.println(j2);
		System.out.println(j1);

	}

}
