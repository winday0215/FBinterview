import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static int cal(String f) {
    if (f == null || f.length() == 0) {
      return 0;
    }
    
    String[] tokens = f.split("\\+");
    
    int res = 0;
    for (String token : tokens) {
      String[] factors = token.split("\\*");
      int tmp = 1;
      for (String factor : factors) {
        tmp *= Integer.parseInt(factor);
      }
      
      res += tmp;
    }
    return res;
  }
  
  public static void main(String[] args) {
    String s = "1+2*3*4+5+6";
    
    System.out.println(cal(s));
  }
}

