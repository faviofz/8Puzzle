package contenedores;

import recursos.clsNodoPuzzle;

public class clsNodoPuzzleSet extends clsAbsSet{

	@Override
	public boolean iguales(Object objA, Object objB) {
		clsNodoPuzzle A=(clsNodoPuzzle)objA;
		clsNodoPuzzle B=(clsNodoPuzzle)objB;
		return A.equals(B);
	}

}
