mport java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static String coolDown(char[] tasks, int k) {
    if (tasks == null || tasks.length == 0) {
      return "";
    }
    
    if (k == 0) {
      return new String(tasks);
    }
    
    Queue<Character> windowK = new LinkedList<>();
    Set<Character> waitList = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    
    int i = 0;
    while (i < tasks.length) {
      char c = tasks[i];
      if (waitList.contains(c)) {
        windowK.offer('_');
        sb.append("_");
      } else {
        sb.append(c);
        windowK.offer(c);
        waitList.add(c);
        i++;
      }
      
      if (windowK.size() > k) {
        char x = windowK.poll();
        if (x != '_') {
          waitList.remove(x);
        }
      }
    }
    return sb.toString();
  }
    
  public static void main(String[] args) {
    char[] t1 = {'1', '1', '2', '3', '2'};
    
    String s1 = coolDown(t1, 1);
    System.out.println(s1);
    
    String s2 = coolDown(t1, 0);
    System.out.println(s2);
    
    String s3 = coolDown(t1, 2);
    System.out.println(s3);
    
    char[] t2 = {};
    String s4 = coolDown(t2, 0);
    System.out.println(s4);
    
  }
}
