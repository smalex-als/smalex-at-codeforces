package com.codeforces.smalex;

import java.util.Scanner;

/**
 * Created by smalex on 15/10/15.
 */
public class P588A {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    int[] p = new int[n];
    for (int i = 0 ; i < n ;i ++) {
      a[i] = scanner.nextInt();
      p[i] = scanner.nextInt();
    }
    int money = 0;
    int rest = 0;
    for (int i = 0; i < n; i++) {
      if (rest >= a[i]) {
        rest -= a[i];
        continue;
      }
      int needtobuy = 0;
      for (int j = i; j < n && p[i] <= p[j]; j++) {
        needtobuy += a[j];
      }
      rest += needtobuy - a[i];
      money += needtobuy * p[i];
    }
    System.out.println(money);
  }
}
