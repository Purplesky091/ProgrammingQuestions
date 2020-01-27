package QueuesAndStacks;

import java.util.Stack;

public class SortStack {
   void sort(Stack<Integer> answer) {
       Stack<Integer> buffer = new Stack<>();
       while(!answer.isEmpty()) {
           int tmp = answer.pop();
           while(!buffer.isEmpty() && buffer.peek() > tmp)
               answer.push(buffer.pop());

           buffer.push(tmp);
       }

       while(!buffer.isEmpty())
           answer.push(buffer.pop());
   }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {14, 12, 15, 10, 20};
        for(int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        SortStack ss = new SortStack();
        ss.sort(stack);
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}


