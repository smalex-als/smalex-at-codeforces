package com.codeforces.smalex;

import java.util.*;

/**
 * Created by smalex on 28/09/15.
 */
public class P581C {
  public static void main(String[] args) throws Exception {
    new P581C().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    for (int i = 0; i < n; i ++) {
      int num = scanner.nextInt();
      if (num % 10 == 0) {
        b.add(num);
      } else {
        a.add(num);
      }
    }
    scanner.close();
    Collections.sort(a, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        int i1 = o1 % 10;
        int i2 = o2 % 10;
        return Integer.compare(i2, i1);
      }
    });
    for (int i = 0; i < a.size() && k > 0; i++) {
      Integer num = a.get(i);
      int d = num % 10;
      if (d == 0) {
        break;
      }
      d = 10 - d;
      if (k >= d) {
        k -= d;
        a.set(i, num + d);
      }
    }
    a.addAll(b);
    for (int i = 0; i < a.size() && k >= 10; i++) {
      Integer num = a.get(i);
      int d = Math.min(k, 100 - num);
      k -= d;
      a.set(i, num + d);
    }
    int res = 0;
    for (Integer integer : a) {
      res += integer / 10;
    }
    System.out.println(res);
  }
}
