package com.codeforces.smalex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by smalex on 19/08/15.
 */
public class P550A {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    String str = next();
    in.close();
    System.out.println(solve(str) ? "YES" : "NO");
  }

  private static boolean solve(String str) {
    int indexAB = str.indexOf("AB");
    int indexBA = str.indexOf("BA");
    if (indexAB == -1 || indexBA == -1) {
      return false;
    }
    return find(str, "AB", "BA") || find(str, "BA", "AB");
  }

  private static boolean find(String str, String first, String second) {
    int i = str.indexOf(first);
    if (i != -1) {
      str = str.replaceFirst(first, "ЯЯЯЯЯЯ");
      i = str.indexOf(second);
      if (i != -1) {
        return true;
      }
    }
    return false;
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
