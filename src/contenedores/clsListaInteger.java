package contenedores;

public class clsListaInteger extends clsLista1DLinkedL{

	@Override
	public boolean iguales(Object elementoL, Object elemento) {
		Integer x=(Integer) elementoL;
		Integer y=(Integer) elemento;
		return	x.intValue()==y.intValue();
	}

}
