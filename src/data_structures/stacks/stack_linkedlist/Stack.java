package data_structures.stacks.stack_linkedlist;

public class Stack {

    Node top;
    Node bottom;
    public int length;

    public Stack(){
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }


    public void push(int value){
        Node temp = new Node(value);
        if(this.length == 0){
            this.top = temp;
            this.bottom = temp;
        }else{
            Node holder = this.top;
            this.top = temp;
            this.top.next = holder;
        }

        this.length++;
    }

    public Node pop(){
        if(this.top == null){
            return null;
        }

        Node temp = this.top;
        this.top = this.top.next;
        this.length--;
        return temp;
    }

    public Node get(int index){
        Node temp = this.top;
        int i = 0;
        while (temp.next != null){
            if(i == index) break;
            temp = temp.next;
        }
        return temp;
    }
    public Node peek(){
        return this.top;
    }

    public Boolean isEmpty(){
        if(this.length == 0){
            return true;
        }else {
            return false;
        }
    }
}
