package com.codeforces.smalex;

import java.util.Scanner;

/**
 * Created by smalex on 25/10/15.
 */
public class P591A {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double l = scanner.nextInt();
    double p = scanner.nextInt();
    double q = scanner.nextInt();
    double r = (l / (p + q) * p);
    System.out.println(r);
  }
}
