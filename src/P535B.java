import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by smalex on 25/10/15.
 */
public class P591C {
  static BufferedReader in;
  static StringTokenizer tok;
  static int[] num = new int[]{0, 0, 0, 1, 0, 1, 1, 1};

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int[] a = nextIntArray(n, 0);
    in.close();
    runTest();
    //  int cnt = solve(a);
    //  System.out.println(cnt);
    //  if (cnt >= 0) {
    //    printA(a);
    //  }
  }

  private static void printA(int[] a) {
    StringBuilder sb = new StringBuilder();
    for (int i : a) {
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(i);
    }
    System.out.println(sb);
  }

  private static void runTest() {
    Random random = new Random();

    int k = 10;
    for (int j = 0; j < (1 << k); j++) {
      String format = String.format("%10s", Integer.toBinaryString(j)).replace(' ', '0');
      int[] b = new int[10];
      for (int i = 0; i < b.length; i++) {
        b[i] = format.charAt(i) - '0';
        // b[i] = random.nextInt(2);
      }
      int cnt = solve(b);
      System.out.println("cnt = " + cnt);
      printA(b);
    }
  }

  private static int solve(int[] b) {
    int[] prev = new int[b.length];
    int cnt = 0;
    while (true) {
      System.arraycopy(b, 0, prev, 0, b.length);
      int changes = 0;
      System.out.println("b = " + Arrays.toString(b));
      for (int i = 1; i < b.length - 1; i++) {
        int calc = num[prev[i - 1] << 2 | prev[i] << 1 | prev[i + 1]];
        if (calc != b[i]) {
          b[i] = calc;
          changes++;
        }
      }
      if (changes == 0) {
        break;
      }
      cnt++;
    }
    return cnt;
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

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }
}
