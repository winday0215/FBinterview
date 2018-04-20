import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  static class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }
  
  static TreeNode head = null, prev = null;
  private static void BSTToDLL(TreeNode root) {
    if (root == null) {
      return;
    }
    
    BSTToDLL(root.left); //convert left subtree
    
    if (prev == null) { //convert current node
      head = root;
    } else {
      prev.right = root;
      root.left = prev;
    }
    
    prev = root;
    BSTToDLL(root.right); //convert right subtree
  }
    
    
  
  private static void printTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      System.out.print(cur.val + " ");
      
      if (cur.left != null) {
        q.offer(cur.left);
      }
      
      if (cur.right != null) {
        q.offer(cur.right);
      }
    }
    
    System.out.print("\n");
  }
    
  private static void printList(TreeNode node)
    {
        while (node != null) 
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
    
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    
    printTree(root);
    
    BSTToDLL(root);
    
    printList(head);
  }
}

