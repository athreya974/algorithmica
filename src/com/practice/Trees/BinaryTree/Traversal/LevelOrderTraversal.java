package com.practice.Trees.BinaryTree.Traversal;

import com.practice.Trees.InputBuilder;
import com.practice.Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

private Queue queue = new LinkedList();
    private void traverseLevelOrder(Node root) {
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = (Node) queue.poll();
            System.out.print(temp.getData() +" ");
            if(temp.getLeft()!=null){
                queue.add(temp.getLeft());
            }
             if(temp.getRight()!=null){
                queue.add(temp.getRight());
            }
        }
    }

    public static void main(String[]args){
        int a[] = {1,2,3,4,5,6,7,8};
        InputBuilder ib = new InputBuilder(a);
        Node root = ib.buildTree();
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.traverseLevelOrder(root);
    }
}
