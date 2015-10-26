package archive;

import java.util.*;

/**
 * Created by smalex on 15/10/15.
 */
public class P588B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    for (long i = 2; i < n && n > 0L && i < 1000000L; i++) {
      if (n % (i * i) == 0L) {
        n /= i;
        i--;
      }
    }
    System.out.println(n);
  }
}
