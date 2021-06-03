package contenedores;
import recursos.*;

public abstract class clsAbsSet implements OperacionesConj{
	protected clsNode conjunto;
	protected int cardinal;
	
	public clsAbsSet(){
		vaciar();		
	}
	
	public boolean estaVacio(){return (this.conjunto==null);}
	
	public void vaciar(){
		this.conjunto=null;
		this.cardinal=0;
	}

	public int getCardinal(){return this.cardinal;}
	
	public abstract boolean iguales(Object objA, Object objB);
	
	public boolean pertenece(Object objElemento){
		clsNode temp; boolean flag;
		boolean response=false;
		if (!estaVacio()){
			temp=this.conjunto;
			flag=false;
			while (temp!=null && !flag){
				if (!iguales(objElemento,temp.getNodeInfo())){
					temp=temp.getNextNode();
				}else{
					flag=true;
				}
			}
			if (flag){
				response=true;
			}	
		}		
		return response;
	}
	

	public void meter(Object objElemento){
		if (!pertenece(objElemento)){
			this.conjunto=new clsNode(objElemento, this.conjunto);
			this.cardinal++;
		}else{
			System.out.println("Error meter. El elemento ya esta en conjunto");
		}		
	}
	
		
	public void sacar(Object objElemento){
		clsNode temp;
		boolean flag;
		
		if (!estaVacio()){
			if (pertenece(objElemento)){
				temp=this.conjunto;
				if (iguales(objElemento,temp.getNodeInfo())){
					this.conjunto=this.conjunto.getNextNode();
				}else{
					flag=false;
					while (temp.getNextNode()!=null && !flag){
						if (!iguales(objElemento,temp.getNextNode().getNodeInfo())){
							temp=temp.getNextNode();
						}else{
							flag=true;
						}
					}
					temp.setNextNode(temp.getNextNode().getNextNode());					
				}
				this.cardinal--;
				
				if (estaVacio()){
					vaciar();
				}
				
			}else{
				System.out.println("Error sacar. El elemento no esta.");
			}
		}else{
			System.out.println("Error sacar. Conjunto vacio");			
		}		
	}
	
	private Object sacarPrimero(){
		Object objElemento=null;
		if (!estaVacio()){
			objElemento=this.conjunto.getNodeInfo();
			this.conjunto=this.conjunto.getNextNode();
			
			if (estaVacio()){
				vaciar();
			}
		}else{
			System.out.println("Error sacar. Conjunto vacio");			
		}
		return objElemento;		
	}
	
	
	public void union(clsAbsSet conjA, clsAbsSet conjB){
		Object objElemento;
		
		if (!conjA.estaVacio() || !conjB.estaVacio()){
			vaciar();
			while (!conjA.estaVacio()){
				objElemento=conjA.sacarPrimero();		
				meter(objElemento);				
			}	
			System.out.println("ya esta conjA");
			
			while (!conjB.estaVacio()){
				objElemento=conjB.sacarPrimero();
				if (!pertenece(objElemento)){
					meter(objElemento);	
				}				
			}			
		}else{
			System.out.println("Error union. Conjuntos vacios");
		}		
	}

}

	
	

