import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by smalex on 22/08/15.
 */
public class P572D {
  static BufferedReader in;
  static StringTokenizer tok;

  private static class Pair implements Comparable<Pair> {
    int a;
    int b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public String toString() {
      return "Pair{a=" + a + ", b=" + b + '}';
    }

    @Override
    public int compareTo(Pair o) {
      return Integer.compare(Math.abs(a - b), Math.abs(o.a - o.b));
    }
  }

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int k = nextInt();
    int[] a = nextIntArray(n, 0);
    in.close();
    Arrays.sort(a);
    List<Pair> pairs = new ArrayList<Pair>();
    for (int i = 0; i < a.length; i++) {
      int num = a[i];
      int low = i + 1;
      int high = a.length - 1;
      int min = Integer.MIN_VALUE;
      int mid = 0;
      while (low <= high) {
        mid = (low + high) >>> 1;
        int midVal = a[mid];

        min = Math.abs(num - midVal);
        if (midVal < num) {
          low = mid + 1;
        } else if (midVal > num) {
          high = mid - 1;
        } else {
          break;
        }
      }
      if (min != Integer.MAX_VALUE) {
        pairs.add(new Pair(a[i], a[mid]));
      } else {
        pairs.add(new Pair(a[i], 99999999));
      }
//      System.out.println("num = " + a[i]);
//      System.out.println("min = " + min);
    }
    Collections.sort(pairs);
    int[] res = new int[10];
    boolean[] filled = new boolean[10];
    for (int i = 0; i < n - k; i++) {
      if (!filled[i]) {
        Pair pair = pairs.get(0);
        pairs.remove(0);
        res[i] = pair.a;
        filled[i] = true;
        res[i + k] = pair.b;
        filled[i + k] = true;
      } else {

      }
    }
//    if (index0 != -1) {
//      System.out.println("min = " + min + " a[" + (index0 - 1) +"]= " + a[index0 - 1] + " a[" + index0 + "] = " + a[index0]);
//
//    }
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
