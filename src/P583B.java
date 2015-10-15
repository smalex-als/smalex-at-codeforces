import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by smalex on 03/10/15.
 */
public class P583B {
  public static void main(String[] args) throws Exception {
    new P583B().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    LinkedList<Integer> a = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      a.add(scanner.nextInt());
    }
    int res = 0;
    int cnt = 0;
    while (true) {
      for (Iterator<Integer> iterator = a.iterator(); iterator.hasNext(); ) {
        Integer num = iterator.next();
        if (cnt >= num) {
          cnt++;
          iterator.remove();
        }
      }
      if (a.isEmpty()) {
        break;
      }
      Collections.reverse(a);
      res++;
    }
    System.out.println(res);
  }
}
