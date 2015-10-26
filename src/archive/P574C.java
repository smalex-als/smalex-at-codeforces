package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by smalex on 29/08/15.
 */
public class P574C {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    for (int i = 0; i < a.length; i++) {
      int num = a[i];
      while (num % 2 == 0) num /= 2;
      while (num % 3 == 0) num /= 3;
      a[i] = num;
      if (num != a[0]) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
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
