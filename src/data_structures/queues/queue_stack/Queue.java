package data_structures.queues.queue_stack;

import data_structures.stacks.stack_linkedlist.Node;
import data_structures.stacks.stack_linkedlist.Stack;

public class Queue {
    Stack queueStack, reverse;

    Queue(){
        queueStack = new Stack();
        reverse = new Stack();
    }

    public void push(int value){
        if(this.queueStack.length == 0){
            this.queueStack.push(value);
        }else{
            while (this.queueStack.length != 0){
                this.reverse.push(this.queueStack.pop().value);
            }
            this.reverse.push(value);
            while (this.reverse.length != 0){
                this.queueStack.push(this.reverse.pop().value);
            }
        }
    }

    public Node peek(){
        if (this.queueStack.length > 0) {
            return this.queueStack.get(this.queueStack.length - 1);
        } else {
            return null;
        }
    }

    public Node pop() {
        if (this.queueStack.length > 0) {
            return this.queueStack.pop();
        }else {
            return null;
        }
    }
    public boolean isEmpty(){ return this.queueStack.length==0;}
}
