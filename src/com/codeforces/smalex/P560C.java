package com.codeforces.smalex;

import java.util.Scanner;

/**
 * Created by smalex on 14/08/15.
 */
public class P560C {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a1 = scanner.nextInt();
    int a2 = scanner.nextInt();
    int a3 = scanner.nextInt();
    int a4 = scanner.nextInt();
    int a5 = scanner.nextInt();
    int a6 = scanner.nextInt();
    int res = (a1 + a2 + a3) * (a1 + a2 + a3) - (a1 * a1) - (a3 * a3) - (a5 * a5);
    System.out.println(res);
  }
}
