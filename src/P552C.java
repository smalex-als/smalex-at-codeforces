import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smalex on 20/09/15.
 */
public class P552C {
  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    int w = scanner.nextInt();
    int m = scanner.nextInt();
    int power = 0;
    int[] numbers = new int[40];
    while (m > 0) {
      numbers[power] = m % w;
      power++;
      m /= w;
    }
    for (int i = 0; i <= power; i++) {
      if (numbers[i] != 0 && numbers[i] != 1 && numbers[i] != w - 1 && numbers[i] != w) {
        System.out.println("NO");
        return;
      } else if (numbers[i] == w - 1 || numbers[i] == w) {
        numbers[i + 1]++;
      }
    }
    System.out.println("YES");
  }
}
