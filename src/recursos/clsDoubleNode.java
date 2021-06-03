package recursos;

public class clsDoubleNode {

	private Object nodeInfo;
	private clsDoubleNode prevNode, nextNode;
	
	public clsDoubleNode(Object nodeInfo){
		this(nodeInfo,null,null);} 
	
	public clsDoubleNode(Object nodeInfo, clsDoubleNode nextNode){
		this(nodeInfo,null,nextNode);} 
	
	public clsDoubleNode(Object nodeInfo, clsDoubleNode prevNode, clsDoubleNode nextNode){
		this.nodeInfo=nodeInfo;
		this.prevNode=prevNode; this.nextNode=nextNode; 
	}
	
	public void setPrevNode(clsDoubleNode prevNode){
		this.prevNode=prevNode;
	}
	
	public clsDoubleNode getPrevNode(){
		return this.prevNode; 
	}
	
	public void setNextNode(clsDoubleNode nextNode){
		this.nextNode=nextNode;
	}
	
	public clsDoubleNode getNextNode(){
		return this.nextNode; 
	}
	public void setNodeInfo(Object nodeInfo){
		this.nodeInfo=nodeInfo; 
	}
	public Object getNodeInfo(){
		return this.nodeInfo;
	}

}
