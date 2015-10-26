package archive;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smalex on 16/10/15.
 */
public class P586B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] hor = new int[2][n - 1];
    int[] v = new int[n];
    for (int j = 0; j < 2; j++) {
      for (int i = 0; i < n - 1; i++) {
        hor[j][i] = scanner.nextInt();
      }
    }
    for (int i = 0; i < n; i++) {
      v[i] = scanner.nextInt();
    }

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      int sum = v[i];
      for (int x = 0; x < i; x++) {
        sum += hor[0][x];
      }
      for (int x = i; x < n - 1; x++) {
        sum += hor[1][x];
      }
      a[i] = sum;
    }
    Arrays.sort(a);
    System.out.println(a[0] + a[1]);
  }
}
