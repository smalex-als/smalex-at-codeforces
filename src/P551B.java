import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by smalex on 20/09/15.
 */
public class P551B {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));

    String c = next();
    String a = next();
    String b = next();
    int[] k1 = createState(a);
    int[] k2 = createState(b);
    int[] kstr = createState(c);
    int bestA = 0;
    int bestB = 0;
    mainfor:
    for (int i = 0; i <= c.length(); i++) {
      int k = Integer.MAX_VALUE;
      for (int j = 0; j < 26; j++) {
        if (kstr[j] < k1[j] * i) {
          break mainfor;
        }
        if (k2[j] != 0) {
          k = Math.min(k, (kstr[j] - (k1[j] * i)) / k2[j]);
        }
      }
      if (i + k > bestA + bestB) {
        bestA = i;
        bestB = k;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < bestA; i++) {
      sb.append(a);
    }
    for (int i = 0; i < bestB; i++) {
      sb.append(b);
    }
    for (int i = 0; i < 26; i++) {
      kstr[i] -= k1[i] * bestA + k2[i] * bestB;
      for (int j = 0; j < kstr[i]; j++) {
        sb.append((char) (i + 'a'));
      }
    }
    System.out.println(sb.toString());
  }

  private static int[] createState(String str) {
    int[] stat = new int[26];
    for (int i = 0; i < str.length(); i++) {
      stat[str.charAt(i) - 'a']++;
    }
    return stat;
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
