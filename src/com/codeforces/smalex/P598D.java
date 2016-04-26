package com.codeforces.smalex;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by smalex on 13/11/15.
 */
public class P598D {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    int[][] map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String row = scanner.next();
      for (int j = 0; j < row.length(); j++) {
        map[i][j] = row.charAt(j) == '*' ? Integer.MAX_VALUE : 0;
      }
    }
    int[][] coords = new int[k][2];
    for (int i = 0; i < k; i++) {
      coords[i][0] = scanner.nextInt() - 1;
      coords[i][1] = scanner.nextInt() - 1;
    }
    int[] res = solve(map, coords);
    for (int re : res) {
      System.out.println(re);
    }
  }

  private static class Point {
    private int x;
    private int y;

    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public String toString() {
      return "Point{" +
          "y=" + y +
          ", x=" + x +
          '}';
    }
  }

  private static int[] solve(int[][] map, int[][] coords) {
    int[][] nextCoords = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int[] res = new int[coords.length];
    int[] resByColor = new int[coords.length + 2];
    int currentColor = 0;
    for (int i = 0; i < coords.length; i++) {
      int[] coord = coords[i];
      int color = map[coord[0]][coord[1]];
      if (color != 0) {
        res[i] = resByColor[color];
        continue;
      }
      currentColor++;
      LinkedList<Point> queue = new LinkedList<Point>();
      queue.add(new Point(coord[0], coord[1]));
      map[coord[0]][coord[1]] = currentColor;
      int cnt = 0;
      while (!queue.isEmpty()) {
        Point point = queue.poll();
        for (int[] nextPoint : nextCoords) {
          int ny = point.y + nextPoint[1];
          int nx = point.x + nextPoint[0];
          if (ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length) {
            if (map[ny][nx] == Integer.MAX_VALUE) {
              cnt++;
            } else {
              if (map[ny][nx] == 0) {
                queue.add(new Point(ny, nx));
                map[ny][nx] = currentColor;
              }
            }
          }
        }
      }
      resByColor[currentColor] = cnt;
      res[i] = cnt;
    }
    return res;
  }
}
