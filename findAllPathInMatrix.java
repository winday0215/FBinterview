import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
0, 1 matrix, 0 can pass, 1 can't pass, find all paths from top left to bottom right, move 4 directions*/
class Solution {

  static class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  private static int[] dx = {-1, 0, 1, 0};
  private static int[] dy = {0, 1, 0, -1};
  
  public static List<List<Point>> findAllPathInMatrix(int[][] matrix) {
    List<List<Point>> res = new ArrayList<>();
    List<Point> path = new ArrayList<>();
    path.add(new Point(0, 0));

    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    visited[0][0] = true;
    
    
    dfs(matrix, 0, 0, path, visited, res);
    return res;
  }
   
  private static void dfs(int[][] matrix, int x, int y, List<Point> path, 
                          boolean[][] visited, List<List<Point>> res) {
    
   
    if (x == matrix.length - 1 && y == matrix[0].length - 1) {
      res.add(new ArrayList<Point>(path));
      return;
    }
    
    for (int i = 0; i < 4; i++) {
      int newx = x + dx[i];
      int newy = y + dy[i];
      
      if (newx < 0 || newx >= matrix.length || newy < 0 || 
          newy >= matrix[0].length || matrix[newx][newy] == 1 || visited[newx][newy]) {
        continue;
      }
      
      path.add(new Point(newx, newy));
      visited[newx][newy] = true;
      dfs(matrix, newx, newy, path, visited, res);
      visited[newx][newy] = false;
      path.remove(path.size() - 1);
    }
    
    
    
  }
      
  public static void main(String[] args) {
    int[][] a = {{0, 1, 0, 0}, {0, 0, 0, 0}};
    
    
    List<List<Point>> res = findAllPathInMatrix(a);
    
    for (List<Point> l : res) {
      for (Point p : l) {
        System.out.print("(" + p.x + ", " + p.y + "), " );
      }
      System.out.print("\n");
    }
      
  }
}

