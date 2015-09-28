import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by smalex on 10/09/15.
 */
public class P577B {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder ans = new StringBuilder("");
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    Long m = Long.parseLong(st.nextToken());
    Long arr[] = new Long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }
    HashSet<Long> s1 = new HashSet<Long>();
    s1.add(0L);
    for (int i = 0; i < n; i++) {
      System.out.println("s1 = " + s1);
      HashSet<Long> s2 = new HashSet<Long>();
      for (Long e : s1) {
        s2.add(e);
        long l = e + arr[i];
        System.out.println("l = " + l);
        if (l % m == 0) {
          System.out.println("arr = " + arr[i]);
          System.out.println("e = " + e);
          System.out.println("l = " + l);
          System.out.print("YES");
          return;
        }
        s2.add((e + arr[i]));
      }
      s1 = s2;
    }
    System.out.print("NO");
  }

  public static void main2(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int m = nextInt();

    boolean ok = true;
    int[] a = new int[m];
    for (int i = 0; i < n; i++) {
      int num = nextInt();
      if (num > 0) {
        int r = num % m;
        if (r == 0) {
          System.out.println("YES");
          return;
        }
        a[r]++;
        ok = false;
      }
    }
    in.close();
    if (ok) {
      System.out.println("YES");
      return;
    }

    System.out.println(dfs(1, a, 0, m) ? "YES" : "NO");
  }

  private static boolean dfs(int index, int[] a, int sum, int m) {
    if (sum > 0) {
      int res = sum % m;
      if (res == 0) {
        return true;
      } else {
        sum = res;
      }
    }
    if (index >= a.length) {
      return false;
    }
    if (a[index] > 0) {
      a[index]--;
      if (dfs(index, a, sum + index, m)) {
        return true;
      }
      a[index]++;
    }
    return dfs(index + 1, a, sum, m);
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
