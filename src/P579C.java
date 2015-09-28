import java.util.Scanner;

/**
 * Created by smalex on 17/09/15.
 */
public class P579C {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    if (a < b) {
      System.out.println(-1);
      return;
    }
    a += b;
    int k = a / (2 * b);
    double res = a / (2.0 * k);
    System.out.println(res);
  }
}
