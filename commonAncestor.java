import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
common ancestor of deepest leaves*/
class Solution {

  static class TreeNode {
    int label;
    TreeNode left, right;
    public TreeNode(int label) {
      this.label = label;
    }
  }
    
  static class Result {
    int depth;
    TreeNode node;
    public Result(int d, TreeNode n) {
      depth = d;
      node = n;
    }
  }
  
  
  public static Result commonAncestorOfDeepestLeaves(TreeNode root) {
    if (root == null) {
       return new Result(0, null);
    }
   
    Result left = commonAncestorOfDeepestLeaves(root.left);
    Result right = commonAncestorOfDeepestLeaves(root.right);
   
    if (left.depth == right.depth) {
       return new Result(left.depth + 1, root);
    }
   
    if (left.depth < right.depth) {
     return new Result(right.depth + 1, right.node);
    }
     
    return new Result(left.depth + 1, left.node);
  }
      
      
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(6);
    
    System.out.println(commonAncestorOfDeepestLeaves(root).node.label);
  }
}

