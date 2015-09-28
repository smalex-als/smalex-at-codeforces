import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by smalex on 15/08/15.
 */
public class P560E {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    int h = nextInt();
    int w = nextInt();
    int n = nextInt();

    Set<Integer> mark = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      int y = nextInt() - 1;
      int x = nextInt() - 1;
      mark.add(toKey(y, x));
    }
    long[][] cost = new long[2][w];
    for (int y = 0; y < h; y++) {
      System.out.println("y = " + y);
      int prevRow = (y + 1) % 2;
      int row = y % 2;
      if (y == 0) {
        for (int x = 0; x < w; x++) {
          cost[row][x] = isBlack(mark, y, x) ? 0 : 1;
        }
        continue;
      }
      for (int x = 0; x < w; x++) {
        if (isBlack(mark, y, x)) {
          cost[row][x] = 0;
          continue;
        }
        long left = x > 0 && !isBlack(mark, y, x - 1) ? cost[row][x - 1] : 0;
        long up = y > 0 && !isBlack(mark, y - 1, x) ? cost[prevRow][x] : 0;
        cost[row][x] = (up + left) % 1000000007;
      }
    }
    in.close();
    System.out.println(cost[(h - 1) % 2][w - 1]);
  }

  private static boolean isBlack(Set<Integer> mark, int y, int x) {
    return mark.contains(toKey(y, x));
  }

  private static int toKey(int y, int x) {
    return y * 100000 + x;
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
