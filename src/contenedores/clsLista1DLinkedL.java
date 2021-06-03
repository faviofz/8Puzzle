package contenedores;
import recursos.*;

public abstract class clsLista1DLinkedL extends clsLista0DLinkedL implements OperacionesCL3{
	public void insertar(Object elemento, int posicion){
		clsDoubleNode node;
		if (posicion>tamanio() || posicion<0){
			System.out.println("Error insertar. Posicion inexistente ");
		}else{
			if (posicion==0){ 
				if (!estaVacia()){
					this.frenteL=new clsDoubleNode(elemento, null, this.frenteL);
					this.frenteL.getNextNode().setPrevNode(this.frenteL);
				}else{
					this.frenteL=this.finalL=new clsDoubleNode(elemento);					
				}
			}else{
				if (posicion==tamanio()){ 
					this.finalL = new clsDoubleNode(elemento, this.finalL, null);
					this.finalL.getPrevNode().setNextNode(this.finalL);
				}else{
					clsDoubleNode prev, next;
					prev=this.frenteL;
					next=this.frenteL.getNextNode();
					for (int counter=1; counter<posicion;counter++){
						prev=prev.getNextNode(); next=next.getNextNode();						
					}
					
					node = new clsDoubleNode(elemento,prev,next);
					prev.setNextNode(node); 
					next.setPrevNode(node);					
				}
			}			
			this.ultimo++;
		}		
	}
	
	public void reemplazar(Object elemento, int posicion){		
		if (estaVacia()){
			System.out.println("Error reemplazar. Lista vacia...");
		} else {
			if (posicion>=tamanio() || posicion<0){
				System.out.println("Error reemplazar. La posicion no existe..");
			}else{
				if (posicion==0){
					this.frenteL.setNodeInfo(elemento);
				}else{
					if (posicion==tamanio()-1){
						this.finalL.setNodeInfo(elemento);
					}else {
						clsDoubleNode temp;
						temp=this.frenteL;
						
						for (int counter=0; counter<posicion;counter++){						
							temp=temp.getNextNode();		
						}				
						
						temp.setNodeInfo(elemento);
					}
				}				
			}						
		}		
	}
	
	public abstract boolean iguales(Object elementoL, Object elemento);
	
	public int buscar(Object elemento){		
		int posicion=-1; int contador=0;
		Object unElemento;
		clsDoubleNode temp;
		
		temp=this.frenteL;
		while (temp!=null && posicion==-1){
			unElemento=temp.getNodeInfo();
			if (iguales(unElemento,elemento)){
				posicion=contador;
			}else{
				temp=temp.getNextNode();
				contador++;
			}
		}				
		return posicion;
	}

}
