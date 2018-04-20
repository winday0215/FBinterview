import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static List<Integer> LISroute(int[] A) {
    int[] tails = new int[A.length];
    int len = 0;
    List<List<Integer>> routes = new ArrayList<>();
    routes.add(new ArrayList<Integer>());
    
    for (int i = 0; i < A.length; i++) {
      int index = Arrays.binarySearch(tails, 0, len, A[i]);
      if (index < 0) {
        index = - index - 1;
      }
      
      tails[index] = A[i];
      
      if (index == len) {
        len++;
        routes.add(new ArrayList<Integer>(routes.get(len - 1)));
        routes.get(len).add(A[i]);
      } else {
        List<Integer> cur = routes.get(index + 1);
        cur.set(index, A[i]);
      }
    }
    
    return routes.get(len);
  }
  
  
  public static void main(String[] args) {
    int[] A = new int[]{1,3,5,2,4};
    
    
    System.out.println(LISroute(A));
  }
}

