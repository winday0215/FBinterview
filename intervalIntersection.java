import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  static class Interval {
    int s;
    int e;
    public Interval(int s, int e) {
      this.s = s;
      this.e = e;
    }
  }
  
  static class Pair {
    int t;
    int isStart;
    public Pair (int t, int isStart) {
      this.t = t;
      this.isStart = isStart;
    }
  }
  
  private static List<Interval> online(List<Interval> A, List<Interval> B) {
    List<Pair> timeLine = new ArrayList<Pair>();
    for (Interval in : A) {
      timeLine.add(new Pair(in.s, 0));
      timeLine.add(new Pair(in.e, 1));
    }
    
    for (Interval in : B) {
      timeLine.add(new Pair(in.s, 0));
      timeLine.add(new Pair(in.e, 1));
    }
    
    Collections.sort(timeLine, (a, b) -> a.t == b.t ? b.isStart - a.isStart : a.t - b.t);
    
    int count = 0;
    List<Interval> res = new ArrayList<>();
    int start = -1, end = -1;
    for (Pair p : timeLine) {
      if (p.isStart == 0) {//start
        count++;
        if (count == 2) {
          start = p.t;
        }
      } else {//end
        count--;
        if (count == 1) {
          end = p.t;
          res.add(new Interval(start, end));
        }
      }
    }
    
    return res;
  }
  
  
    
  public static void main(String[] args) {
    List<Interval> A = new ArrayList<>();
    A.add(new Interval(3, 4));
    A.add(new Interval(7, 10));
    
    List<Interval> B = new ArrayList<>();
    B.add(new Interval(2, 3));
    B.add(new Interval(9, 11));
    
    List<Interval> ans = online(A, B);
    
    for (Interval in : ans) {
      System.out.println(in.s + "," + in.e);
    }
    
  }
}

