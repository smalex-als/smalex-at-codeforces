package archive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by smalex on 20/08/15.
 */
public class P550C {
  private static FastScanner sc;
  private static BufferedReader in;
  private static PrintWriter out;

  public static void main(String[] args) throws Exception {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      sc = new FastScanner(in);
      solve();
      out.close();
  }

  private static void solve() throws Exception {
    String num = sc.nextToken();
    for (int i = 0; i < 1000; i += 8) {
      String str = String.valueOf(i);
      if (str.length() > num.length()) {
        break;
      }
//      System.out.println("str = " + str);
      if (str.length() > 1) {
        int lst = 0;
        boolean ok = true;
        for (int j = 0; j < str.length(); j++) {
          char c = str.charAt(j);
          lst = num.indexOf(c, lst);
//          System.out.println("c = " + c + " lst = " + lst);
          if (lst == -1) {
            ok = false;
            break;
          }
          lst++;
        }
        if (ok) {
          out.println("YES");
          out.println(str);
          return;
        }
      } else if (num.contains(str)) {
        out.println("YES");
        out.println(str);
        return;
      }
    }
    out.println("NO");
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
