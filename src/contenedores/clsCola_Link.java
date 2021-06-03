package contenedores;

import recursos.*;

public class clsCola_Link implements OperacionesCL1{
	clsNode frenteC, finalC;
	
	public clsCola_Link(){
		limpiar();
	}
	
	public void meter(Object elemento){
		if(!estaVacia()){
			this.finalC.setNextNode(new clsNode(elemento));
			this.finalC=this.finalC.getNextNode();
		}
		else
			this.frenteC=this.finalC=new clsNode(elemento);
	}
	
	public Object sacar(){
		Object elemento=null;
		if(!estaVacia()){
			elemento=this.frenteC.getNodeInfo();
			this.frenteC=this.frenteC.getNextNode();
			if(estaVacia())
				this.finalC=null;
		}
		else
			System.out.println("Error al sacar, Cola vacía");
		return elemento;
	}
	
	public void limpiar(){
		this.frenteC=this.finalC=null;
	}
	
	public boolean estaVacia(){
		return (this.frenteC==null);
	}
}
