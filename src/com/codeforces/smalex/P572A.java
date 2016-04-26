package com.codeforces.smalex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by smalex on 22/08/15.
 */
public class P572A {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int nA = nextInt();
    int nB = nextInt();
    int k = nextInt();
    int m = nextInt();
    int[] a = nextIntArray(nA, 0);
    int[] b = nextIntArray(nB, 0);
    in.close();
    System.out.println(solve(k, m, a, b) ? "YES" : "NO");
  }

  private static boolean solve(int k, int m, int[] a, int[] b) {
    int index0 = k - 1;
    int index1 = b.length - m;
    int num1 = a[index0];
    int num2 = b[index1];
    return num1 < num2;
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
