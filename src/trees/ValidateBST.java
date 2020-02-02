package trees;

public class ValidateBST {
    private static class Node {
        Node right;
        Node left;
        int data;
        int size;

        public Node(int data) {
            this.data = data;
        }
    }

    int index = 0;
    void copyBst(Node root, int[] array) {
        if(root == null)
            return;

        copyBst(root.left, array);
        array[index] = root.data;
        index++;
        copyBst(root.right, array);
    }

    boolean checkBST(Node root) {
        int[] array = new int[root.size];
        copyBst(root, array);
        for(int i = 1; i < array.length; i++) {
            if(array[i - 1] >= array[i] )
                return false;
        }

        return true;
    }
}
