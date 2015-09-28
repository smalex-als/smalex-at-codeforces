import java.util.Scanner;

/**
 * Created by smalex on 28/09/15.
 */
public class P581A {
  public static void main(String[] args) throws Exception {
    new P581A().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();

    int ans0 = Math.min(a, b);
    a -= ans0;
    b -= ans0;

    int ans1 = Math.max(a, b) / 2;
    System.out.println(ans0 + " " + ans1);
  }
}
