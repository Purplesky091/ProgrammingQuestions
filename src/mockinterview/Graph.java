package mockinterview;

import java.util.LinkedList;

public class Graph {
    private static class Node {
        String name;
        LinkedList<Node> adjList = new LinkedList<>();
        public Node(String name) {
            this.name = name;
        }

        public void connectTo(Node otherNode) {
            adjList.add(otherNode);
        }
    }





}
