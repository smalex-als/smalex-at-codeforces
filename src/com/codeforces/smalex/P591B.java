package com.codeforces.smalex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by smalex on 25/10/15.
 */
public class P591B {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int m = nextInt();
    Map<Character, List<Integer>> map = new HashMap<>();
    String str = next();
    for (int i = 0; i < n; i++) {
      Character key = str.charAt(i);
      List<Integer> pos = map.get(key);
      if (pos == null) {
        pos = new ArrayList<>();
        map.put(key, pos);
      }
      pos.add(i);
    }
    for (int i = 0; i < m; i++) {
      Character x = next().charAt(0);
      Character y = next().charAt(0);
      List<Integer> posX = map.get(x);
      List<Integer> posY = map.get(y);
      map.remove(x);
      map.remove(y);
      if (posX != null) {
        map.put(y, posX);
      }
      if (posY != null) {
        map.put(x, posY);
      }
    }
    in.close();
    char[] res = new char[n];
    for (char key : map.keySet()) {
      for (Integer integer : map.get(key)) {
        res[integer] = key;
      }
    }
    System.out.println(new String(res));
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
