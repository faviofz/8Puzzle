package contenedores;

public class clsEstadoSet extends clsAbsSet{

	public boolean iguales(Object objA, Object objB) {
		clsEstado A=(clsEstado)objA;
		clsEstado B=(clsEstado)objB;
		
		boolean b=true;
		if((A.getNroFilas()==B.getNroFilas()) && (A.getNroColumnas()==B.getNroColumnas())){
			for(int i=0;i<A.getNroFilas();i++){
				for(int j=0;j<A.getNroColumnas();j++){
					if(A.devolver(i,j)!=B.devolver(i,j)){
						b=false;
					}
				}
			}
		}
		else
			b=false;
		return b;
	}
	
	
}
