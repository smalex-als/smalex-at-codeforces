package com.codeforces.smalex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by smalex on 06/10/15.
 */
public class P584C {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int t = nextInt();
    int originalT = t;
    String a = next();
    String b = next();

    char[] achars = a.toCharArray();
    char[] bchars = b.toCharArray();
    char[] res = new char[n];
    int cnt = n - t;
    int at = 0;
    int bt = 0;
    for (int i = 0; i < n && (at < cnt || bt < cnt); i++) {
      if (i % 2 == 0) {
        res[i] = achars[i];
        at++;
      }
      else {
        res[i] = bchars[i];
        bt++;
      }
    }
    System.out.println("at = " + at);
    System.out.println("bt = " + bt);
//    for (int i = 0; i < res.length; i++) {
//      if (res[i] == 0) {
//        for (int j = 0; j < 26; j++) {
//          if (j + 'a' != achars[i] && j + 'a' != bchars[i]) {
//            res[i] = (char) ('a' + j);
//            break;
//          }
//        }
//      }
//    }
    for (int i = 0; i < achars.length; i++) {
      if (achars[i] != res[i]) {
        at++;
      }
      if (bchars[i] != res[i]) {
        bt++;
      }
    }
    System.out.println("at = " + at);
    System.out.println("bt = " + bt);
    System.out.println(new String(res));
    if (at == bt && at == originalT) {
      System.out.println(new String(res));
    } else {
      System.out.println(-1);
    }
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
