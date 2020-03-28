package com.practice.Trees.BinaryTree.Traversal;

import com.practice.Trees.InputBuilder;
import com.practice.Trees.Node;

public class PreOrderTraversal {
    public static void main(String[]args){
        int a[] = {1,2,3,4,5,6,7,8};
        InputBuilder ib = new InputBuilder(a);
        Node root = ib.buildTree();
        PreOrderTraversal pre = new PreOrderTraversal();
        pre.traversePreorder(root);
        pre.traversePreorderIterative(root);
    }


    private void traversePreorder(Node root) {
        if(root!=null){
            System.out.print(root.getData()+" ");
            traversePreorder(root.getLeft());
            traversePreorder(root.getRight());
        }
    }

    private void traversePreorderIterative(Node root) {
    }
}
