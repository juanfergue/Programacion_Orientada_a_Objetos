package jarras;

public class Jarra {
	private final int capacidad;
	private int contenido;
	
	public Jarra(int cap) {
		capacidad = cap;
		contenido = 0;
		if(cap <=0) {
			throw new RuntimeException ("La capacidad no puede ser neativa");
		}
	}
	public int capacidad() {
		return capacidad;
	}
	public int contenido() {
		return contenido;
	}
	
	public String toString () {
		return "J( cap: " + capacidad() + " , cont: " + contenido() + ")";
	}
	public void llena() {
		contenido = capacidad;
	}
	public void vacio() {
		contenido = 0;
	}
	public void llenaDesde(Jarra otra) {
		int content;
		
		content = this.capacidad - this.contenido;
		if(content >= otra.contenido) {
			this.contenido = this.contenido + otra.contenido;
			otra.contenido = 0;
		}else {
			this.contenido = this.capacidad;
			otra.contenido = otra.contenido - content;
		}
	}
}
