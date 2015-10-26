package archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smalex on 03/10/15.
 */
public class P583D {
  public static void main(String[] args) throws Exception {
    new P583D().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(getInputStream());
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int[] dp = new int[n + 1];
    int max = 0;
    for (int i = 0; i < n; i++) {
      dp[i]= 1;
      for (int j = 0; j < i; j++) {
        if (a[j] < a[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
          max = Math.max(max, dp[i]);
        }
      }
    }
    System.out.println("a = " + Arrays.toString(a));

    System.out.println("dp = " + Arrays.toString(dp));
    System.out.println("max = " + max);
  }

  private InputStream getInputStream() throws FileNotFoundException {
    if ("smalex".equals(System.getenv("USER"))) {
      Class clazz = getClass();
      URL resource = clazz.getResource(clazz.getSimpleName() + ".in");
      if (resource == null) {
        System.out.println("file not exists");
        return System.in;
      }
      return new FileInputStream(new File(resource.getFile()));
    } else {
      return System.in;
    }
  }
}
