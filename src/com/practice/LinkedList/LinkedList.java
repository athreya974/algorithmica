package com.practice.LinkedList;


public class LinkedList {

    public Node addNode(int data,Node head, Object... obj){
        Node temp = head;
        Node n = null;
        if(obj.length > 0){
            n = Node.newNode(data, obj[0]);
        }else{
            n = Node.newNode(data);
        }
        if(head == null){
            return n;
        }

        while(head.next != null){
            head = head.next;
        }

        head.next = n;
        return temp;
    }
    public void printList(Node head){
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
