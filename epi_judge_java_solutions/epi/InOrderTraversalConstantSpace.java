/*
  Do an InOrderTRaversal in contant space and O(n), given that you are provided a parent pointer 
  in every node;
  
  Below solution is based on the intuition that if the curr nodes.left child = parent.left, then curr node has not been visited
  so add its data to the inOrderList. If the parent's right child == curr, it mrans the parent was already visited. so go up the 
  chain of ancestors
  
  Below soltuion is O(n) and space is constant

*/

public class InOrderTraversalConstantSpace {
private List<Integer> results = new ArrayList<Integer>();
public List<Integer> inOrderTraversal( BinaryTreeNode root) {

if ( root == null) return root;

BinaryTreeNode curr = root;
BinaryTreeNode prev=null;
BinaryTreeNode next=null;

 while (curr != null) {
 // case 1 
 if ( curr.prev == curr.parent) {
   if ( curr.left != null) {
     next = curr.left;
   } 
   else {
    results.add(curr.data);
    next = curr.right != null ? curr.right: curr.parent;
     }
 
 } // 
 else // Case 2 means going up from left subTree
 if ( curr.left == prev) {
   results.add(curr.data);
   
   next = curr.right != null ? curr.right: curr.parent;
 
 } //
 
 else  { //  case 3  curr.right == prev i.e both children done, go up ancestor path 
   next = curr.parent;
 }
 
 prev = curr;
 curr = next;
 } // while 


}
