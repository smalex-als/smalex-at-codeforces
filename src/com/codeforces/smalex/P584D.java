package com.codeforces.smalex;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by smalex on 06/10/15.
 */
public class P584D {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    if (BigInteger.valueOf(n).isProbablePrime(30)) {
      System.out.println("1");
      System.out.println(n);
      return;
    }
    int N = 1000;
    boolean[] numbers = new boolean[N];
    Arrays.fill(numbers, true);
    numbers[0] = false;
    numbers[1] = true;
    for (int i = 2; i < N; i++) {
      if (!numbers[i]) {
        continue;
      }
      for (int j = i + i; j < N; j += i) {
        numbers[j] = false;
      }
    }
    Set<Integer> primes = new LinkedHashSet<>();
    List<Integer> listPrimes = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i]) {
        primes.add(i);
        listPrimes.add(i);
      }
    }
    Map<Integer, int[]> sumprimes = new HashMap<>();
    for (int i = 0; i < listPrimes.size(); i++) {
      Integer prime1 = listPrimes.get(i);
      sumprimes.put(prime1, new int[]{prime1});
      for (int j = i; j < listPrimes.size(); j++) {
        Integer prime2 = listPrimes.get(j);
        sumprimes.put(prime1 + prime2, new int[]{prime1, prime2});
      }
    }
    int tmpn = n;
    while (true) {
      if (BigInteger.valueOf(tmpn).isProbablePrime(30)) {
        break;
      }
      tmpn--;
    }
    if (sumprimes.containsKey(n - tmpn)) {
      int[] values = sumprimes.get(n - tmpn);
      System.out.println(values.length + 1);
      System.out.print(tmpn + " ");
      for (int val : values) {
        System.out.print(val + " ");
      }
      System.out.println();
    } else {
      System.out.println(-1);
    }
  }
}
