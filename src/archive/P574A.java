package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by smalex on 29/08/15.
 */
public class P574A {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    in.close();

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n - 1, Collections.reverseOrder());
    for (int i = 1; i < a.length; i++) {
      queue.add(a[i]);
    }
    int res = 0;
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      if (poll >= a[0]) {
        a[0]++;
        queue.add(--poll);
        res++;
      } else {
        break;
      }
    }
    System.out.println(res);
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
