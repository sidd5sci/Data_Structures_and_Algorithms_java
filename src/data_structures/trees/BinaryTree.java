package data_structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value =value;
        right = null;
        left = null;
    }
}

class BinaryTree {

    private Node root = null;
    // 1-> in-order, 2-> pre-order, 3-> post-order
    private static int ORDER = 1;
    private static int DISPLAY_TYPE = 0;
    // 0-> DFS, 1-> BFS, 2-> LevelOrder
    public BinaryTree(){

    }
    public void setORDER(int order){
        ORDER = order;
    }
    public void setDisplayType(int dtype){
        DISPLAY_TYPE = dtype;
    }
    /**
     *
     * @param value
     * @return
     */
    public Boolean add(int value){
         try{
             if(this.root == null)
                 this.root = this.addNodeRecursive(null,value);
             else
                 this.addNodeRecursive(this.root,value);
             return true;
         }
         catch (Exception e){
             e.printStackTrace();
             return false;
         }

    }

    public void show(){
        switch (DISPLAY_TYPE){
            case 0: this.fetchDFS(this.root);break;
            case 1: this.fetchLevel(); break;
        }

    }

    public void remove(int value){
        deleteNode(this.root,value);
    }

    public Boolean search(int value){
        return this.searchNode(this.root,value);
    }



    /* private methods */

    private Node addNodeRecursive(Node current,int value){
        if(current == null){
            return new Node(value);
        }
        if(value < current.value){
            current.left = addNodeRecursive(current.left,value);
        }
        else if(value > current.value){
            current.right = addNodeRecursive(current.right,value);
        }
        else{
            return current;
        }
        return current;
    }

    /**
     * Search the node
     * @param current
     * @param value
     * @return
     */
    public Boolean searchNode(Node current,int value){
        if(current == null){
            return false;
        }

        if(current.value == value){
            return true;
        }
        else if(value < current.value){
            return searchNode(current.left,value);
        }
        else if(value > current.value){
            return searchNode(current.right,value);
        }
        return false;
    }

    /**
     * Depth first traversal of tree
     * @param current
     */
    private void fetchDFS(Node current){

        switch (ORDER){
            case 1:// InOrder
                traverseInOrder(current);
                break;
            case 2:// preOrder
                traversePreOrder(current);
                break;
            case 3://postOrder
                traversePostOrder(current);
                break;
        }
    }

    private void traverseInOrder(Node current){
        if(current == null){
            return;
        }

        if( current.left != null){
            traverseInOrder(current.left);
        }
        System.out.println(current.value);
        if(current.right != null){
            traverseInOrder(current.right);
        }
    }

    private void traversePreOrder(Node current){
        if(current == null){
            return;
        }

        System.out.println(current.value);
        if( current.left != null){
            traversePreOrder(current.left);
        }
        if(current.right != null){
            traversePreOrder(current.right);
        }
    }

    private void traversePostOrder(Node current){
        if(current == null){
            return;
        }

        if( current.left != null){
            traversePostOrder(current.left);
        }
        if(current.right != null){
            traversePostOrder(current.right);
        }
        System.out.println(current.value);

    }

    /**
     * Fetch in breath first search order or level order
     * @param current
     */
    private void fetchBFS(Node current){
        if(current == null){
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            Node node = nodes.remove();

            System.out.println(node.value);

            if(node.left != null)
                nodes.add(node.left);
            if(node.right != null)
                nodes.add(node.right);

        }

    }

    /**
     * Delete data_structures.trees.Node
     * @param current
     * @param value
     * @return
     */
    private Node deleteNode(Node current,int value){
        if(current == null){
            return null;
        }

        if(current.value == value){
            if(current.left == null && current.right == null){
                // have zero child
                return null;
            }
            if(current.left == null){
                // have exactly one child
                return current.right;
            }
            else if(current.right == null){
                // have exactly one child
                return current.left;
            }
            else if(current.left != null && current.right != null){
                // has exactly two child
                int tempValue = this.findSmallestRightChild(current.right);
                current.right = this.deleteNode(current.right, tempValue);
                current.value = tempValue;
                return current;
            }
        }
        else if(value < current.value){
            current.left = this.deleteNode(current.left,value);
        }
        else if(value > current.value){
            current.right = this.deleteNode(current.right,value);
        }

        return current;
    }

    private int findSmallestRightChild(Node current){
        return current.left == null? current.value : this.findSmallestRightChild(current.left);
    }

    private int getHeight(Node current){
        if(current == null){
            return 0;
        }

        int lh = 0 /*left subtree height*/,
                rh = 0 /* right subtree height */;

        if(current.left != null){
            lh = getHeight(current.left);
        }
        if(current.right != null){
            rh = getHeight(current.right);
        }
        return lh>rh?lh+1:rh+1;
    }

    private void fetchLevel(){
        List<Node> nodes = new ArrayList<>();
        nodes.add(this.root);
        levelOrderTraversal(nodes,1);
    }

    private void levelOrderTraversal(List<Node> nodes,int level){
        if(nodes == null || nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = this.getHeight(this.root) - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        this.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            this.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                this.printWhitespaces(firstSpaces - (i-1));
                if (nodes.get(j) == null) {
                    this.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    this.printWhitespaces(1);

                this.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    this.printWhitespaces(1);

                this.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        levelOrderTraversal(newNodes,level+1);

    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static boolean isAllElementsNull(List<Node> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}


