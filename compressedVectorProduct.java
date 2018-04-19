import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static int product(int[][] A, int[][] B) {
    int rowA = 0, rowB = 0; //which line in a AND B
    int offsetA = 0, offsetB = 0; // how many elements counted
    
    int sum = 0;
    while (rowA < A.length && rowB < B.length) {
      sum += A[rowA][1] * B[rowB][1];
      offsetA++;
      offsetB++;
      if (offsetA == A[rowA][0]) {
        offsetA = 0;
        rowA++;
      }
      
      if (offsetB == B[rowB][0]) {
        offsetB = 0;
        rowB++;
      }
    }
    
    return sum;
  }
  
  
  public static void main(String[] args) {
    int[][] A = new int[][]{{3, 2}, {1, 4}, {2, 5}};
    int[][] B = new int[][]{{2, 1}, {2, 3}, {1, 2}, {1, 6}};
    
    
    System.out.println(product(A, B));
  }
}

