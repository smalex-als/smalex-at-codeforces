package archive;

import java.util.Scanner;

/**
 * Created by smalex on 17/09/15.
 */
public class P579D {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int x = scanner.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = scanner.nextInt();
    }

    long mult = 1L;
    for (int i = 0; i < k; i++) {
      mult *= x;
    }
    int[] prefix = new int[n + 2];
    int[] suffix = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      prefix[i] = prefix[i - 1] | a[i];
    }
    for (int i = n; i > 0; i--) {
      suffix[i] = suffix[i + 1] | a[i];
    }
    long ans = 0;
    for (int i = 1; i <= n; i++) {
      ans = Math.max(ans, prefix[i - 1] | suffix[i + 1] | mult * a[i]);
    }
    System.out.println(ans);
  }
}
