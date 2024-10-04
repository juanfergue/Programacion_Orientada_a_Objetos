package parrillatv;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;


public class ProgramasCortos implements SugerenciasTV{
	private int duMaxima;
	
	public ProgramasCortos(int dm) {
		this.duMaxima = dm;
	}
	@Override
	public SortedSet<ProgramaTV> sugerencias(Collection<ProgramaTV> progs) {
		SortedSet<ProgramaTV> validos = new TreeSet<>();
		for(ProgramaTV programas : progs) {
			if(programas.getDuracion() <= this.duMaxima) {
				validos.add(programas);
			}
		}
		return validos;
	}

}
