import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  private static List<Integer> primeProduct(int[] num) {
    List<Integer> res = new ArrayList<Integer>();
    int startIndex = 0;
    if (num[0] == 1) {
      startIndex = 1;
    }
    
    helper(num, startIndex, 1, res);
    if (num[0] != 1) {
      res.remove(0);
    }
    
    return res;
  }
  
  private static void helper(int[] num, int startIndex, int product, List<Integer> res) {
    res.add(product);
    
    for (int i = startIndex; i < num.length; i++) {
      product *= num[i];
      helper(num, i + 1, product, res);
      product /= num[i];
    }
  }
    
  public static void main(String[] args) {
    int[] num = new int[]{1, 3, 5, 7};
    int[] num2 = new int[]{3, 5, 7, 11};
    
    System.out.println(primeProduct(num));
    System.out.println(primeProduct(num2));
                       
    
  }
}

