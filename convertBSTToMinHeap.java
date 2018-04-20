//first convert bst to sorted linked list, then convert LL to MinHeap by preorder traversal


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
    
  private static TreeNode BSTToMinHeap(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode head = BSTToLL(root);
    printTree(head);
    root = LLToMinHeap(head);
    return root;
  }
  
  
  private static TreeNode BSTToLL(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    TreeNode right = BSTToLL(root.right); //convert right subtree at first
  
    TreeNode left = BSTToLL(root.left); //convert left subtree to LL
    
    TreeNode head = root; 
    head.right = right;

    head.left = null;
    
    if (left != null) {
      TreeNode p = left;
      while (p.right != null) {
        p = p.right;
      }
      p.right = head;
      head = left;
    }
    //System.out.println("head is " + head.val);
    return head;
  }
  
  private static TreeNode LLToMinHeap(TreeNode head) {
    if (head == null) {
      return null;
    }
    
    //set root to head and head move to next 
    TreeNode root = head;
    head = head.right;
    root.right = null;
    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    //run until head is null
    while(head != null) {
      TreeNode parent = q.poll();
      //System.out.println(parent.val);
      //set next node in LL as left child of parent
      TreeNode left = head;
      head = head.right;
      left.right = null;
      q.offer(left);
      parent.left = left;
       
      //set next node in LL as right child of parent
      if (head != null) {
        TreeNode right = head;
        head = head.right;
        right.right = null;
        
        q.offer(right);
        parent.right = right;
      }
    }
    return root;
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
    
    
  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    
    printTree(root);
    
    root = BSTToMinHeap(root);
    
    printTree(root);
  }
}

