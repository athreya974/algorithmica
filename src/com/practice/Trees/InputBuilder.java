package com.practice.Trees;

public class InputBuilder {
    Node root;
    int[] input;
    public InputBuilder(int[] a){
            input = a;
            root = new Node();
    }
    public Node buildTree(){
      return  buildTreeUtil(root,0);
    }
    private Node buildTreeUtil(Node root, int index){
        if(index> input.length-1)
            return null;
        root.setData(input[index]);
       root.setLeft(buildTreeUtil(new Node(),2*index+1));
        root.setRight(buildTreeUtil(new Node(),2*index+2));
        return root;
        }
    }

