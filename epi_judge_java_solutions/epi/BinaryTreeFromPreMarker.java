/*
  Build a BinaryTree from PreOrder Data that is "marked in the sense the preOrder sequence says explicty where a 
  left or right child is empty. Use this info to help build yor Binary Tree
  
Intuition here:  PreOrder is root, left tree sequence, then right. tree subsquence The root's left sequence appears before all the root's 
right subtree But how do we know where the left ends? If we solve the problem recursively,we can assume that the routine 
correctly computes the left subTree, which will also tell us there the right subTree starts and that is where the markers
come handly....

Time complexity is O(n) where n is the number of nodes


*/

public class BinaryTreeFromPreMarker {

 private int rootIndex =0;
 
 public BinaryTreeNode buildFromPreOrder( List<Integer> preOrderSeq) {
 
  return buildFromPreOrderHelper(List<Integer> preOrder);  
 }

// note helper updates rootIndex, so the order of the left/right recursive call is important
 public BinaryTreeNode buildFromPreOrderHelper(List<Integer> preOrder) {
    int rootKey = preOrder.get(rootIndex++);
    if ( rootKey == null) { // means left seq ends here
           return null;
     BinaryTreeNode left = buildFromPreOrderHelper(preOrder);
     BinaryTreeNode right= buildFromPreOrderHelper(preOrder);
     return new BinaryTreeNode(rootKey,left,right);
     
    }
    
 }

}
