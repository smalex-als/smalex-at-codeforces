import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by smalex on 10/09/15.
 */
public class P577C {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    in.close();

    boolean[] primes = new boolean[n + 1];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;
    for (int i = 2; i < Math.sqrt(n); i++) {
      for (int j = 2 * i; j < n; j += i) {
        primes[j] = false;
      }
    }

    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < primes.length; i++) {
      if (primes[i]) {
        for (int j = i; j <= n; j *= i) {
          res.add(j);
        }
      }
    }
    System.out.println(res.size());
    for (Integer re : res) {
      System.out.print(re + " ");
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

