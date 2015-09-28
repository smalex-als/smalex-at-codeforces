import java.util.*;

/**
 * Created by smalex on 17/09/15.
 */
public class P579B {
  private static class Team implements Comparable<Team> {
    int value;
    int a;
    int b;

    public Team(int value, int a, int b) {
      this.value = value;
      this.a = a;
      this.b = b;
    }

    @Override
    public int compareTo(Team o) {
      return Integer.compare(o.value, value);
    }

    @Override
    public String toString() {
      return "Team{" +
          "value=" + value +
          ", a=" + a +
          ", b=" + b +
          '}';
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Team> teams = new ArrayList<>();
    for (int j = 2; j <= 2 * n; j++) {
      for (int i = 1; i <= j - 1; i++) {
        teams.add(new Team(scanner.nextInt(), j, i));
      }
    }
    Collections.sort(teams);
    int[] used = new int[n * 2 + 1];
    for (Team team : teams) {
      if (used[team.a] == 0 && used[team.b] == 0) {
        used[team.b] = team.a;
        used[team.a] = team.b;
      }
    }
    for (int i = 1; i < used.length; i++) {
      System.out.print(used[i]);
      System.out.print(" ");
    }
  }
}
