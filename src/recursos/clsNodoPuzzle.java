package recursos;

import contenedores.*;

public class clsNodoPuzzle{
	clsEstado estado;
	clsNodoPuzzle padre;
	clsListaNodoPuzzle listaHijos;

	public clsNodoPuzzle(clsEstado estado){
		this(estado,null,new clsListaNodoPuzzle());
	}
	
	public clsNodoPuzzle(clsEstado estado, clsNodoPuzzle padre){
		this(estado,padre,new clsListaNodoPuzzle());
	}
	
	public clsNodoPuzzle(clsEstado estado, clsNodoPuzzle padre, clsListaNodoPuzzle hijos){
		this.estado=estado;
		this.padre=padre;
		this.listaHijos=hijos;
	}
	
	public void setEstado(clsEstado estado){
		this.estado=estado;
	}
	
	public clsEstado getEstado(){
		return this.estado;
	}
	
	public void setPadre(clsNodoPuzzle padre){
		this.padre=padre;
	}
	
	public clsNodoPuzzle getPadre(){
		return this.padre;
	}
	
	public void setListaHijos(clsListaNodoPuzzle listaHijos){
		this.listaHijos=listaHijos;
	}
	
	public clsListaNodoPuzzle getListaHijos(){
		return this.listaHijos;
	}
	
	public void setHijo(clsNodoPuzzle hijo){
		this.listaHijos.insertar(hijo, 0);
	}
	
	public clsNodoPuzzle getHijo(int pos){
		return (clsNodoPuzzle)this.listaHijos.devolver(pos);
	}
	
	public void generarSucesores(){
		int fila, col;
		clsEstado nuevo;
		this.listaHijos=new clsListaNodoPuzzle();
		fila=this.estado.buscarFila("0");
		col=this.estado.buscarColumna("0");
		if(fila!=-1 && col!=-1){
			if(fila==0){
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverAbajo(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
			}
			else if(fila==this.estado.getNroFilas()-1){
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverArriba(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
			}
			else{
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverArriba(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverAbajo(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
			}
			if(col==0){
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverDerecha(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
			}
			else if(col==this.estado.getNroColumnas()-1){
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverIzquierda(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
			}
			else{
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverDerecha(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
				nuevo=new clsEstado(this.estado.getNroColumnas());
				nuevo.copiarEstado(this.estado);
				nuevo.moverIzquierda(fila, col);
				this.listaHijos.insertar(new clsNodoPuzzle(nuevo,this),0);
			}
		}
	}
	
	public boolean equals(clsNodoPuzzle nodo){
		return this.estado.equals(nodo.getEstado());
	}
}
