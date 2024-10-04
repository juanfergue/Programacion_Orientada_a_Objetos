package sociedad;

import java.util.Set;
import java.util.HashSet;


public class TestSocio {

	public static void main(String[] args) {
		Set<String> intereses = new HashSet<>();
		intereses.add("senderismo");
		intereses.add("escalada");

		Socio s1 = new Socio("Layton Kor", intereses , 24);
		Socio s2 = new Socio("Layton Kor", new HashSet<String>() , 24);
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		boolean ok = s1.equals(s2);
		if(ok) {
			System.out.println("Son el mismo socio");
		}else {
			System.out.println("No son el mismo socio");
		}
	}

}
