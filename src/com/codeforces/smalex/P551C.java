package com.codeforces.smalex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by smalex on 04/09/15.
 */
public class P551C {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int m = nextInt();
    int[] a = nextIntArray(n, 0);

    System.out.println(binarySolveRecursive(m, a, 2L, Long.MAX_VALUE));
  }

  private static long binarySolveRecursive(int m, int[] a, long lo, long hi) {
    if (lo >= hi) {
      return hi;
    }
    final long mid = (lo + hi) >> 1;
    if (check(m, a, mid)) {
      return binarySolveRecursive(m, a, lo, mid);
    }
    return binarySolveRecursive(m, a, mid + 1L, hi);
  }

  private static long binarySolve(int m, int[] a) {
    long l = 2L;
    long r = Long.MAX_VALUE;
    while (l < r) {
      final long k = (r + l) >> 1;
      if (check(m, a, k)) {
        r = k;
      } else {
        l = k + 1;
      }
    }
    return l;
  }

  private static boolean check(int m, int[] a, long k) {
    int[] b = a.clone();
    int p = a.length - 1;
    for (int i = 0; i < m; i++) {
      while (p >= 0 && b[p] == 0) {
        p--;
      }
      long t = k - p - 1;
      if (t < 0) {
        break;
      }
      while (p >= 0 && b[p] <= t) {
        t -= b[p--];
      }
      if (p >= 0) {
        b[p] -= t;
      }
    }
    return p < 0;
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static int[] nextIntArray(int len, int start) throws IOException {
    int[] a = new int[len];
    for (int i = start; i < len; i++)
      a[i] = nextInt();
    return a;
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static long[] nextLongArray(int len, int start) throws IOException {
    long[] a = new long[len];
    for (int i = start; i < len; i++)
      a[i] = nextLong();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }
}
