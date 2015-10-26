package archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Created by smalex on 03/10/15.
 */
public class P583C {
  public static void main(String[] args) throws Exception {
    new P583C().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Map<Integer, Integer> cnt = new HashMap<>();
    int[] a = new int[n * n];
    for (int i = 0; i < a.length; i++) {
      int num = scanner.nextInt();
      a[i] = num;
      Integer value = cnt.get(num);
      if (value == null) {
        value = 0;
      }
      cnt.put(num, ++value);
    }

    Arrays.sort(a);
    List<Integer> res = new ArrayList<>();
    for (int i = a.length - 1; i >= 0; i--) {
      int num = a[i];
      if (cnt.get(num) > 0) {
        for (Integer num2 : res) {
          int gcd = gcd(num2, num);
          cnt.put(gcd, cnt.get(gcd) - 2);
        }
        res.add(num);
        cnt.put(num, cnt.get(num) - 1);
      }
    }
    for (Integer re : res) {
      System.out.print(re + " ");
    }
  }

  public static int gcd(int a, int b) {
    while (b != 0) {
      int tmp = a % b;
      a = b;
      b = tmp;
    }
    return a;
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
