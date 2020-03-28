package com.practice.Trees.BinaryTree.Traversal;

import com.practice.Trees.InputBuilder;
import com.practice.Trees.Node;

public class PostOrderTraversal {
    public static void main(String[]args){
    int a[] = {1,2,3,4,5,6,7,8};
    InputBuilder ib = new InputBuilder(a);
    Node root = ib.buildTree();
    PostOrderTraversal post = new PostOrderTraversal();
        post.traversePostOrder(root);
        post.traversePostorderIterative(root);
}

    private void traversePostOrder(Node root) {
        if(root!=null){
            traversePostOrder(root.getLeft());
            traversePostOrder(root.getRight());
            System.out.print(root.getData()+" ");
        }
    }
    private void traversePostorderIterative(Node root) {
    }
}
