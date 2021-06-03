package contenedores;

import recursos.clsNodoPuzzle;

public class clsListaNodoPuzzle extends clsLista1DLinkedL{

	public boolean iguales(Object elementoL, Object elemento) {
		clsNodoPuzzle A=(clsNodoPuzzle)elementoL;
		clsNodoPuzzle B=(clsNodoPuzzle)elemento;
		return A.equals(B);
	}

}
