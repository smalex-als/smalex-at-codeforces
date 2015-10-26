package archive;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by smalex on 17/08/15.
 */
public class P558C {
  private static class Point {
    private int x;
    private int cost;

    public Point(int x, int cost) {
      this.x = x;
      this.cost = cost;
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] visited = new int[100005];
    int[] cnt = new int[100005];
    int[] steps = new int[100005];
    for (int i = 1; i <= n; i++) {
      int num2 = scanner.nextInt();
      LinkedList<Point> q = new LinkedList<Point>();
      q.add(new Point(num2, 0));
      while (!q.isEmpty()) {
        Point point = q.pop();
        int x = point.x;
        int cost = point.cost;
        if (x > 100005 || visited[x] == i) {
          continue;
        }
        visited[x] = i;
        cnt[x]++;
        steps[x] += cost;
        q.add(new Point(x * 2, cost + 1));
        q.add(new Point(x / 2, cost + 1));
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] == n) {
        if (res > steps[i]) {
          res = steps[i];
        }
      }
    }
    System.out.println(res);
  }
}
