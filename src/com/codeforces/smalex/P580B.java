package com.codeforces.smalex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by smalex on 22/09/15.
 */
public class P580B {
  static BufferedReader in;
  static StringTokenizer tok;

  private static class Pair implements Comparable<Pair> {
    int m;
    int s;

    public Pair(int m, int s) {
      this.m = m;
      this.s = s;
    }


    @Override
    public int compareTo(Pair o) {
      return Integer.compare(m, o.m);
    }

    @Override
    public String toString() {
      return "Pair{" +
          "m=" + m +
          ", s=" + s +
          '}';
    }
  }
  public static void main(String[] args) throws IOException {
//    in = new BufferedReader(new InputStreamReader(new FileInputStream("test.io")));
     in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int d = nextInt();
    Pair[] a = new Pair[n];
    for (int i = 0; i < n; i++) {
      a[i] = new Pair(nextInt(), nextInt());
    }
    in.close();
    Arrays.sort(a);

    long maxfriendship = 0;
    int prevm = -1;

    for (int i = 0; i < n; i ++) {
      int money = a[i].m;
      long friendship = 0;
      if (prevm == money) {
        continue;
      }
      for (int j = i; j < a.length; j++) {
        Pair pair = a[j];
        if (Math.abs(pair.m - money) < d) {
          friendship += pair.s;
        } else {
          break;
        }
      }
      prevm = money;
      maxfriendship = Math.max(maxfriendship, friendship);
    }
    System.out.println(maxfriendship);
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
