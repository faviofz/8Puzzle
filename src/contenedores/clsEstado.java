package contenedores;

public class clsEstado extends clsMatrizArr {

	public clsEstado(int tam) {
		super(tam,tam);
		limpiaMatriz();
	}
	
	public boolean estaCompleto(){
		boolean b=true;
		for(int i=0;i<getNroFilas();i++){
			for(int j=0;j<getNroColumnas();j++){
				if(devolver(i,j)==null)
					b=false;
			}
		}
		return b;
	}
	
	public void muestraEstado(){
		
		for(int i=0;i<getNroFilas();i++){
			System.out.println("");
			for(int j=0;j<getNroColumnas();j++){
				System.out.print(this.matriz[i][j]+"\t");
			}
		}
		System.out.println("");
	}
	
	public boolean equals(clsEstado estado){
		boolean b=true;
		if((getNroFilas()==estado.getNroFilas()) && (getNroColumnas()==estado.getNroColumnas())){
			for(int i=0;i<getNroFilas();i++){
				for(int j=0;j<getNroColumnas();j++){
					if(!this.matriz[i][j].equals(estado.matriz[i][j])){
						b=false;
					}
				}
			}
		}
		else
			b=false;
		return b;
	}
	
	public boolean estaVacia(){
		boolean b=true;
		for (int i=0;i<getNroFilas();i++){
			for (int j=0;j<getNroColumnas();j++){
				if(devolver(i,j)!=null){
					b=false;
				}
			}
		}
		return b;
	}
	
	public int buscarFila(String buscado){
		int fila=-1;
		if(!estaVacia()){
			for (int i=0;i<getNroFilas();i++){
				for (int j=0;j<getNroColumnas();j++){
					if(this.matriz[i][j].equals(buscado)){
						fila=i;
					}
				}
			}
		}
		return fila;
	}
	
	public int buscarColumna(String buscado){
		int col=-1;
		if(!estaVacia()){
			for (int i=0;i<getNroFilas();i++){
				for (int j=0;j<getNroColumnas();j++){
					if(this.matriz[i][j].equals(buscado)){
						col=j;
					}
				}
			}
		}
		return col;
	}
	
	public void moverArriba(int fila, int col){
		Object num=this.matriz[fila][col];
		this.matriz[fila][col]=this.matriz[fila-1][col];
		this.matriz[fila-1][col]=num;
	}
	
	public void moverAbajo(int fila, int col){
		Object num=this.matriz[fila][col];
		this.matriz[fila][col]=this.matriz[fila+1][col];
		this.matriz[fila+1][col]=num;
	}
	
	public void moverDerecha(int fila, int col){
		Object num=this.matriz[fila][col];
		this.matriz[fila][col]=this.matriz[fila][col+1];
		this.matriz[fila][col+1]=num;
	}
	
	public void moverIzquierda(int fila, int col){
		Object num=this.matriz[fila][col];
		this.matriz[fila][col]=this.matriz[fila][col-1];
		this.matriz[fila][col-1]=num;
	}
	
	public void copiarEstado(clsEstado estado){
		for (int i=0;i<getNroFilas();i++){
			for (int j=0;j<getNroColumnas();j++){
				this.matriz[i][j]=estado.devolver(i,j);
			}
		}
	}
	
	public void generarEstadoInicial(){
		clsIntegerSet conjunto=new clsIntegerSet();
		Integer num=null;
		int tam=this.nroColumnas*this.nroFilas;
		for(int i=0;i<getNroFilas();i++){
			for(int j=0;j<getNroColumnas();j++){
				if(num==null){
					num=getRandomInt(0,tam);
					conjunto.meter(num);
				}
				else{
					while(conjunto.pertenece(num)){
						num=getRandomInt(0,tam);
					}
					conjunto.meter(num);
				}
				this.matriz[i][j]=String.valueOf(num.intValue());
			}
		}
	}
	
	private Integer getRandomInt(int min, int max){
		return Integer.valueOf((int)(Math.random()*(max-min)+min));
	}
	
}
