package day7;

import org.junit.Test;

public class OddNodes {

	
	public class Node{
        int value;
        Node next;
        Node(int key){
            this.value = key;
            next = null;
        }
        
        Node(){
            next = null;
        }
    }
    public Node addNode(int key) {
        return new Node(key);
    }
    public void printAllNodes(Node node) {
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
    
    public Node findOddNodes(Node node) {
    	Node oddNodes= new Node();
    	Node currentNode=oddNodes;
    	
    	
    	return node;
    }
    
    @Test
    public void tc01() {
    	
    	Node input = addNode(1);
    	input.next= addNode(2);
    	input.next.next= addNode(3);
    	input.next.next.next= addNode(4);
    	Node out=findOddNodes(input);
    	printAllNodes(out);
    }
   
}
