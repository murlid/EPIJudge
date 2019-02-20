package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

/*
  Consider a Binary Tree in which each node contains a binary digit. A root to leaf path can be associated with a binary number,
  The MSB is at the root.
  
  Design an alo, to compute the sum of the binary numbers represented by the root to leaf paths

 The insight here is to recognize that paths share nodes and that it is not necessary to repeat the computations across the
 shared nodes. To compute the integer for the path from the root to any node, we take the integer for the root's parent , double it 
 and add the bit at that node.

*/
public class SumRootToLeaf {
  @EpiTest(testDataFile = "sum_root_to_leaf.tsv")

  public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {

    return sumRootToLeafHelper(tree, 0);
  }

  private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree,
                                         int partialPathSum) {
    if (tree == null) {
      return 0;
    }

    partialPathSum = partialPathSum * 2 + tree.data;
    if (tree.left == null && tree.right == null) { // Leaf.
      return partialPathSum;
    }
    // Non-leaf.
    return sumRootToLeafHelper(tree.left, partialPathSum) +
        sumRootToLeafHelper(tree.right, partialPathSum);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SumRootToLeaf.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
