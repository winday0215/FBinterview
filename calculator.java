import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static int calculator(String s) {
    Stack<Integer> nums = new Stack<Integer>();
    Stack<Character> ops = new Stack<Character>();
    
    int num = 0;
    boolean hasNum = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
        hasNum = true;
      } 
      
      if (i == s.length() - 1 || isOps(c)){
        if (hasNum) {
          nums.push(num);
          num = 0;
          hasNum = false;
        }
        
        if (c == '*') {
          ops.push(c);
        } else if (c == '+') {
          while (!ops.isEmpty() && ops.peek() == '*') {
            nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
          }
          ops.push(c);
        }
      }
    }
    
    while (!ops.isEmpty()) {
      nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
    }
    
    return nums.peek();
  }
  
  private static int calc(int a, int b, char op) {
    if (op == '*') return a * b;
    return a + b;
  }
   
  private static boolean isOps(char c) {
    return c == '+' || c == '*';
  }
  
  public static void main(String[] args) {
    String s1 = "1+2*3+4";
    String s2 = "1+2*3*4";
    String s3 = "1*2+3*4";
    String s4 = "1+2+3+4";
    System.out.println(calculator(s4));
  }
}



