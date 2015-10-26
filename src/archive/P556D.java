package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P556D {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    List<Range> ranges = new ArrayList<Range>();
    long preL = nextLong(), preR = nextLong();
    for (int i = 1; i < n; i++) {
      long nowL = nextLong(), nowR = nextLong();
      ranges.add(new Range(nowL - preR, nowR - preL, i));
      preL = nowL;
      preR = nowR;
    }
    Collections.sort(ranges, new Comparator<Range>() {
      @Override
      public int compare(Range o1, Range o2) {
        return Long.compare(o1.min, o2.min);
      }
    });
    List<Bridge> bridges = new ArrayList<Bridge>();
    for (int i = 0; i < m; i++)
      bridges.add(new Bridge(nextLong(), i + 1));
    Collections.sort(bridges);
    TreeSet<Range> set = new TreeSet<Range>();
    int p = 0;
    for (Bridge bridge : bridges) {
      while (p < ranges.size() && ranges.get(p).min <= bridge.w)
        set.add(ranges.get(p++));
      if (!set.isEmpty()) {
        Range range = set.pollFirst();
        if (range.max < bridge.w) {
          out.println("No");
          return;
        }
        range.j = bridge;
      }
    }
    if (p < ranges.size() || !set.isEmpty()) {
      out.println("No");
      return;
    }
    out.println("Yes");
    Collections.sort(ranges, new Comparator<Range>() {
      @Override
      public int compare(Range o1, Range o2) {
        return Integer.compare(o1.i, o2.i);
      }
    });
    for (Range range : ranges)
      out.print(range.j.i + " ");
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      solve();
      in.close();
      out.close();
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(1);
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


class Range implements Comparable<Range> {
  long min;
  long max;
  int i;
  Bridge j;

  Range(long a, long b, int c) {
    min = a;
    max = b;
    i = c;
  }

  @Override
  public int compareTo(Range o) {
    int z = Long.compare(max, o.max);
    if (z == 0)
      z = i - o.i;
    return z;
  }
}


class Bridge implements Comparable<Bridge> {
  long w;
  int i;

  Bridge(long a, int b) {
    w = a;
    i = b;
  }

  @Override
  public int compareTo(Bridge o) {
    return Long.compare(w, o.w);
  }
}