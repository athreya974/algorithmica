package com.practice.LinkedList;

class Node{
    int data;
    Node next;
    Object obj;

    public static Node newNode(int data, Object... obj){
        Node n = new Node();
        n.data = data;
        n.next = null;
        if(obj.length > 0)
        {
            n.obj = obj[0];
        }
        return n;
    }
}
