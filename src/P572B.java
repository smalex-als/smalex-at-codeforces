import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by smalex on 22/08/15.
 */
public class P572B {
  private static final Comparator<Issue> reverseComparator = new Comparator<Issue>() {
    @Override
    public int compare(Issue o1, Issue o2) {
      return Integer.compare(o2.price, o1.price);
    }
  };
  static BufferedReader in;
  static StringTokenizer tok;

  private static class Issue {
    boolean buy;
    private int price;
    private int quantity;

    public Issue(boolean buy, int price, int quantity) {
      this.buy = buy;
      this.price = price;
      this.quantity = quantity;
    }

    @Override
    public String toString() {
      return (buy ? "B " : "S ") + price + " " + quantity;
    }
  }

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int s = nextInt();
    Map<Integer, Issue> mapBuyIssues = new HashMap<Integer, Issue>();
    Map<Integer, Issue> mapSellIssues = new HashMap<Integer, Issue>();
    for (int i = 0; i < n; i++) {
      boolean buy = next().equals("B");
      int p = nextInt();
      int q = nextInt();
      Issue issue = buy ? mapBuyIssues.get(p) : mapSellIssues.get(p);
      if (issue == null) {
        issue = new Issue(buy, p, q);
        if (buy) {
          mapBuyIssues.put(p, issue);
        } else {
          mapSellIssues.put(p, issue);
        }
      } else {
        issue.quantity += q;
      }
    }
    in.close();

    List<Issue> sellIssues = new ArrayList<Issue>(mapSellIssues.values());
    Collections.sort(sellIssues, new Comparator<Issue>() {
      @Override
      public int compare(Issue o1, Issue o2) {
        return Integer.compare(o1.price, o2.price);
      }
    });
    List<Issue> buyIssues = new ArrayList<Issue>(mapBuyIssues.values());
    Collections.sort(buyIssues, reverseComparator);
    if (sellIssues.size() > s) {
      sellIssues = sellIssues.subList(0, s);
    }
    if (buyIssues.size() > s) {
      buyIssues = buyIssues.subList(0, s);
    }
    Collections.sort(sellIssues, reverseComparator);
    for (Issue sellIssue : sellIssues) {
      System.out.println(sellIssue);
    }
    for (Issue buyIssue : buyIssues) {
      System.out.println(buyIssue);
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
