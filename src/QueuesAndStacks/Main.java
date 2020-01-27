package QueuesAndStacks;

public class Main {
    public static void main(String[] args) {
        MyQueue<String> pplInLine = new MyQueue<>();
        pplInLine.add("Ray");
        pplInLine.add("Joanne");
        pplInLine.add("Daniel");

        while(!pplInLine.isEmpty()) {
            System.out.println(pplInLine.remove());
        }
    }
}
