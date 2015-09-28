import java.util.Scanner;

/**
 * Created by smalex on 28/09/15.
 */
public class P581B {
  public static void main(String[] args) throws Exception {
    new P581B().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    int[] mh = new int[n];
    for (int i = 0; i < n; i ++) {
      a[i] = scanner.nextInt();
    }
    scanner.close();
    for (int i = n - 2; i >= 0; i--) {
      mh[i] = Math.max(a[i + 1], mh[i + 1]);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length; i++) {
      int ans = 0;
      if (a[i] <= mh[i]) {
        ans = mh[i] - a[i] + 1;
      }

      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(ans);
    }
    System.out.println(sb.toString());
  }
}
