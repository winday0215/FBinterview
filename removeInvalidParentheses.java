// two pass, O(n) time, O(1) space

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
remove one valid parentheses*/
class Solution {

  public static String removeParenthese(String s) {
    StringBuilder sb = remove(s, '(');
    return remove(sb.reverse().toString(), ')').reverse().toString();
  }
  
  private static StringBuilder remove(String s, char target) {
    StringBuilder sb = new StringBuilder();
    
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == target) {
        cnt++;
      } else {
        cnt--;
      }
      
      if (cnt >= 0) {
        sb.append(s.charAt(i));
      } else {
        cnt++;
      }
    }
    
    return sb;
  }
      
      
  public static void main(String[] args) {
    String s = "()()))(";
    
    System.out.println(removeParenthese(s));
  }
}


// one pass, O(n) space and time
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
remove one valid parentheses*/
class Solution {

  public static String removeParenthese(String s) {
    Stack<Integer> stack = new Stack<Integer>();
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i);
      } else if (c == ')') {
        if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
          stack.push(i);
        } else {
          stack.pop();
        }
      }
    }
    
    
    StringBuilder sb = new StringBuilder(s);
    while (!stack.isEmpty()) {
      sb.deleteCharAt(stack.pop());
    }
    
    return sb.toString();
  }
      
      
  public static void main(String[] args) {
    String s = "()()))(";
    
    System.out.println(removeParenthese(s));
  }
}

