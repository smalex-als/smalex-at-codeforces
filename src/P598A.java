import java.util.Scanner;

/**
 * Created by smalex on 13/11/15.
 */
public class P598A {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      long res = solve(n);
      System.out.println(res);
    }
  }

  private static long solve(long n) {
    long res = (n + 1) * n / 2;
    long num = 1;
    long sum = 0;
    while (num <= n) {
      sum += num;
      num *= 2;
    }
    res -= sum;
    res -= sum;
    return res;
  }
}
