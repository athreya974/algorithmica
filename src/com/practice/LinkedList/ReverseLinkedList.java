package com.practice.LinkedList;

import com.interview.linklist.LinkList;
import com.practice.arrays.pivotIndex;

public class ReverseLinkedList {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ReverseLinkedList rl = new ReverseLinkedList();
        Node head = null;
        head = ll.addNode(1,head);
        head =ll.addNode(2,head);
        head =ll.addNode(3,head);
        head =ll.addNode(4,head);
        head = rl.reverseLinkedList(head);
        ll.printList(head);
    }

    private Node reverseLinkedList(Node head) {
        Node next = null,temp = null;
        while(head!=null) {
            next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}
