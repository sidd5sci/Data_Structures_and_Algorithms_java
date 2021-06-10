package data_structures.stacks.stack_array;


import java.util.ArrayList;
import java.util.List;

public class Stack {
    List<Integer> stackArray;

    Stack(){
        this.stackArray = new ArrayList<>();
    }


    public void push(int value){
        this.stackArray.add(value);
    }

    public int pop(){
        return this.stackArray.remove(this.stackArray.size()-1);
    }

    public Integer peek(){
        if(this.stackArray.size() >0 ){
            return this.stackArray.get(this.stackArray.size() - 1);
        }else{
            return null;
        }

    }

    public Boolean isEmpty(){
        return this.stackArray.isEmpty();
    }
}

