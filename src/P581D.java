import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Created by smalex on 28/09/15.
 */
public class P581D {
  private static class Logo implements Comparable<Logo> {
    private final int x;
    private final int y;
    private final char name;

    public Logo(char name, int x, int y) {
      this.name = name;
      this.x = Math.min(x, y);
      this.y = Math.max(x, y);
    }

    public char getName() {
      return name;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public String toString() {
      return "Logo{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }

    @Override
    public int compareTo(Logo o) {
      return Integer.compare(o.y, y);
    }
  }

  public static void main(String[] args) throws Exception {
    new P581D().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    List<Logo> logos = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      logos.add(new Logo((char) ('A' + i), scanner.nextInt(), scanner.nextInt()));
    }
    scanner.close();
    Collections.sort(logos);
    if (solveCase0(logos)) {
      return;
    } else if (solveCase1(logos)) {
      return;
    }
    System.out.println(-1);
  }

  private boolean solveCase1(List<Logo> logos) {
    Logo widest = logos.get(0);
    Logo b = logos.get(1);
    Logo c = logos.get(2);
    if (b.getY() + c.getY() == widest.getY() && b.getX() == c.getX() && b.getX() + widest.getX() == widest.getY()) {
      createResult(logos, widest.getY(), widest.getX(), b.getY(), c.getY(), b.getX());
      return true;
    }
    if (b.getY() + c.getX() == widest.getY() && b.getX() == c.getY() && b.getX() + widest.getX() == widest.getY()) {
      createResult(logos, widest.getY(), widest.getX(), b.getY(), c.getX(), b.getX());
      return true;
    }
    if (b.getX() + c.getY() == widest.getY() && b.getY() == c.getX() && b.getY() + widest.getX() == widest.getY()) {
      createResult(logos, widest.getY(), widest.getX(), b.getX(), c.getY(), b.getY());
      return true;
    }
    if (b.getX() + c.getX() == widest.getY() && b.getY() == c.getY() && b.getY() + widest.getX() == widest.getY()) {
      createResult(logos, widest.getY(), widest.getX(), b.getX(), c.getX(), b.getY());
      return true;
    }
    return false;
  }

  private void createResult(List<Logo> logos, int y, int x, int y1, int y2, int x0) {
    char[][] rows = new char[y][y];
    int start = 0;
    for (int i = 0; i < x; i++, start++) {
      Arrays.fill(rows[start], logos.get(0).name);
    }
    for (int i = x; i < y; i++) {
      Arrays.fill(rows[i], 0, y1, logos.get(1).name);
      Arrays.fill(rows[i], y1, y1 + y2, logos.get(2).name);
    }
    System.out.println(y);
    printRows(rows);
  }

  private boolean solveCase0(List<Logo> logos) {
    for (int i = 1; i < logos.size(); i++) {
      Logo prevLogo = logos.get(i - 1);
      Logo logo = logos.get(i);
      if (logo.getY() != prevLogo.getY()) {
        return false;
      }
    }

    int res = 0;
    for (Logo logo : logos) {
      res += logo.getX();
    }
    if (res == logos.get(0).getY()) {
      char[][] rows = new char[res][res];
      int start = 0;
      for (Logo logo : logos) {
        for (int i = 0; i < logo.getX(); i++, start++) {
          Arrays.fill(rows[start], logo.getName());
        }
      }
      System.out.println(res);
      printRows(rows);
      return true;
    }
    return false;
  }

  private void printRows(char[][] rows) {
    for (char[] row : rows) {
      System.out.println(new String(row));
    }
  }

  private InputStream getInputStream() throws FileNotFoundException {
    if ("smalex".equals(System.getenv("USER"))) {
      Class clazz = getClass();
      URL resource = clazz.getResource(clazz.getSimpleName() + ".in");
      if (resource == null) {
        System.out.println("file not exists");
        return System.in;
      }
      return new FileInputStream(new File(resource.getFile()));
    } else {
      return System.in;
    }
  }
}
