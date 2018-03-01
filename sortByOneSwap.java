import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void sortByOneSwap(int[] arr, int n)
  {
    // Travers the given array from rightmost side
    for (int i = n-1; i > 0; i--)
    {
      // Check if arr[i] is not in order
      if (arr[i] < arr[i-1])
      {
        // Find the other element to be
        // swapped with arr[i]
        int j = i-1;
        while (j>=0 && arr[i] < arr[j])
          j--;

        // Swap the pair
        int temp = arr[i];
        arr[i] = arr[j+1];
        arr[j+1] = temp;
        break;
      }
    }
  }
    
  public static void printArray(int arr[], int n)
  {
      int i;
      for (i=0; i < n; i++)
        System.out.print(arr[i] + " ");
          System.out.print("\n");
  }
  
  public static void main(String[] args) {
    int[] t1 = {1, 4, 3, 2, 5};
    int n = t1.length;
    sortByOneSwap(t1, n);
    printArray(t1, n);
    
  }
}

