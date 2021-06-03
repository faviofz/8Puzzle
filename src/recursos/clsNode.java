package recursos;

public class clsNode {
	private Object nodeInfo;
	private clsNode nextNode;
	
	public clsNode(Object nodeInfo){
		this(nodeInfo,null);
	} 
	
	public clsNode(Object nodeInfo, clsNode nextNode){
		this.nodeInfo=nodeInfo;
		this.nextNode=nextNode; 
	}
	public void setNodeInfo(Object nodeInfo){
		this.nodeInfo=nodeInfo; 
	}
	
	public void setNextNode(clsNode nextNode){
		this.nextNode=nextNode; 
	}
	
	public Object getNodeInfo(){
		return this.nodeInfo; 
	}
	public clsNode getNextNode(){
		return this.nextNode; 
	}
	
	
}
