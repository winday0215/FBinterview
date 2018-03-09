import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
求两个排好序的array的intersection，要求保持顺序*/
class Solution {

  public static List<Integer> findIntersection(int[] l1, int[] l2) {
    List<Integer> res = new ArrayList<>();
    if (l1 == null || l1.length == 0|| l2 == null || l2.length == 0) {
      return res;
    }
    
    int n = l1.length;
    int m = l2.length;
    
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (l1[i] < l2[j]) {
        i++;
      } else {
        if (l1[i] == l2[j]) {
          res.add(l1[i]);
          i++;
        }
        j++;
      }
    }
    return res;
  }
          
      
      
  public static void main(String[] args) {
    int[] a = {1,2,2,2,3,4,7,8,9};
    int[] b = {2,2,7,9};
    
    
    List<Integer> ans = findIntersection(a, b);
    for (int x : ans) {
      System.out.print(x + ",");
    }
      
  }
}

