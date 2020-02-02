package linkedlists;

public class KthToLast {
    private static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    Node nthToLast(Node head, int k) {
        Node pointer1 = head;
        Node pointer2 = head;

        for(int i = 0; i < k; i++) {
            if(pointer2 == null)
                return null;
            pointer2 = pointer2.next;
        }

        while(pointer2 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
