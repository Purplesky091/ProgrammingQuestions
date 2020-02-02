package trees;

public class ValidateBST2 {
    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) { this.data = data; }
    }

    public Node root;

    public ValidateBST2(int data) {
        root = new Node(data);
    }

    public boolean checkBST() {
        return checkBST(root, null, null);
    }

    public boolean checkBST(Node n) {
        return checkBST(n, null, null);
    }

    public boolean checkBST(Node n, Integer min, Integer max) {
        if(n == null)
            return true;

        if (min != null && n.data <= min || max != null && n.data > max)
            return false;

        if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max))
            return false;

        return true;
    }

    public static void main(String[] args) {
        ValidateBST2 tree = new ValidateBST2(9);
        ValidateBST2.Node walker = tree.root;
        for(int i = 10; i >= 0; i--) {
            walker.left = new ValidateBST2.Node(i);
            walker = walker.left;
        }


        System.out.println("Walker is BST: " + tree.checkBST());
    }
}
