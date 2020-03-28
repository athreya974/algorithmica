package com.practice.Trees.BinaryTree.Traversal;

import com.practice.Trees.InputBuilder;
import com.practice.Trees.Node;

public class InorderTraversal {
    public static void main(String[]args){
        int a[] = {1,2,3,4,5,6,7,8};
        InputBuilder ib = new InputBuilder(a);
        Node root = ib.buildTree();
        InorderTraversal in = new InorderTraversal();
        in.traverseInorder(root);
        in.traverseInorderIterative(root);
    }

    private void traverseInorder(Node root) {
        if(root!=null){
            traverseInorder(root.getLeft());
            System.out.print(root.getData()+" ");
            traverseInorder(root.getRight());
        }
    }

    private void traverseInorderIterative(Node root) {
    }

}
