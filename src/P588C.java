import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by smalex on 15/10/15.
 */
public class P588C {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int[] w = new int[1001000];
    for (int i = 0 ; i < n; i++) {
      w[nextInt()]++;
    }
    for (int i = 0; i < w.length; i++) {
      if (w[i] == 0) {
        continue;
      }
      if (w[i] >= 2) {
        w[i + 1] += w[i] / 2;
        w[i] = w[i] % 2;
      }
    }
    int res = 0;
    for (int aW : w) {
      if (aW > 0) {
        res++;
      }
    }
    System.out.println(res);
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }
}
