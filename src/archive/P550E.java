package archive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by smalex on 20/08/15.
 */
public class P550E {
  private static FastScanner sc;
  private static BufferedReader in;
  private static PrintWriter out;

  public static void main(String[] args) throws Exception {
    // TODO fail tests
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    sc = new FastScanner(in);
    solve();
    out.close();
  }

  private static void solve() throws Exception {
    int n = sc.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = sc.nextInt();
    }
    if (numbers[n - 1] != 0) {
      out.println("NO");
      return;
    }
    if (n > 1 && numbers[n - 2] == 0) {
      out.println("NO");
      return;
    }
    out.println("YES");
    for (int i = 0; i < numbers.length; i++) {
      int number = numbers[i];
      if (i > 0) {
        out.print("->");
      }
      out.print(number);
    }
    out.println();
  }

  private static class FastScanner {
    BufferedReader reader;
    StringTokenizer strTok;

    FastScanner(BufferedReader reader) {
      this.reader = reader;
    }

    public String nextToken() throws Exception {
      while (strTok == null || !strTok.hasMoreTokens()) {
        strTok = new StringTokenizer(reader.readLine());
      }
      return strTok.nextToken();
    }

    public int nextInt() throws Exception {
      return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
      return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
      return Double.parseDouble(nextToken());
    }
  }

}
