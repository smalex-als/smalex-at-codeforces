import java.util.Scanner;

/**
 * Created by smalex on 14/08/15.
 */
public class P560A {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    boolean ok = false;
    for (int i = 0; i < n; i++) {
      if (scanner.nextInt() == 1) {
        ok = true;
      }
    }
    System.out.println(ok ? -1 : 1);
  }
}
