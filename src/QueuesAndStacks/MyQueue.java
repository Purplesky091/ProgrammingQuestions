package QueuesAndStacks;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<>();
    }

    /*
    * remove()
    * peek()
    * size()
    * */

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T data) {
        stackNewest.push(data);
    }

    private void shiftStacks() {
        if(stackOldest.isEmpty())
            while (!stackNewest.isEmpty())
                stackOldest.push(stackNewest.pop());
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove(){
        shiftStacks();
        return stackOldest.pop();
    }
}
