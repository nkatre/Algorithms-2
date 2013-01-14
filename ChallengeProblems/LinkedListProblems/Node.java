/*
 * Generic LinkedList Node class for problems.
 */

public class Node {

    Node prev;
    Node next;
    int val;

    public Node(int val) {
        prev = null;
        next = null;
        this.val = val;
    }

    // Given a list of integers, build a singly-linked list.
    public static Node buildList(int[] arr) {
        Node head = new Node(arr[0]);
        Node tmp = head;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new Node(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }

    // Given a singly-linked list, reverse it. 
    public static Node reverseList(Node head) {
        if (head==null) return null;
        if (head.next==null) return head;

        Node newHead = head;
        Node next = head.next;
        newHead.next = null;
        while(next!=null) {
            Node tmp = next.next;
            next.next = newHead;
            newHead = next;
            next = tmp;
        }

        return newHead;
    }
}
