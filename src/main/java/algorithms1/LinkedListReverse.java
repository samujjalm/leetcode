package algorithms1;

public class LinkedListReverse {
  static class ListNode {
    int value;
    ListNode next;

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public ListNode getNext() {
      return next;
    }

    public void setNext(ListNode next) {
      this.next = next;
    }

    public ListNode(int value, ListNode next) {
      this.value = value;
      this.next = next;
    }
  }

  public ListNode reverseList(ListNode head) {
    if(head == null) return null;
    ListNode current = head;
    ListNode next = null;
    ListNode previous = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(0, new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));

    ListNode sam = head;
    while (sam != null) {
      System.out.println(sam.getValue());
      sam = sam.next;
    }
    System.out.println("*********");
    LinkedListReverse linkedListReverse = new LinkedListReverse();
    ListNode newHead = linkedListReverse.reverseList(head);
    while(newHead != null) {
      System.out.println(newHead.getValue());
      newHead = newHead.getNext();
    }

  }
}
