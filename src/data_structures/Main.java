package data_structures;


import data_structures.linkedlist.LinkedList;
import data_structures.trees.AVLTree;
import data_structures.trees.BinarySearchTree;


class Main{

    public static void main(String args[]){
        System.out.println("Binary tree ....");

        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.add(55);
        binaryTree.add(23);
        binaryTree.add(10);
        binaryTree.add(95);
        binaryTree.add(75);
        binaryTree.add(40);
        binaryTree.add(45);
        binaryTree.add(28);
        binaryTree.add(103);

        binaryTree.setDisplayType(1);

        binaryTree.show();
        System.out.println("Searching 40 | Result: "+binaryTree.search(40));
        binaryTree.remove(23);
        System.out.println("Searching 40 | Result: "+binaryTree.search(40));
        binaryTree.show();


        System.out.println("\n AVL tree starting ...");

        AVLTree avlTree = new AVLTree();
        avlTree.add(55);
        avlTree.add(95);
        avlTree.add(10);
        avlTree.add(2);
        avlTree.add(29);
        avlTree.add(5);
        avlTree.add(50);
        avlTree.add(44);

        avlTree.show();

        LinkedList myList = new LinkedList(1);

        myList.append(6);
        myList.append(5);
        myList.append(8);
        myList.prepend(76);
        myList.insert(5,8);
        myList.insert(3,9);
        myList.printList();
        myList.reverse();
        myList.printList();



    }
}

