package com.practice.LinkedList;

public class FindMiddleElementLinkedList {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        FindMiddleElementLinkedList mid = new FindMiddleElementLinkedList();
        Node head = null;
        head = ll.addNode(1,head);
        head =ll.addNode(2,head);
        head =ll.addNode(3,head);
        head =ll.addNode(4,head);
        head =ll.addNode(5,head);
        Node node = mid.middleElementLinkedList(head);
        System.out.println(node.data);
    }

    private Node middleElementLinkedList(Node head) {
        Node slowPtr=head,fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr =slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }
}
