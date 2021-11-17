package easy;

import java.util.TreeMap;
import java.util.TreeSet;

public class Trees {

    static class Node{
        int value;
        Node left, right;
        Node(int value){
            this.value=value;
            left=right=null;
        }
    }

    public Node addNode(Node node, int value){
        if(node==null) return new Node(value);
        if(value< node.value){
            node.left=addNode(node.left,value);
        }else if(value> node.value){
            node.right=addNode(node.right,value);
        }
        return node;
    }

    public void inorderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.left);
            System.out.println(node.value);
            inorderTraversal(node.right);
        }
    }
    public void preorderTraversal(Node node){
        if(node!=null){
            System.out.println(node.value);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
    public void postOrderTraversal(Node node){
        if(node!=null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.value);
        }
    }
    
    public void findNode(Node node, int target) {
        if(node != null) {
            if(node.value < target)
                findNode(node.right, target);
            else if(node.value > target)
                findNode(node.left, target);
            else if(node.value == target) 
                System.out.println("Found");
        }
        else
            System.out.println("Not Found");
    }
    
    public int findOtherNode(Node node, int value) {
        while(node != null) {
            if(node.value == value) return node.value;
            node = (value < node.value) ? node.left : node.right;    
        }
        return 0;
    }
    
    public Node deleteOneChildNode(Node node, int target) {
        if(node!=null) {
            if(node.value == target) {
                if(node.left == null && node.right != null) {
                    node = node.right;
                    node.right = null;
                }
                else if(node.left != null && node.right == null) {
                    node = node.left;
                    node.left = null;
                }
                else if(node.left == null && node.right == null)
                    return null;
            }
            if(node.value > target)
                node.left = deleteOneChildNode(node.left, target);
            if(node.value < target)
                node.right = deleteOneChildNode(node.right, target);
        }
        return node;
    }

    public static void main(String[] args) {
        Trees tree=new Trees();
        Node node = new Node(1);
        /*tree.addNode(node,13);
        tree.addNode(node,5);
        tree.addNode(node,4);
        tree.addNode(node,2);*/
        tree.addNode(node,7);
        tree.addNode(node,3);
        tree.addNode(node,4);
        tree.addNode(node,3);
        tree.findOtherNode(node, 3);
     
      //  tree.preorderTraversal(node);
     //   tree.postOrderTraversal(node);
       // tree.levelOrderTraversal(node);
        //1,2,2,3,4,4,3

    }
}