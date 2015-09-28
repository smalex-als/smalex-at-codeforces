import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by smalex on 29/08/15.
 */
public class P574B {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int m = nextInt();
    List<Set<Integer>> known = new ArrayList<Set<Integer>>(n + 1);
    for (int i = 0; i <= n; i++) {
      known.add(new HashSet<Integer>());
    }
    int[][] pairs = new int[m][2];
    for (int i = 0; i < m; i++) {
      int i1 = nextInt();
      int i2 = nextInt();
      known.get(i1).add(i2);
      known.get(i2).add(i1);
      pairs[i][0] = i1;
      pairs[i][1] = i2;
    }
    in.close();

    int res = Integer.MAX_VALUE;
    for (int[] pair : pairs) {
      int friend1 = pair[0];
      int friend2 = pair[1];
      for (int friend3 : known.get(friend1)) {
        if (friend3 != friend2 && known.get(friend2).contains(friend3)) {
          res = Math.min(res, known.get(friend1 ).size() + known.get(friend2).size() + known.get(friend3).size() - 6);
//          System.out.println("friend1 = " + friend1 + " friend2 = " + friend2 + " friend3 = " + friend3);
        }
      }
    }
    if (res == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(res);
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
