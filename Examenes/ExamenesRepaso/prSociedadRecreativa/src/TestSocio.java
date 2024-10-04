import sociedad.Socio;
import java.util.*;
public class TestSocio {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("senderismo");
		set.add("escalada");
		Set<String> set2 = new HashSet<>();

		Socio s1 = new Socio("Layton Kor" , set , 24);
		Socio s2 = new Socio("Layton kor", set2, 24);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		if(s1.equals(s2)) {
			System.out.println("Son el mismo socio");
		}else {
			System.out.println("Son socios distintos");
		}
	}

}
