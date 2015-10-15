import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by smalex on 22/09/15.
 */
public class P580C {
  static BufferedReader in;
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    int n = nextInt();
    int m = nextInt();
    int[] cats = nextIntArray(n, 0);
    Map<Integer, List<Integer>> connected = new HashMap<>();
    for (int i = 1; i < n; i++) {
      int a = nextInt();
      int b = nextInt();
      connectVertex(connected, a, b);
      connectVertex(connected, b, a);
    }
    int[] costs = new int[n + 1];
    Arrays.fill(costs, Integer.MAX_VALUE);

    costs[1] = cats[0];
    LinkedList<Integer> q = new LinkedList<>();
    q.add(1);
    boolean[] visited = new boolean[n + 1];
    boolean[] isLeaf = new boolean[n + 1];
    Arrays.fill(isLeaf, true);
    visited[1] = true;
    while (!q.isEmpty()) {
      Integer pop = q.pop();
      int cost = costs[pop];
      List<Integer> vertexes = connected.get(pop);
      if (vertexes != null) {
        for (Integer vertex : vertexes) {
          if (!visited[vertex]) {
            visited[vertex] = true;
            isLeaf[pop] = false;
            costs[vertex] = Math.min(cats[vertex - 1] == 0 ? 0 : cost + cats[vertex - 1], costs[vertex]);
            if (costs[vertex] <= m) {
              q.add(vertex);
            }
          }
        }
      }
    }
//     System.out.println("costs = " + Arrays.toString(costs));
//     System.out.println("isLeaf = " + Arrays.toString(isLeaf));
    int res = 0;
    for (int i = 2; i < costs.length; i++) {
      if (costs[i] <= m && isLeaf[i]) {
        res++;
      }
    }
    System.out.println(res);
  }

  private static void connectVertex(Map<Integer, List<Integer>> connected, int a, int b) {
    List<Integer> values = connected.get(a);
    if (values == null) {
      values = new ArrayList<>();
      connected.put(a, values);
    }
    values.add(b);
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
