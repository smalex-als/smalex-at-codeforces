import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by smalex on 13/08/15.
 */
public class P570C {
  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    int n = nextInt();
    int m = nextInt();
    String str = next();
    char[] chars = str.toCharArray();
    int cnt = getCount(chars);
    for (int i = 0; i < m; i++) {
      int c = nextInt();
      char newChar = next().charAt(0);
      char prevChar = chars[c - 1];

      if (prevChar == '.' && newChar == '.') {
        // nothing
      } else if (prevChar == '.') {
        if (c < chars.length && chars[c] == '.') {
          cnt--;
        }
        if (c - 2 >= 0 && chars[c - 2] == '.') {
          cnt--;
        }
      } else if (prevChar != '.' && newChar == '.') {
        if (c - 2 >= 0 && chars[c - 2] == '.') {
          cnt++;
        }
        if (c < chars.length && chars[c] == '.') {
          cnt++;
        }
      }
      chars[c - 1] = newChar;
//      System.out.println(new String(chars) + " getCount(chars) = " + getCount(chars));
      out.println(cnt);
    }
    in.close();
    out.close();
  }

  private static int getCount(char[] chars) {
    int cnt = 0;
    for (int j = 1; j < chars.length; j++) {
      if (chars[j - 1] == '.' && chars[j] == '.') {
        cnt++;
      }
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
