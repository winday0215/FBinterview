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
  enum Direction {
    INCR,
    DESC,
    CONST
  }
  public static boolean monotonic(int[] A) {
    if (A == null || A.length < 2) {
      return true;
    }
    
    Direction d;
    int prev = A[0];
    if (A[1] > prev) {
      d = Direction.INCR;
    } else if (A[1] < prev) {
      d = Direction.DESC;
    } else {
      d = Direction.CONST;
    }
    
    prev = A[1];
    for (int i = 2; i < A.length; i++) {
      if (d == Direction.CONST) {
        if (A[i] > prev) {
          d = Direction.INCR;
        } else if (A[i] < prev) {
          d = Direction.DESC;
        }
        prev = A[i];
      } else if ((d == Direction.INCR && A[i] >= prev) || (d == Direction.DESC && A[i] <= prev)) {
        prev = A[i];
      } else {
        return false;
      }
    }
    return true;
  }
      
  public static void main(String[] args) {
    int[] a = {2,2,2,1};
    int[] b = {3,3,2,2,1};
    int[] c = {1,2,3,1};
    
    System.out.println(monotonic(a));
    System.out.println(monotonic(b));
    System.out.println(monotonic(c));
      
  }
}

