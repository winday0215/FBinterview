import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static char[][] generateMineSweeper(int r, int c, int mines) {
    int minesPlaced = 0;
    Random rand = new Random();
    char[][] board = new char[r][c];
    for (int i = 0; i < r; i++) {
      Arrays.fill(board[i], '.');
    }
    
    while (minesPlaced < mines) {
      int x = rand.nextInt(r);
      int y = rand.nextInt(c);
      
      if (board[x][y] == '.') {
        board[x][y] = '*';
        minesPlaced++;
      }
    }
    
    return board;
  }
  
  public static char[][] countMines(char[][] board) {
    char[][] count = new char[board.length + 2][board[0].length + 2];
    
    for (int i = 1; i < count.length - 1; i++) {
      for (int j = 1; j < count[0].length - 1; j++) {
        
        if (board[i - 1][j - 1] == '.') {
          int cnt = 0;
          for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
              if (k - 1 >= 0 && k - 1 < board.length && l - 1 >= 0 
                  && l - 1 < board[0].length &&board[k - 1][l -1] == '*') {
                cnt++;
              }
            }
          }
        
        
          if (cnt == 0) {
            count[i][j] = 'B';
          } else {
            count[i][j] = (char)(cnt + '0');
          }
        } else {
          count[i][j] = '*';
        }
      }
    }
    
    return count;
  }
    
    
  public static void main(String[] args) {
    int r = 20;
    int c = 20;
    int mines = 90;
    
    char[][] b = generateMineSweeper(r, c, mines);

    
    char[][] count = countMines(b);
    
    for (int i = 1; i < count.length - 1; i++) {
      for (int j = 1; j < count[0].length - 1; j++) {
        System.out.print(count[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}

