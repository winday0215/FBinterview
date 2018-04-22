import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  
  private static int weightedRandom(int[] items) {
    double sum = 0;
    for (int item : items) {
      sum += item;
    }
    
    double random = Math.random() * sum;
    System.out.print("Random number is " + random + "    ");
    int index = -1;
    for (int i = 0; i < items.length; i++) {
      random -= items[i];
      if (random <= 0) {
        index = i;
        break;
      }
    }
    
    return items[index];
  }
    
  public static void main(String[] args) {
    int[] items = new int[]{1, 4, 5, 6, 10};
    
    System.out.println(weightedRandom(items));
    
  }
}

