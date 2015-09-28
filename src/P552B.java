import java.util.Scanner;

/**
 * Created by smalex on 20/09/15.
 */
public class P552B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    // int res2 = check(n);
    long max = 1;
    while (n >= max) {
      max *= 10;
    }
    max /= 10;
    long res = (n - max + 1) * String.valueOf(n).length();
    long next = max - 1;
    while (next > 0) {
      long newnext = next / 10;
      res += (next - newnext) * String.valueOf(next).length();
      next = newnext;
    }
    System.out.println(res);
    // System.out.println("res2 = " + res2);
  }

  private static int check(int n) {
    int res = 0;
    for (int i = 1; i <= n; i++) {
      res += String.valueOf(i).length();
    }
    return res;
  }
}
