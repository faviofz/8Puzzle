package contenedores;

import recursos.*;

public class clsPila_Link implements OperacionesCL1{
	clsNode pila;
	
	public clsPila_Link(){
		limpiar();
	}

	public void meter(Object elemento){
		this.pila=new clsNode(elemento,this.pila);
	}

	public Object sacar(){
		Object elemento=null;
		if(!estaVacia()){
			elemento=this.pila.getNodeInfo();
			this.pila=this.pila.getNextNode();
		}
		else
			System.out.println("Error al sacar, Pila vacía");
		return elemento;
	}

	public void limpiar(){
		this.pila=null;
	}

	public boolean estaVacia(){
		return (this.pila==null);
	}
	
	public void muestra(){
	
		if(!estaVacia()){
			clsNode aux=null;
			aux=this.pila;
			while(aux!=null){
				System.out.println("Elemento: "+ aux.getNodeInfo().toString());
				aux=aux.getNextNode();
			}
		}
		else
			System.out.println("Error al mostrar, Pila vacía");
		
	}
}
