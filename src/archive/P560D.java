package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by smalex on 14/08/15.
 */
public class P560D {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    String a = normalize(next());
    String b = normalize(next());
    in.close();
    System.out.println(a.equals(b) ? "YES" : "NO");
  }

  private static String normalize(String string) {
    if (string.length() % 2 != 0) {
      return string;
    }
    String a = normalize(string.substring(0, string.length() / 2));
    String b = normalize(string.substring(string.length() / 2, string.length()));
    if (a.compareTo(b) < 0) {
      return a + b;
    }
    return b + a;
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
