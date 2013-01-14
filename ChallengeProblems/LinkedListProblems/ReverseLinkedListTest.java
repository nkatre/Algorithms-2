/*
 *  Tests for reverse linked list problem
 */

public class ReverseLinkedListTest {
    
    public static void main(String args[]) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Node head = Node.reverseList(Node.buildList(arr));
        for (int i = 99; i >=0; i--) {
            assert(head.val==i);
            head = head.next;
        }

        System.out.println("done");
    }
}
