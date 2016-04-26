package com.codeforces.smalex;

import java.util.*;

/**
 * Created by smalex on 26/10/15.
 */
public class P535B {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long res = 0;
    long mul = 1;
    while (a > 0) {
      if (a % 10 == 4) {
        res += mul;
      } else {
        res += 2 * mul;
      }
      a /= 10;
      mul *= 2;
    }
    System.out.println(res);
  }
}
