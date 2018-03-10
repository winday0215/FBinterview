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
  
  public static List<List<Point>> findShortestPathInMatrix(int[][] matrix) {
    List<List<Point>> res = new ArrayList<>();
    List<Point> path = new ArrayList<>();

    int[][] distance = shortestDistance(matrix);
    
    
    findPath(matrix, matrix.length - 1, matrix[0].length - 1, path, distance, res);
    return res;
  }
   
  private static int[][] shortestDistance(int[][] matrix) {
    
    int[][] distance = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < distance.length; i++) {
      for (int j = 0; j < distance[0].length; j++){
        if (matrix[i][j] == 0) {
          distance[i][j] = Integer.MAX_VALUE;
        } else {
          distance[i][j] = Integer.MIN_VALUE;
        }
      }
    }
    
    Queue<Point> q = new LinkedList<>();
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    visited[0][0] = true;
    
    q.offer(new Point(0, 0));
    distance[0][0] = 0;
    
    while (!q.isEmpty()) {
      Point cur = q.poll();
      
      for (int i = 0; i < 4; i++) {
        int newx = cur.x + dx[i];
        int newy = cur.y + dy[i];
        
        if (newx < 0 || newx >= matrix.length || newy < 0 || 
          newy >= matrix[0].length || matrix[newx][newy] == 1 || visited[newx][newy]) {
          continue;
        } 
        
        visited[newx][newy] = true;
        distance[newx][newy] = Math.min(distance[newx][newy], distance[cur.x][cur.y] + 1);
        q.offer(new Point(newx, newy));
      }
    }
    
    return distance;
  }
      
        
    
  private static void findPath(int[][] matrix, int x, int y, List<Point> path, 
                          int[][] distance, List<List<Point>> res) {
    
    path.add(new Point(x, y));
    
    if (x == 0 && y == 0) {
      Collections.reverse(path);
      res.add(new ArrayList<Point>(path));
      Collections.reverse(path);
    } else {
      for (int i = 0; i < 4; i++) {
        int newx = x - dx[i];
        int newy = y - dy[i];

        if (newx < 0 || newx >= matrix.length || newy < 0 || 
            newy >= matrix[0].length || matrix[newx][newy] == 1) {
          continue;
        }

        if (distance[newx][newy] + 1 == distance[x][y]) {
          findPath(matrix, newx, newy, path, distance, res);
        }
      }
    }
    
    path.remove(path.size() - 1);
  }
      
  public static void main(String[] args) {
    int[][] a = {{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}};
    
    
    List<List<Point>> res = findShortestPathInMatrix(a);
    
    for (List<Point> l : res) {
      for (Point p : l) {
        System.out.print("(" + p.x + ", " + p.y + "), " );
      }
      System.out.print("\n");
    }
      
  }
}

