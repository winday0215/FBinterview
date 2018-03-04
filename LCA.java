import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
补一个递归的多叉树的做法，建立一个returnType，来记录lca和depth
如果root的子树的returnType中有两个相等的最大值，那么返回root, depth+1
如果root的子树的return Type中只有一个最大值，返回该最大值对应的lca, depth+1/*/
class Solution {
  static class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode (int val) {
      this.val = val;
    }
  }
  
  static class ResultType {
    TreeNode LCA;
    int depth;
    public ResultType(TreeNode LCA, int depth) {
      this.LCA = LCA;
      this.depth = depth;
    }
  }
  
  private static ResultType LCA (TreeNode root) {
    if (root == null) {
      return new ResultType(null, 0);
    }
    
    ResultType left = LCA(root.left);
    ResultType right = LCA(root.right);
    
    if (left.depth == right.depth) {
      return new ResultType(root, left.depth + 1);
    } else if (left.depth > right.depth) {
      return new ResultType(root.left, left.depth + 1);
    } else {
      return new ResultType(root.right, right.depth + 1);
    }
  }
    
  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(7);
    
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(8);
    root.left.right.right = new TreeNode(6);
    
    ResultType ans = LCA(root);
    System.out.println(ans.LCA.val);
    System.out.println(ans.depth);
  }
}

