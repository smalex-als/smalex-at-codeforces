package com.codeforces.smalex;

import java.util.Scanner;

/**
 * Created by smalex on 03/10/15.
 */
public class P583A {
  public static void main(String[] args) throws Exception {
    new P583A().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int N_2 = n * n;
    boolean[] vdone = new boolean[n + 1];
    boolean[] hdone = new boolean[n + 1];
    int day = 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N_2; i++, day++) {
      int h = scanner.nextInt();
      int v = scanner.nextInt();
      if (!vdone[v] && !hdone[h]) {
        vdone[v] = true;
        hdone[h] = true;
        if (sb.length() > 0) {
          sb.append(" ");
        }
        sb.append(day);
      }
    }
    System.out.println(sb.toString());
  }
}
