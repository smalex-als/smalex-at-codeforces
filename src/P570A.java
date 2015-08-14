import java.util.Scanner;

/**
 * Created by smalex on 13/08/15.
 */
public class P570A {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int canditates = scanner.nextInt();
    int cities = scanner.nextInt();
    long[][] votes = new long[cities][canditates];
    for (int i = 0; i < cities; i++) {
      for (int j = 0; j < canditates; j++) {
        votes[i][j] = scanner.nextInt();
      }
    }
    int[] winnerstageon = new int[canditates];
    for (long[] votesInCity : votes) {
      int winner = 0;
      for (int j = 1; j < votesInCity.length; j++) {
        if (votesInCity[j] > votesInCity[winner]) {
          winner = j;
        }
      }
      winnerstageon[winner]++;
    }
    int finalwinner = -1;
    long finalsum = 0;
    for (int i = 0; i < winnerstageon.length; i++) {
      if (winnerstageon[i] > 0) {
        if (finalwinner == -1 || winnerstageon[i] > finalsum) {
          finalwinner = i;
          finalsum = winnerstageon[i];
        }
      }
    }
    System.out.println((finalwinner + 1));
  }
}
