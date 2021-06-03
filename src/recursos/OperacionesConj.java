package recursos;

import contenedores.clsAbsSet;

public interface OperacionesConj {
	
	public boolean estaVacio();
	public void vaciar();
	public int getCardinal();
	public boolean pertenece(Object objElemento);
	public void meter(Object objElemento);
	public void sacar(Object objElemento);
	public void union(clsAbsSet conjA, clsAbsSet conjB);
	

}
