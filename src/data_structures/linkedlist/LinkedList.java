package data_structures.linkedlist;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(int value){
        Node temp = new Node(value);
        this.tail.next = temp;
        this.tail = temp;
        this.length++;
    }

    public void prepend(int value){
        Node temp = new Node(value);
        temp.next = this.head;
        this.head = temp;
        this.length++;
    }

    public int getLength(){
        return this.length;
    }

    public void printList(){
        Node temp = this.head;
        StringBuffer list = new StringBuffer();
        while(temp.next != null){
            list.append(temp.value+"->");
            temp = temp.next;
        }
        list.append("NULL");
        System.out.println(list.toString());
    }


    public void insert(int index,int value){
        if (index < 0 || index > this.length) {
            System.err.println("Index Out Of Bounds For Length " + this.length);
        }else if(index == 0){
            this.prepend(value);
        }else  if(index == this.length){
            this.append(value);
        }else{
            Node temp = new Node(value);
            Node preNode = this.traverse(index-1);

            temp.next = preNode.next;
            preNode.next = temp;
            this.length++;

        }

    }

    public void remove(int index){
        if (index < 0 || index > this.length) {
            System.err.println("Index Out Of Bounds For Length " + this.length);
        }else if(index == 0){
            this.head = this.head.next;
            this.length--;
        }else{
            Node preNode = this.traverse(index-1);
            preNode.next = preNode.next.next;
            if(index == this.length-1){
                tail = preNode;
            }
            this.length--;

        }
    }

    public void reverse(){
        this.tail = this.head;
        Node first = this.head;
        Node second = this.head.next;

        while(second !=null){
            Node some = second.next;
            second.next = first; // reversing the pointer from (first)->(second)  to (first)<-(second)
            first = second;
            second = some;

        }
        this.head.next = null;
        this.head = first;

//        Node tt = traverse(length);
//        Node tt1 = traverse(length-1);
//        Node tt2 = traverse(length-2);
//        Node tt3 = traverse(length-3);
//        Node tt4 = traverse(length-4);
//        Node tt5 = traverse(length-5);
//        Node tt6 = traverse(length-6);

//        System.out.println(tt.value+"--"+tt1.value+"--"+tt2.value+"--"+tt3.value+"--"+tt4.value+"--"+tt5.value+"--"+tt6.value);
    }

    private Node traverse(int index){
        Node temp = this.head;
        int i = 0;
        while(temp.next != null){
            if(i == index) break;
            temp = temp.next;
            i++;
        }
        return temp;
    }
}
