package data_structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AVLNode{
    int value;
    int balanceFactor;
    int height;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.balanceFactor = -1;
        this.height = 0;
    }
}

public class AVLTree {
    private AVLNode root = null;
    // 1-> in-order, 2-> pre-order, 3-> post-order
    private static int ORDER = 1;
    private static int DISPLAY_TYPE = 1;
    // 0-> DFS, 1-> BFS, 2-> LevelOrder

    public AVLTree(){

    }

    public Boolean add(int value){
        try{
            if(this.root == null)
                this.root = this.addNodeRecursive(null,value);
            else
                this.addNodeRecursive(this.root,value);

            this.balance();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public void show(){
        switch (DISPLAY_TYPE){
            case 0: this.fetchBFS(this.root);break;
            case 1: this.fetchLevel(); break;
        }
    }

    public void remove(int value){
//        deleteNode(this.root,value);
    }

    public Boolean search(int value){
//        return this.searchNode(this.root,value);
        return  true;
    }

    /**
     * private methods
     */

    private AVLNode addNodeRecursive(AVLNode current,int value){
        if(current == null){
            return new AVLNode(value);
        }
        if(value < current.value){
            current.left = this.addNodeRecursive(current.left,value);
        }
        else if(value > current.value){
            current.right = this.addNodeRecursive(current.right,value);
        }
        else{
            return current;
        }
        return current;
    }

    private void balance(){
        if(this.root != null) {
            addFactor(this.root);
        }


    }

    private int addFactor(AVLNode current){
        if(current == null){
            return 0;
        }

        int lh = 0 /*left subtree height*/,
            rh = 0 /* right subtree height */;

        if(current.left != null){
            lh = addFactor(current.left);
        }
        if(current.right != null){
            rh = addFactor(current.right);
        }

        current.height = lh>rh?lh+1:rh+1;
        current.balanceFactor = lh -rh;

        return current.height;
    }

    /**
     * Fetch in breath first search order or level order
     * @param current
     */
    private void fetchBFS(AVLNode current){
        if(current == null){
            return;
        }

        Queue<AVLNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            AVLNode node = nodes.remove();

            System.out.println("|V "+node.value+ " |H "+ node.height + " |B " + node.balanceFactor+ " |\t");
            if(node.left != null)
                nodes.add(node.left);
            if(node.right != null)
                nodes.add(node.right);
        }

    }
    private void fetchLevel(){
        List<AVLNode> nodes = new ArrayList<>();
        nodes.add(this.root);
        levelOrderTraversal(nodes,1);
    }

    private void levelOrderTraversal(List<AVLNode> nodes,int level){
        if(nodes == null || nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = this.root.height - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        this.printWhitespaces(firstSpaces);

        List<AVLNode> newNodes = new ArrayList<AVLNode>();
        for (AVLNode node : nodes) {
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
                this.printWhitespaces(firstSpaces - i);
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

    private static boolean isAllElementsNull(List<AVLNode> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
