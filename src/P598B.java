import java.util.Scanner;

/**
 * Created by smalex on 13/11/15.
 */
public class P598B {
  private static class Node {
    private final char letter;
    private Node next;
    private Node prev;

    public Node(char c) {
      letter = c;
    }

    @Override
    public String toString() {
      return "Node{" +
          "letter=" + letter +
          '}';
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    Node last = null;
    Node first = null;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Node node = new Node(c);
      if (last != null) {
        last.next = node;
        node.prev = last;
      }
      last = node;
      if (first == null) {
        first = node;
      }
    }
    int m = scanner.nextInt();
    for (int i = 0; i < m; i++) {
      int l = scanner.nextInt() - 1;
      int r = scanner.nextInt() - 1;
      int k = (scanner.nextInt() % (r - l + 1)) - 1;
      if (l != r && k >= 0) {
        first = processRequest(first, l, r, k);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (first != null) {
      sb.append(first.letter);
      first = first.next;
    }
    System.out.println(sb.toString());
  }

  private static Node processRequest(Node first, int l, int r, int k) {
    Node left = findNode(first, l);
    Node right = findNode(left, r - l);
    Node back = findNodeBack(right, k);
    Node prevLeft = left.prev;
    Node nextRight = right.next;
    Node prevBack = back.prev;
    if (prevLeft != null) {
      prevLeft.next = back;
    } else {
      first = back;
    }
    back.prev = prevLeft;
    if (nextRight != null) {
      nextRight.prev = prevBack;
    }
    prevBack.next = nextRight;
    right.next = left;
    left.prev = right;
    return first;
  }

  private static Node findNode(Node first, int index) {
    while (index > 0) {
      first = first.next;
      index--;
    }
    return first;
  }

  private static Node findNodeBack(Node first, int index) {
    while (index > 0) {
      first = first.prev;
      index--;
    }
    return first;
  }
}
