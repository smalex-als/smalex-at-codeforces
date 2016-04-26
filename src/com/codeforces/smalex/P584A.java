package com.codeforces.smalex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by smalex on 06/10/15.
 */
public class P584A {
  public static void main(String[] args) throws Exception {
    new P584A().run();
  }

  private void run() throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int t = scanner.nextInt();

    StringBuilder sb = new StringBuilder();
    if (t == 10) {
      if (n == 1) {
        System.out.println(-1);
        return;
      }
      sb.append("1");
      for (int i = 1; i < n; i++) {
        sb.append("0");
      }
    } else {
      for (int i = 0; i < n; i++) {
        sb.append(t);
      }
    }
    System.out.println(sb.toString());
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
