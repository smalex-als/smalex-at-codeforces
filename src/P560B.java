import java.util.Scanner;

/**
 * Created by smalex on 14/08/15.
 */
public class P560B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a1 = scanner.nextInt();
    int b1 = scanner.nextInt();
    int a2 = scanner.nextInt();
    int b2 = scanner.nextInt();
    int a3 = scanner.nextInt();
    int b3 = scanner.nextInt();
    for (int k = 0; k < 2; k++) {
      a1 = returnFirst(b1, b1 = a1);
      for (int i = 0; i < 2; i++) {
        a2 = returnFirst(b2, b2 = a2);
        for (int j = 0; j < 2; j++) {
          a3 = returnFirst(b3, b3 = a3);
          if (b1 >= b2 && b1 >= b3 && a1 >= a2 + a3) {
            System.out.println("YES");
            return;
          }
        }
      }
    }
    System.out.println("NO");
  }

  static int returnFirst(int x, int y) {
      return x;
  }
}
