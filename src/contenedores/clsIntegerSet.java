package contenedores;
import recursos.clsNode;
public class clsIntegerSet extends clsAbsSet{
	
	public boolean iguales(Object objA, Object objB){
		int valueA, valueB;
		boolean response=false;
		
		valueA=(int)objA;
		valueB=(int)objB;
		if (valueA==valueB){
			response=true;
		}
		return response;
	}
	
	
	public void muestra(){
		clsNode temp;	
		temp=this.conjunto;
		while (temp!=null){
			System.out.println("elemento " + ((int)temp.getNodeInfo()));
			temp=temp.getNextNode();			
		}
	}

}


