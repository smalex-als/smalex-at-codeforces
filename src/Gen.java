import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by smalex on 22/09/15.
 */
public class Gen {
  public static void main(String[] args) throws IOException {
    Writer writer = new FileWriter("test.io");
    int n = 100000;
    writer.append(n + " " + 1000 + "\n");
    for (int i = 0; i < n; i++) {
      writer.append(i + " " + i + "\n");
    }
    writer.flush();
    writer.close();
  }
}
