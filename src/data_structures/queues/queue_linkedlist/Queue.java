package data_structures.queues.queue_linkedlist;

public class Queue {
    Node first;
    Node last;
    int length;

    Queue(){
        this.first = null;
        this.last = null;
        this.length++;
    }

    public Node peek(){
        return this.first;
    }

    public Boolean isEmpty(){
        return (length==0 ? true : false) ;
    }

    public void enqueue(int value){
        Node temp = new Node(value);
        if(this.length == 0){
            this.first = temp;
            this.last = temp;
        }else{
            this.last.next = temp;
            this.last = temp;
        }
        this.length++;
    }
    public Node dequeue(){
        if(this.length == 0){
            return null;
        }
        if(this.first == this.last){
            return null;
        }

        Node temp = this.first;
        this.first = this.first.next;
        this.length--;
        return temp;

    }
}
