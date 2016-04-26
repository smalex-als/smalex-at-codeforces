package com.codeforces.smalex;

import java.util.Scanner;

/**
 * Created by smalex on 19/08/15.
 */
public class P550B {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int l = scanner.nextInt();
    int r = scanner.nextInt();
    int x = scanner.nextInt();
    int[] problems = new int[n];
    for (int i = 0; i < n; i++) {
      problems[i] = scanner.nextInt();
    }
    int res = 0;
    for (int i = 0; i < (1 << n); i++) {
      int sum = 0;
      int min = Integer.MAX_VALUE;
      int max = 0;
      for (int j = 0; j < problems.length; j++) {
        if ((i & (1 << j)) != 0) {
          sum += problems[j];
          max = Math.max(problems[j], max);
          min = Math.min(problems[j], min);
        }
      }
      if (l <= sum && sum <= r && (max - min) >= x) {
        res++;
      }
    }
    System.out.println(res);
  }
}
